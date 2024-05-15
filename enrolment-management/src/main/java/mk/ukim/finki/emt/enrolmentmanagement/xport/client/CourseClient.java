package mk.ukim.finki.emt.enrolmentmanagement.xport.client;

import mk.ukim.finki.emt.enrolmentmanagement.domain.valueobjects.Course;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class CourseClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public CourseClient(@Value("${app.course-catalog.url}") String serverUrl) {
        this.restTemplate = new RestTemplate();
        this.serverUrl = serverUrl;
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri () {
        return UriComponentsBuilder.fromUriString(serverUrl);
    }

    public List<Course> findAll(){
        return restTemplate
                .exchange(uri().path("/api/course").build().toUri(), HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Course>>(){

        }).getBody();
    }
}
