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
	public EntityModel<Scorecard> toModel(Scorecard scorecard) {
		// Unconditional links to single-item resource and aggregate root
		EntityModel<Scorecard> scorecardModel = EntityModel.of(scorecard, 
				linkTo(methodOn(ScorecardController.class).one(scorecard.getId())).withSelfRel(),
				linkTo(methodOn(ScorecardController.class).all()).withRel("scorecards"));
				
				//TODO - add links to existing scorecards

		return scorecardModel;
	}
}
