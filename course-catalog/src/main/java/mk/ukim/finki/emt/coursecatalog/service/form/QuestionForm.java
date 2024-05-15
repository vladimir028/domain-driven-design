package mk.ukim.finki.emt.coursecatalog.service.form;

import lombok.Data;
import mk.ukim.finki.emt.coursecatalog.domain.valueobjects.ExamAnswers;

import java.util.Set;

@Data
public class QuestionForm {
    private Integer totalPoints;
    private String correct_answer;
    private String question;
    private Set<ExamAnswers> answers;
}
