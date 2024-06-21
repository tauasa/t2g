package org.tauasa.t2g.rest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tauasa.t2g.data.ScoreRepository;
import org.tauasa.t2g.model.Score;
import org.tauasa.t2g.model.ScoreId;

import jakarta.validation.Valid;

// tag::main[]
@RestController
public class ScorecardController {

	private static final Logger log = LoggerFactory.getLogger(ScorecardController.class);

	private final ScoreRepository scorecardRepository;
	private final ScorecardModelAssembler scorecardAssembler;

	public ScorecardController(ScoreRepository scorecardRepository, ScorecardModelAssembler scorecardAssembler) {
		this.scorecardRepository = scorecardRepository;
		this.scorecardAssembler = scorecardAssembler;
	}

	@GetMapping("/scorecards")
	public CollectionModel<EntityModel<Score>> all() {
		List<EntityModel<Score>> scores = scorecardRepository.findAll().stream() //
				.map(scorecardAssembler::toModel) //
				.collect(Collectors.toList());

		log.debug("Num scores: {}", scores.size());

		return CollectionModel.of(scores, //
				linkTo(methodOn(ScorecardController.class).all()).withSelfRel());
	}

	@GetMapping("/scorecards?golfer={golferId}")
	public CollectionModel<EntityModel<Score>> scorecardsForGolfer(@PathVariable Long golferId) {
		List<EntityModel<Score>> scores = scorecardRepository.findByScorecardIdGolferId(golferId).stream() //
				.map(scorecardAssembler::toModel) //
				.collect(Collectors.toList());

		log.debug("Found {} scores for golfer {}", scores.size(), golferId);

		return CollectionModel.of(scores, //
				linkTo(methodOn(GolferController.class).one(golferId)).withSelfRel(),		
				linkTo(methodOn(ScorecardController.class).scorecardsForGolfer(golferId)).withSelfRel());
	}

	@GetMapping("/scorecards/{teeId}/{teeTime}/{golferId}")
	public EntityModel<Score> one(@PathVariable Long teeId, @PathVariable Date teeTime, @PathVariable Long golferId) {
		Score score = scorecardRepository.findByScorecardId(new ScoreId(teeId, teeTime, golferId));
		if(score==null){
			log.debug("No course matching {}-{}-{}", teeId, teeTime, golferId);
			throw new NotFoundException(teeId, teeTime, golferId);
		}

		log.debug("Scorecard: {}", score.toString());

		return scorecardAssembler.toModel(score);
	}

	@PostMapping("/scorecards")
	public ResponseEntity<EntityModel<Score>> newScorecard(@Valid @RequestBody Score scorecard) {
		Score newScore = scorecardRepository.save(scorecard);
		log.debug("New score: {}", scorecard.toString());
		return ResponseEntity //
				//.created(linkTo(methodOn(CourseController.class).findByTee(newScore.getId().getTeeId())).toUri()) //
				.accepted()
				.body(scorecardAssembler.toModel(newScore));
	}

	@PutMapping("/scorecards")
	public ResponseEntity<EntityModel<Score>> updateScorecard(@Valid @RequestBody Score scorecard) {
		ScoreId id = scorecard.getScorecardId();
		return ResponseEntity //
				.created(linkTo(methodOn(ScorecardController.class).one(id.getTeeId(), id.getTeeTime(), id.getGolferId())).toUri()) //
				.body(scorecardAssembler.toModel(scorecardRepository.save(scorecard)));
	}

	@DeleteMapping("/scorecards/{id}")
	public ResponseEntity<?> deleteGolfer(@PathVariable ScoreId id) {

		scorecardRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
	// end::main[]

}
