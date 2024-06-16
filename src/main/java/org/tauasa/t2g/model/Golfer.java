package org.tauasa.t2g.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "golfer")
public class Golfer implements Serializable{

	@Id 
	@GeneratedValue
	private Long id;
	private String email, firstName, lastName;

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
}
