package mk.ukim.finki.emt.coursecatalog.service.form;

import lombok.Data;
import mk.ukim.finki.emt.coursecatalog.domain.valueobjects.CouponCode;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class CourseForm {
    private String courseName;
    private Money price;
    private CouponCode couponCode;
    private int rating;
    private String description;
}
