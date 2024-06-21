package org.tauasa.t2g.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tauasa.t2g.data.ScorecardRepository;
import org.tauasa.t2g.model.Scorecard;

// tag::main[]
@RestController
public class ScorecardController {

	private static final Logger log = LoggerFactory.getLogger(ScorecardController.class);

	private final ScorecardRepository scorecardRepository;
	private final ScorecardAssembler scorecardAssembler;

	public ScorecardController(ScorecardRepository scorecardRepository, ScorecardAssembler scorecardAssembler) {
		this.scorecardRepository = scorecardRepository;
		this.scorecardAssembler = scorecardAssembler;
	}

	@GetMapping("/scorecards")
	public CollectionModel<EntityModel<Scorecard>> all() {
		List<EntityModel<Scorecard>> scorecards = scorecardRepository.findAll().stream() //
				.map(scorecardAssembler::toModel) //
				.collect(Collectors.toList());

		log.debug("Scorescards: {}", scorecards.size());

		return CollectionModel.of(scorecards, //
				linkTo(methodOn(ScorecardController.class).all()).withSelfRel());
	}

	@GetMapping("/scorecards/{id}")
	public EntityModel<Scorecard> one(@PathVariable Long id) {
		Scorecard scorecard = scorecardRepository.findById(id) //
				.orElseThrow(() -> new NotFoundException(id));

		log.debug("Scorecard: {}", scorecard.toString());

		return scorecardAssembler.toModel(scorecard);
	}
	
}
