package org.tauasa.t2g.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tauasa.t2g.model.Scorecard;
import org.tauasa.t2g.model.ScorecardId;

public interface ScorecardRepository extends JpaRepository<Scorecard, ScorecardId> {

    public List<Scorecard> findByScorecardIdGolferId(Long golfId);

    public List<Scorecard> findByScorecardIdTeeIdAndScorecardIdTeeTime(Long teeId, Date teeTime);

    public Scorecard findByScorecardId(ScorecardId id);

}
