package mk.ukim.finki.emt.sharedkernel.domain.event.orders;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.event.DomainEvent;

@Getter
public class OrderItemCreated extends DomainEvent {

    private String courseId;
    private String code;

    public OrderItemCreated(String topic) {
        super(TopicHolder.TOPIC_ORDER_ITEM_CREATED);
    }

    public OrderItemCreated(String courseId, String code) {
        super(TopicHolder.TOPIC_ORDER_ITEM_CREATED);
        this.courseId = courseId;
        this.code = code;
    }
}
