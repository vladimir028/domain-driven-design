package mk.ukim.finki.emt.enrolmentmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Course implements ValueObject {
    private final CourseId courseId;
    private final String name;
    private final Money price;

    private Course () {
        this.courseId = CourseId.randomId();
        this.name = "";
        this.price = Money.valueOf(Currency.MKD, 0);
    }

    @JsonCreator
    public Course(@JsonProperty("id") CourseId courseId,
                  @JsonProperty("title") String name,
                  @JsonProperty("price") Money price) {
        this.courseId = courseId;
        this.name = name;
        this.price = price;
    }
}
