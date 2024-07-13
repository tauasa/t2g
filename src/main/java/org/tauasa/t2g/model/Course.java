package org.tauasa.t2g.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "course")
/**
 * A unique golf course with an id, name, and a bi-directional one-to-many set of one or more {@link Tee} objects
*/
public class Course implements Serializable{

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseId")
    @SequenceGenerator(name = "courseId", sequenceName = "course_seq")
    private Long id;

	@NotBlank
	private String name;

	@OneToMany(
        mappedBy = "course",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
		fetch = FetchType.EAGER
    )
	private Set<Tee> tees;

	@NotNull
	@Embedded
	@AttributeOverrides({
  		@AttributeOverride(name = "city", column = @Column(name = "city")),
		@AttributeOverride(name = "state", column = @Column(name = "state"))
	})
	private Location location = new Location();

	public Course() {}

	public Course(String name, Location location) {
		this.name = name;
		this.location=location;
	}

	public void add(Tee tee){
		if(tees==null){
			tees = new HashSet<>();
		}
		tee.setCourse(this);
		tees.add(tee);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Course))
			return false;
		Course course = (Course) o;
		return Objects.equals(this.id, course.id) && Objects.equals(this.name, course.name) && Objects.equals(this.location, course.location);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.location);
	}

	@Override
	public String toString() {
		return String.format("Course{id: %d, name: %s, location: %s}", this.id, this.name, this.location);
	}

}
