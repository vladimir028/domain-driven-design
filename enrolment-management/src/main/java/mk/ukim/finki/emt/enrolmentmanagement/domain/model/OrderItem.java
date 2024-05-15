package mk.ukim.finki.emt.enrolmentmanagement.domain.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.enrolmentmanagement.domain.valueobjects.CourseId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {
    private Money itemPrice;
    private String discount_code;
    @AttributeOverride(name = "id", column = @Column(name = "course_id", nullable = false))
    private CourseId courseId;


    public Money subTotal(){
        return itemPrice.multiply(1);
    }

    public OrderItem(@Nonnull CourseId courseId, @Nonnull Money itemPrice, String discount_code){
//        super(DomainObjectId.randomId(OrderItem.class));
        this.courseId = courseId;
        this.itemPrice = itemPrice;
        this.discount_code = discount_code;

    }

    public OrderItem() {
        super(OrderItemId.randomId());
    }

}
