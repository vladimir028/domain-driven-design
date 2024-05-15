package mk.ukim.finki.emt.coursecatalog.service;

import mk.ukim.finki.emt.coursecatalog.domain.models.Course;
import mk.ukim.finki.emt.coursecatalog.domain.models.Question;
import mk.ukim.finki.emt.coursecatalog.service.form.QuestionForm;

import java.util.List;

public interface QuestionService {
    Question createQuestion(QuestionForm form);
    List<Question> getAll();

}
