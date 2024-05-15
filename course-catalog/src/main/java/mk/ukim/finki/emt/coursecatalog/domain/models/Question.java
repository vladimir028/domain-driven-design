package mk.ukim.finki.emt.coursecatalog.domain.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.coursecatalog.domain.valueobjects.ExamAnswers;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import java.util.Set;

@Entity
@Table(name = "questions")
@Getter
public class Question extends AbstractEntity<QuestionId> {
    private Integer totalPoints;
    private String correct_answer;
    private String question;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<ExamAnswers> answers;

    public static Question build(String question, String correct_answer, Set<ExamAnswers> answers, Integer totalPoints) {
        Question q = new Question();
        q.question = question;
        q.correct_answer = correct_answer;
        q.answers = answers;
        q.totalPoints = totalPoints;

        return q;
    }

    public Question() {
        super(QuestionId.randomId());
    }
}
