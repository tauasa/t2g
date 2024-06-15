package org.tauasa.t2g.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tauasa.t2g.model.Golfer;

public interface GolferRepository extends JpaRepository<Golfer, Long> {

}
