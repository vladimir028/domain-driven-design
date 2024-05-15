package mk.ukim.finki.emt.coursecatalog.domain.repository;

import mk.ukim.finki.emt.coursecatalog.domain.models.Question;
import mk.ukim.finki.emt.coursecatalog.domain.models.QuestionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, QuestionId> {
}
