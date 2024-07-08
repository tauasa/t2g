package org.tauasa.t2g.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	// TODO - address/location

	public Course() {}

	public Course(String name) {
		this.name = name;
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
		return Objects.equals(this.id, course.id) && Objects.equals(this.name, course.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}

	@Override
	public String toString() {
		return String.format("Course{id: %d, name: %s}", this.id, this.name);
	}

}
