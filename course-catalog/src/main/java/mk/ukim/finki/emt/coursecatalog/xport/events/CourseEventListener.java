//package mk.ukim.finki.emt.coursecatalog.xport.events;
//
//import lombok.AllArgsConstructor;
//import mk.ukim.finki.emt.coursecatalog.domain.models.CourseId;
//import mk.ukim.finki.emt.coursecatalog.service.CourseService;
//import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
//import mk.ukim.finki.emt.sharedkernel.domain.event.DomainEvent;
//import mk.ukim.finki.emt.sharedkernel.domain.event.orders.OrderItemCreated;
//import mk.ukim.finki.emt.sharedkernel.domain.event.orders.OrderItemRemoved;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class CourseEventListener {
//
//    private final CourseService courseService;
//
//    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "courseCatalog")
//    public void consumeOrderItemCreatedEvent(String jsonMessage) {
//        try {
//            OrderItemCreated event = DomainEvent.fromJson(jsonMessage,OrderItemCreated.class);
//            courseService.orderItemCreated(CourseId.of(event.getCourseId()));
//        } catch (Exception e){
//
//        }
//
//    }
//
//    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "courseCatalog")
//    public void consumeOrderItemRemovedEvent(String jsonMessage) {
//        try {
//            OrderItemRemoved event = DomainEvent.fromJson(jsonMessage,OrderItemRemoved.class);
//            courseService.orderItemRemoved(CourseId.of(event.getCourseId()));
//        } catch (Exception e){
//
//        }
//
//    }
//
//}
