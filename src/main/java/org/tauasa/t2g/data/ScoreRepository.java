package org.tauasa.t2g.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tauasa.t2g.model.Score;
import org.tauasa.t2g.model.ScoreId;

public interface ScoreRepository extends JpaRepository<Score, ScoreId> {

    public List<Score> findByScorecardIdGolferId(Long golfId);

    public List<Score> findByScorecardIdTeeIdAndScorecardIdTeeTime(Long teeId, Date teeTime);

    public Score findByScorecardId(ScoreId id);

}
