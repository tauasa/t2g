package org.tauasa.t2g.data;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tauasa.t2g.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    public List<Score> findByGolferId(Long golferId);

    public List<Score> findByTeeIdAndTeeTime(Long teeId, LocalDateTime teeTime);

    public Score findByTeeIdAndTeeTimeAndGolferId(Long teeId, LocalDateTime teeTime, Long golferId);

}
