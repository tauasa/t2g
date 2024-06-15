package org.tauasa.t2g.rest;

import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

	@GetMapping
	public RepresentationModel<?> index() {
		RepresentationModel<?> rootModel = new RepresentationModel<>();
		rootModel.add(linkTo(methodOn(GolferController.class).all()).withRel("golfers"));
		rootModel.add(linkTo(methodOn(CourseController.class).all()).withRel("courses"));
		return rootModel;
	}

}
