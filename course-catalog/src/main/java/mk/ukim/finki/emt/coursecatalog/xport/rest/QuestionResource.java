package mk.ukim.finki.emt.coursecatalog.xport.rest;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.coursecatalog.domain.models.Question;
import mk.ukim.finki.emt.coursecatalog.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionResource {
    private final QuestionService questionService;

    @GetMapping("")
    private List<Question> getAll(){
        List<Question> a = questionService.getAll();
        return questionService.getAll();
    }
}
