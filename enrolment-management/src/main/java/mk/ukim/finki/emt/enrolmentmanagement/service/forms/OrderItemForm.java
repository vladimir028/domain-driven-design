package mk.ukim.finki.emt.enrolmentmanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.enrolmentmanagement.domain.valueobjects.Course;

import javax.validation.constraints.NotNull;

@Data
public class OrderItemForm {
    @NotNull
    private Course course;

    private String discount_code;
}
