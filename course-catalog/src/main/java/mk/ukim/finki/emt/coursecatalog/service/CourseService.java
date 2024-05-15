package mk.ukim.finki.emt.coursecatalog.service;

import mk.ukim.finki.emt.coursecatalog.domain.models.Course;
import mk.ukim.finki.emt.coursecatalog.domain.models.CourseId;
import mk.ukim.finki.emt.coursecatalog.service.form.CourseForm;

import java.util.List;

public interface CourseService {

    Course findById(CourseId id);
    Course createCourse(CourseForm form);
    Course orderItemCreated(CourseId courseId);
    Course orderItemRemoved(CourseId courseId);
    List<Course> getAll();

}
