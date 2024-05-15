package mk.ukim.finki.emt.coursecatalog.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.coursecatalog.domain.valueobjects.CouponCode;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.util.Set;

@Entity
@Table(name = "course")
@Getter
public class Course extends AbstractEntity<CourseId> {

    private String title;
    private String description;
    private CouponCode coupon_code;
    private Integer rating;
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency"))
    })
    private Money price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Question> question;

    public static Course build(String courseTitle, Money price,
                               CouponCode coupon_code,
                               String description,
                               int rating,
                               Set<Question> question){
        Course course = new Course();
        course.title = courseTitle;
        course.price = price;
        course.coupon_code = coupon_code;
        course.rating = rating;
        course.description = description;
        course.question = question;

        return course;
    }



    public Course() {
        super(CourseId.randomId());
    }


}
