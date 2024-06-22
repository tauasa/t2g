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
import org.tauasa.t2g.data.ScoreRepository;
import org.tauasa.t2g.model.Score;
import org.tauasa.t2g.model.ScoreId;
import org.tauasa.t2g.util.Utils;

import jakarta.validation.Valid;

// tag::main[]
@RestController
public class ScoreController {

	private static final Logger log = LoggerFactory.getLogger(ScoreController.class);

	private final ScoreRepository scoreRepository;
	private final ScoreAssembler scoreAssembler;

	public ScoreController(ScoreRepository scoreRepository, ScoreAssembler scoreAssembler) {
		this.scoreRepository = scoreRepository;
		this.scoreAssembler = scoreAssembler;
	}

	@GetMapping("/scores")
	public CollectionModel<EntityModel<Score>> all() {
		List<EntityModel<Score>> scores = scoreRepository.findAll().stream() //
				.map(scoreAssembler::toModel) //
				.collect(Collectors.toList());

		log.debug("Scores: {}", scores.size());

		return CollectionModel.of(scores, //
				linkTo(methodOn(ScoreController.class).all()).withSelfRel());
	}

	@GetMapping("/scores?golfer={golferId}")
	public CollectionModel<EntityModel<Score>> scoresForGolfer(@PathVariable Long golferId) {
		List<EntityModel<Score>> scores = scoreRepository.findByScoreIdGolferId(golferId).stream() //
				.map(scoreAssembler::toModel) //
				.collect(Collectors.toList());

		log.debug("Found {} scores for golfer {}", scores.size(), golferId);

		return CollectionModel.of(scores, //
				linkTo(methodOn(GolferController.class).one(golferId)).withSelfRel(),		
				linkTo(methodOn(ScoreController.class).scoresForGolfer(golferId)).withSelfRel());
	}

	@GetMapping("/scores/{teeId}/{teeTime}/{golferId}")
	public EntityModel<Score> one(@PathVariable Long teeId, @PathVariable String teeTime, @PathVariable Long golferId) {
		ScoreId id = new ScoreId(teeId, Utils.parseTeeTime(teeTime), golferId);
		Score score = scoreRepository.findByScoreId(id);
		if(score==null){
			log.debug("No course matching {}", id.toString());
			throw new NotFoundException(teeId, teeTime, golferId);
		}

		log.debug(": {}", score.toString());

		return scoreAssembler.toModel(score);
	}

	@PostMapping("/scores")
	public ResponseEntity<EntityModel<Score>> newScore(@Valid @RequestBody Score score) {
		Score newScore = scoreRepository.save(score);
		log.debug("New score: {}", score.toString());
		return ResponseEntity //
				.created(linkTo(methodOn(ScoreController.class).updateScore(newScore)).toUri()) //
				//.accepted()
				.body(scoreAssembler.toModel(newScore));
	}

	@PutMapping("/scores")
	public ResponseEntity<EntityModel<Score>> updateScore(@Valid @RequestBody Score score) {
		ScoreId id = score.getScoreId();
		return ResponseEntity //
				.created(linkTo(methodOn(ScoreController.class).one(id.getTeeId(), 
				Utils.formatTeeTime(id.getTeeTime()), id.getGolferId())).toUri()) //
				.body(scoreAssembler.toModel(scoreRepository.save(score)));
	}
	
}
