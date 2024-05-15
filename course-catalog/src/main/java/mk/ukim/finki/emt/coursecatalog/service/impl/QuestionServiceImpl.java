package mk.ukim.finki.emt.coursecatalog.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.coursecatalog.domain.models.Course;
import mk.ukim.finki.emt.coursecatalog.domain.models.Question;
import mk.ukim.finki.emt.coursecatalog.domain.repository.QuestionRepository;
import mk.ukim.finki.emt.coursecatalog.service.QuestionService;
import mk.ukim.finki.emt.coursecatalog.service.form.QuestionForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question createQuestion(QuestionForm form) {
        Question question = Question.build(form.getQuestion(), form.getCorrect_answer(), form.getAnswers(), form.getTotalPoints());
        questionRepository.save(question);

        return question;
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }
}
