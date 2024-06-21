package org.tauasa.t2g.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "scorecard")
public class Scorecard implements Serializable{

    @Id 
	@GeneratedValue
	private Long id;

    @OneToMany(
        mappedBy = "scoreId.teeId",
        cascade = CascadeType.REMOVE,
        orphanRemoval = true,
		fetch = FetchType.EAGER
    )
    private Set<Score> scores;

    public Scorecard(){}

    public Scorecard(Set<Score> scores){
        this.scores=scores;
    }

    public void add(Score score){
        if(scores==null){
            scores = new HashSet<>();
        }
        scores.add(score);
    }

    @Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Scorecard))
			return false;
        Scorecard sc = (Scorecard) o;
		return Objects.equals(this.id, sc.id) && Objects.equals(this.scores, sc.scores);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.scores);
	}

	@Override
	public String toString() {
		return String.format("Scorecard{id: %d, scores: %d}", this.id, this.scores==null?0:this.scores.size());
	}
    
}
