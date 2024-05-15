package mk.ukim.finki.emt.coursecatalog.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ExamAnswers {
    private final String answer;

    public ExamAnswers(String answer){
        this.answer = answer;
    }

    public ExamAnswers(){
        this.answer = "";
    }
}
