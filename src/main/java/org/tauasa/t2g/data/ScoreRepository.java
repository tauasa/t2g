package org.tauasa.t2g.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tauasa.t2g.model.Score;
import org.tauasa.t2g.model.ScoreId;

public interface ScoreRepository extends JpaRepository<Score, ScoreId> {

    public Score findByScoreId(ScoreId scoreId);

    public List<Score> findByScoreIdGolferId(Long golfId);

    /**
     * Returns all the Score objects for a specific tee time
    */
    public List<Score> findByScoreIdTeeIdAndScoreIdTeeTime(Long teeId, Date teeTime);

}
