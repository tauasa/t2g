package org.tauasa.t2g.rest;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;
import org.tauasa.t2g.model.Golfer;

@Component
public class GolferModelAssembler implements RepresentationModelAssembler<Golfer, EntityModel<Golfer>> {

	@SuppressWarnings("null")
	@Override
	public EntityModel<Golfer> toModel(Golfer golfer) {
		return EntityModel.of(golfer, //
				linkTo(methodOn(GolferController.class).one(golfer.getId())).withSelfRel(),
				linkTo(methodOn(ScorecardController.class).scorecardsForGolfer(golfer.getId()) ).withRel("scores"),
				linkTo(methodOn(CourseController.class).all()).withRel("courses"));
	}
}
