package org.tauasa.t2g.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tauasa.t2g.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    public List<Score> findByGolferId(Long id);

}
