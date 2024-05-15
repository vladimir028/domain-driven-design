package mk.ukim.finki.emt.coursecatalog.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.coursecatalog.domain.models.Course;
import mk.ukim.finki.emt.coursecatalog.domain.models.CourseId;
import mk.ukim.finki.emt.coursecatalog.domain.models.Question;
import mk.ukim.finki.emt.coursecatalog.domain.repository.CourseRepository;
import mk.ukim.finki.emt.coursecatalog.domain.repository.QuestionRepository;
import mk.ukim.finki.emt.coursecatalog.service.CourseService;
import mk.ukim.finki.emt.coursecatalog.service.form.CourseForm;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository  courseRepository;
    private final QuestionRepository questionRepository;
    @Override
    public Course findById(CourseId id) {
        //todo exception
        return courseRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Course createCourse(CourseForm form) {
        //todo -> implement real question form
        List<Question> tmp = questionRepository.findAll();
        Set<Question> questions = new HashSet<Question>(tmp);
        Course course = Course.build(form.getCourseName(), form.getPrice(), form.getCouponCode(), form.getDescription(), form.getRating(), questions);
        courseRepository.save(course);
        return course;
    }

    @Override
    public Course orderItemCreated(CourseId courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        //todo
//        course.incrementSales()
        courseRepository.saveAndFlush(course);
        return course;
    }

    @Override
    public Course orderItemRemoved(CourseId courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        //todo
//        course.decrementSales()
        courseRepository.saveAndFlush(course);
        return course;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
