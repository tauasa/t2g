package org.tauasa.t2g.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tauasa.t2g.data.ScorecardRepository;
import org.tauasa.t2g.model.Scorecard;

// tag::main[]
@RestController
public class ScorecardController {

	private static final Logger log = LoggerFactory.getLogger(ScorecardController.class);

	private final ScorecardRepository scorecardRepository;
	private final ScorecardModelAssembler scorecardAssembler;

	public ScorecardController(ScorecardRepository scorecardRepository, ScorecardModelAssembler scorecardAssembler) {
		this.scorecardRepository = scorecardRepository;
		this.scorecardAssembler = scorecardAssembler;
	}

	@GetMapping("/scorecards")
	public CollectionModel<EntityModel<Scorecard>> all() {
		List<EntityModel<Scorecard>> scorecards = scorecardRepository.findAll().stream() //
				.map(scorecardAssembler::toModel) //
				.collect(Collectors.toList());

		log.debug("Num Courses: {}", scorecards.size());

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

	@PostMapping("/scorecards")
	public ResponseEntity<EntityModel<Scorecard>> newScorecard(@RequestBody Scorecard scorecard) {
		Scorecard newScorecard = scorecardRepository.save(scorecard);
		log.debug("New scorecard: {}", scorecard.toString());
		return ResponseEntity //
				.created(linkTo(methodOn(CourseController.class).one(newScorecard.getId())).toUri()) //
				.body(scorecardAssembler.toModel(newScorecard));
	}

	@PutMapping("/scorecards")
	public ResponseEntity<EntityModel<Scorecard>> updateScorecard(@RequestBody Scorecard scorecard) {
		return ResponseEntity //
				.created(linkTo(methodOn(ScorecardController.class).one(scorecard.getId())).toUri()) //
				.body(scorecardAssembler.toModel(scorecardRepository.save(scorecard)));
	}
	// end::main[]

}
