package org.tauasa.t2g.rest;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;
import org.tauasa.t2g.model.Course;

@Component
public class CourseModelAssembler implements RepresentationModelAssembler<Course, EntityModel<Course>> {

	@SuppressWarnings("null")
	@Override
	public EntityModel<Course> toModel(Course course) {
		// Unconditional links to single-item resource and aggregate root
		EntityModel<Course> courseModel = EntityModel.of(course, 
				linkTo(methodOn(CourseController.class).one(course.getId())).withSelfRel(),
				linkTo(methodOn(CourseController.class).all()).withRel("courses"));
				
				//TODO - add links to existing scorecards

		return courseModel;
	}
}
