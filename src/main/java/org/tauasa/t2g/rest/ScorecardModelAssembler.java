package org.tauasa.t2g.rest;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;
import org.tauasa.t2g.model.Scorecard;

@Component
public class ScorecardModelAssembler implements RepresentationModelAssembler<Scorecard, EntityModel<Scorecard>> {

	@SuppressWarnings("null")
	@Override
	public EntityModel<Scorecard> toModel(Scorecard score) {
		// Unconditional links to single-item resource and aggregate root
		EntityModel<Scorecard> scoreModel = EntityModel.of(score, 
				linkTo(methodOn(GolferController.class).one(score.getScorecardId().getGolferId())).withRel("golfer"),
				linkTo(methodOn(ScorecardController.class).scorecardsForGolfer(score.getScorecardId().getGolferId())).withRel("scores"),
				linkTo(methodOn(CourseController.class).all()).withRel("courses"));

		return scoreModel;
	}
}
