package mk.ukim.finki.emt.coursecatalog.initialdata;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.coursecatalog.domain.models.Course;
import mk.ukim.finki.emt.coursecatalog.domain.models.Question;
import mk.ukim.finki.emt.coursecatalog.domain.repository.CourseRepository;
import mk.ukim.finki.emt.coursecatalog.domain.repository.QuestionRepository;
import mk.ukim.finki.emt.coursecatalog.domain.valueobjects.CouponCode;
import mk.ukim.finki.emt.coursecatalog.domain.valueobjects.ExamAnswers;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Configuration {

    private final CourseRepository courseRepository;
    private final QuestionRepository questionRepository;

    @PostConstruct
    public void init(){

        Set<ExamAnswers> answers = new HashSet<>();
        answers.add(new ExamAnswers("3"));
        answers.add(new ExamAnswers("1"));
        answers.add(new ExamAnswers("4"));
        answers.add(new ExamAnswers("2"));

        Question question1 = Question.build("what's 2+2", "4", answers, 1);

        Set<ExamAnswers> answers1 = new HashSet<>();
        answers1.add(new ExamAnswers("32"));
        answers1.add(new ExamAnswers("42"));
        answers1.add(new ExamAnswers("10"));
        answers1.add(new ExamAnswers("2"));

        Question question2 = Question.build("what's 5+5", "10", answers1, 13);

        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);

        Question question3 = Question.build("test", "10", answers1, 13);


        Set<Question> questionsss = new HashSet<>();
        questionsss.add(question3);

        questionRepository.save(question1);
        questionRepository.save(question2);
        questionRepository.save(question3);

        Course course1 = Course.build("course1", new Money(Currency.MKD, 2000), new CouponCode("discount_code1"), "description1", 10, questions);
        Course course2 = Course.build("course2", new Money(Currency.MKD, 1000), new CouponCode("discount_code2"), "description2", 4, questionsss);




        courseRepository.save(course1);
        courseRepository.save(course2);
    }
}
