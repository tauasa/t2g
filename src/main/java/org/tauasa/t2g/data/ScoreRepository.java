package org.tauasa.t2g.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tauasa.t2g.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    public List<Score> findByGolferId(Long golferId);

    public List<Score> findByTeeIdAndTeeTime(Long teeId, Date teeTime);

    public Score findByTeeIdAndTeeTimeAndGolferId(Long teeId, Date teeTime, Long golferId);

}
