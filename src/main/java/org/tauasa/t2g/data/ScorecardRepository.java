package org.tauasa.t2g.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tauasa.t2g.model.Scorecard;
//import java.util.Date;


public interface ScorecardRepository extends JpaRepository<Scorecard, Long> {

    //public Scorecard findByTeeTime(Date teeTime);
    
}
