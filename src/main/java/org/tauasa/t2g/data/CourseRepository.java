package org.tauasa.t2g.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.tauasa.t2g.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {


}
