package org.tauasa.t2g.rest;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;
import org.tauasa.t2g.model.Score;

@Component
public class ScorecardModelAssembler implements RepresentationModelAssembler<Score, EntityModel<Score>> {

	@SuppressWarnings("null")
	@Override
	public EntityModel<Score> toModel(Score score) {
		// Unconditional links to single-item resource and aggregate root
		EntityModel<Score> scoreModel = EntityModel.of(score, 
				linkTo(methodOn(GolferController.class).one(score.getScorecardId().getGolferId())).withRel("golfer"),
				linkTo(methodOn(ScorecardController.class).scorecardsForGolfer(score.getScorecardId().getGolferId())).withRel("scores"),
				linkTo(methodOn(CourseController.class).all()).withRel("courses"));

		return scoreModel;
	}
}
