package mk.ukim.finki.emt.enrolmentmanagement.domain.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.enrolmentmanagement.domain.valueobjects.Course;
import mk.ukim.finki.emt.enrolmentmanagement.domain.valueobjects.CourseId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.aspectj.weaver.ast.Or;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderId> {
     private Instant orderedOn;

     @Enumerated(value = EnumType.STRING)
     private OrderState state;

//     @Transient
//     private Money total;

     @Column(name = "order_currency")
     @Enumerated(value = EnumType.STRING)
     private Currency currency;

     @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
     fetch = FetchType.EAGER)
     private Set<OrderItem> orderItems;

     public Order(Instant now, Currency currency) {
          this.orderedOn = now;
          this.currency = currency;
     }


     public Money total(){
          return orderItems.stream()
                  .map(OrderItem::subTotal)
                  .reduce(new Money(currency, 0), Money::add);
     }

     public OrderItem addItem(@Nonnull Course course,String discount_code){
          Objects.requireNonNull(course, "course can not be null");
          var item = new OrderItem(course.getCourseId(), course.getPrice(), discount_code);

          orderItems.add(item);
          return item;
     }

     public void removeItem(@Nonnull OrderItemId orderItemId){
          Objects.requireNonNull(orderItemId, "orderItemId can not be null");
        orderItems.removeIf(i -> i.getId().equals(orderItemId));
     }

     public Order() {
          super(OrderId.randomId());
     }


}
