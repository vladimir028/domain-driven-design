package mk.ukim.finki.emt.coursecatalog.domain.repository;

import mk.ukim.finki.emt.coursecatalog.domain.models.Course;
import mk.ukim.finki.emt.coursecatalog.domain.models.CourseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, CourseId> {

}
