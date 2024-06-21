package org.tauasa.t2g.rest;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;
import org.tauasa.t2g.model.Scorecard;

@Component
public class ScorecardAssembler implements RepresentationModelAssembler<Scorecard, EntityModel<Scorecard>> {

	@SuppressWarnings("null")
	@Override
	public EntityModel<Scorecard> toModel(Scorecard scorecard) {
		// Unconditional links to single-item resource and aggregate root
		EntityModel<Scorecard> scoreModel = EntityModel.of(scorecard, 
				linkTo(methodOn(ScorecardController.class).one(scorecard.getId())).withRel("scorecard"));

		return scoreModel;
	}
}
