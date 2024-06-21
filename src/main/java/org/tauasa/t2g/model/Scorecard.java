package org.tauasa.t2g.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scorecard implements Serializable{

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
    
}
