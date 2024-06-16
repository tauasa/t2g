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

// tag::main[]
@RestController
public class ScoreController {

	private static final Logger log = LoggerFactory.getLogger(ScoreController.class);

	private final ScoreRepository scoreRepository;
	private final ScoreModelAssembler scoreAssembler;

	public ScoreController(ScoreRepository scoreRepository, ScoreModelAssembler scoreAssembler) {
		this.scoreRepository = scoreRepository;
		this.scoreAssembler = scoreAssembler;
	}

	@GetMapping("/scores")
	public CollectionModel<EntityModel<Score>> all() {
		List<EntityModel<Score>> scores = scoreRepository.findAll().stream() //
				.map(scoreAssembler::toModel) //
				.collect(Collectors.toList());

		log.debug("Num scores: {}", scores.size());

		return CollectionModel.of(scores, //
				linkTo(methodOn(ScoreController.class).all()).withSelfRel());
	}//*/

	@GetMapping("/scores/golfer/{golferId}")
	public CollectionModel<EntityModel<Score>> scoresForGolfer(@PathVariable Long golferId) {
		List<EntityModel<Score>> scores = scoreRepository.findByGolferId(golferId).stream() //
				.map(scoreAssembler::toModel) //
				.collect(Collectors.toList());

		log.debug("Founmd {} scores for golfer {}", scores.size(), golferId);

		return CollectionModel.of(scores, //
				linkTo(methodOn(ScoreController.class).scoresForGolfer(golferId)).withSelfRel(),
				linkTo(methodOn(GolferController.class).all()).withSelfRel());
	}

	@GetMapping("/scores/{id}")
	public EntityModel<Score> one(@PathVariable Long id) {
		Score score = scoreRepository.findById(id) //
				.orElseThrow(() -> new NotFoundException(id));

		log.debug("Score: {}", score.toString());

		return scoreAssembler.toModel(score);
	}

	@PostMapping("/scores")
	public ResponseEntity<EntityModel<Score>> newScore(@RequestBody Score score) {
		Score newScore = scoreRepository.save(score);
		log.debug("New score: {}", score.toString());
		return ResponseEntity //
				.created(linkTo(methodOn(CourseController.class).one(newScore.getId())).toUri()) //
				.body(scoreAssembler.toModel(newScore));
	}

	@PutMapping("/scores")
	public ResponseEntity<EntityModel<Score>> updateScore(@RequestBody Score score) {
		return ResponseEntity //
				.created(linkTo(methodOn(ScoreController.class).one(score.getId())).toUri()) //
				.body(scoreAssembler.toModel(scoreRepository.save(score)));
	}
	// end::main[]

}
