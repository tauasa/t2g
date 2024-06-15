package org.tauasa.t2g.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tauasa.t2g.model.Scorecard;

public interface ScorecardRepository extends JpaRepository<Scorecard, Long> {

}
