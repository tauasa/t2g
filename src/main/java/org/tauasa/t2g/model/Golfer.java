package org.tauasa.t2g.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "golfer")
public class Golfer{

	@Id 
	@GeneratedValue
	private Long id;
	@Email
	private String email;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;

	@JsonIgnore
	@OneToMany(
        mappedBy = "golfer",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
		fetch = FetchType.LAZY
    )
	private List<Score> scores;

	public Golfer() {}

	public Golfer(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Golfer))
			return false;
		Golfer golfer = (Golfer) o;
		return Objects.equals(this.id, golfer.id) && Objects.equals(this.firstName, golfer.firstName)
				&& Objects.equals(this.lastName, golfer.lastName) && Objects.equals(this.email, golfer.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.email, this.firstName, this.lastName);
	}

	@Override
	public String toString() {
		return "Golfer{" + "id=" + this.id + '\'' + ", email='" + this.email + '\''  + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + "}'";
	}

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

	public void add(Score score){
		if(scores==null){
			scores = new ArrayList<>();
		}
		score.setGolfer(this);
		scores.add(score);
	}
}
