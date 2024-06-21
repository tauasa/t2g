package org.tauasa.t2g.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tauasa.t2g.data.GolferRepository;
import org.tauasa.t2g.model.Golfer;

import jakarta.validation.Valid;

// tag::constructor[]
@RestController
public class GolferController {

	private final GolferRepository golferRepository;

	private final GolferModelAssembler golferAssembler;

	public GolferController(GolferRepository golferRepository, GolferModelAssembler golferAssembler) {
		this.golferRepository = golferRepository;
		this.golferAssembler = golferAssembler;
	}

	// Aggregate root
	@GetMapping("/golfers")
	public CollectionModel<EntityModel<Golfer>> all() {
		List<EntityModel<Golfer>> golfers = golferRepository.findAll().stream() //
				.map(golferAssembler::toModel) //
				.collect(Collectors.toList());

		return CollectionModel.of(golfers, linkTo(methodOn(GolferController.class).all()).withSelfRel());
	}

	@GetMapping("/golfers/{id}")
	public EntityModel<Golfer> one(@PathVariable Long id) {
		Golfer golfer = golferRepository.findById(id) //
				.orElseThrow(() -> new NotFoundException(id));
		return golferAssembler.toModel(golfer);
	}

	@PostMapping("/golfers")
	public ResponseEntity<?> newGolfer(@Valid @RequestBody Golfer newGolfer) {
		EntityModel<Golfer> entityModel = golferAssembler.toModel(golferRepository.save(newGolfer));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	}

	@PutMapping("/golfers/{id}")
	public ResponseEntity<?> updateGolfer(@Valid @RequestBody Golfer newGolfer, @PathVariable Long id) {
		Golfer updatedGolfer = golferRepository.findById(id) //
				.map(golfer -> {
					golfer.setEmail(newGolfer.getEmail());
					golfer.setFirstName(newGolfer.getFirstName());
					golfer.setLastName(newGolfer.getLastName());
					return golferRepository.save(golfer);
				}) //
				.orElseGet(() -> {
					return golferRepository.save(newGolfer);
				});

		EntityModel<Golfer> entityModel = golferAssembler.toModel(updatedGolfer);

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	}

	@DeleteMapping("/golfers/{id}")
	public ResponseEntity<?> deleteGolfer(@PathVariable Long id) {
		golferRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
