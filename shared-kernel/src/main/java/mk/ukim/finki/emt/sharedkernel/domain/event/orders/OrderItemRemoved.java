package mk.ukim.finki.emt.sharedkernel.domain.event.orders;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.event.DomainEvent;

@Getter
public class OrderItemRemoved extends DomainEvent {

    private String courseId;
    private String code;

    public OrderItemRemoved(String topic) {
        super(TopicHolder.TOPIC_ORDER_ITEM_REMOVED);
    }

    public OrderItemRemoved(String topic, String courseId, String code) {
        super(TopicHolder.TOPIC_ORDER_ITEM_REMOVED);
        this.courseId = courseId;
        this.code = code;
    }
}