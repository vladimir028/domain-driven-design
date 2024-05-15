package mk.ukim.finki.emt.coursecatalog.xport.rest;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.coursecatalog.domain.models.Course;
import mk.ukim.finki.emt.coursecatalog.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseResource {
    private final CourseService courseService;

    @GetMapping("")
    public List<Course> findAll(){
        return courseService.getAll();
    }
}
