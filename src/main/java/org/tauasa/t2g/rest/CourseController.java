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
import org.tauasa.t2g.data.CourseRepository;
import org.tauasa.t2g.model.Course;

// tag::main[]
@RestController
public class CourseController {

	private static final Logger log = LoggerFactory.getLogger(CourseController.class);

	private final CourseRepository courseRepository;
	private final CourseModelAssembler courseAssembler;

	public CourseController(CourseRepository courseRepository, CourseModelAssembler assembler) {
		this.courseRepository = courseRepository;
		this.courseAssembler = assembler;
	}

	@GetMapping("/courses")
	public CollectionModel<EntityModel<Course>> all() {
		List<EntityModel<Course>> courses = courseRepository.findAll().stream() //
				.map(courseAssembler::toModel) //
				.collect(Collectors.toList());

		log.debug("Num Courses: {}", courses.size());

		return CollectionModel.of(courses, //
				linkTo(methodOn(CourseController.class).all()).withSelfRel());
	}

	@GetMapping("/courses/{id}")
	public EntityModel<Course> one(@PathVariable Long id) {
		Course course = courseRepository.findById(id) //
				.orElseThrow(() -> new CourseNotFoundException(id));

		log.debug("Course: {}", course.toString());

		return courseAssembler.toModel(course);
	}

	@PostMapping("/courses")
	public ResponseEntity<EntityModel<Course>> newCourse(@RequestBody Course course) {
		Course newCourse = courseRepository.save(course);
		log.debug("New course: {}", course.toString());
		return ResponseEntity //
				.created(linkTo(methodOn(CourseController.class).one(newCourse.getId())).toUri()) //
				.body(courseAssembler.toModel(newCourse));
	}

	@PutMapping("/courses")
	public ResponseEntity<EntityModel<Course>> updateCourse(@RequestBody Course course) {
		return ResponseEntity //
				.created(linkTo(methodOn(CourseController.class).one(course.getId())).toUri()) //
				.body(courseAssembler.toModel(courseRepository.save(course)));
	}
	// end::main[]

}
