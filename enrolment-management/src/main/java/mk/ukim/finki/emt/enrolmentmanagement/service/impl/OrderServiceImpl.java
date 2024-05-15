package mk.ukim.finki.emt.enrolmentmanagement.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt.enrolmentmanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.enrolmentmanagement.domain.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.enrolmentmanagement.domain.model.Order;
import mk.ukim.finki.emt.enrolmentmanagement.domain.model.OrderId;
import mk.ukim.finki.emt.enrolmentmanagement.domain.model.OrderItemId;
import mk.ukim.finki.emt.enrolmentmanagement.domain.repository.OrderRepository;
import mk.ukim.finki.emt.enrolmentmanagement.service.OrderService;
import mk.ukim.finki.emt.enrolmentmanagement.service.forms.OrderForm;
import mk.ukim.finki.emt.enrolmentmanagement.service.forms.OrderItemForm;
import mk.ukim.finki.emt.sharedkernel.domain.event.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.infrastructure.DomainEventPublisher;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DomainEventPublisher publisher;

    @Override
    public OrderId placeOrder(OrderForm orderForm) {
        Objects.requireNonNull(orderForm, "order can not be null");
//        validator.validate(orderForm);

        var newOrder = orderRepository.saveAndFlush(toDomainObject(orderForm));
//        newOrder.getOrderItems().forEach(orderItem -> publisher.publish(
//                new OrderItemCreated(orderItem.getCourseId().getId(), orderItem.getDiscount_code())
//        ));
        return newOrder.getId();

    }

    private Order toDomainObject(OrderForm orderForm){
        var order = new Order(Instant.now(), orderForm.getCurrency());
        orderForm.getItems().forEach(item -> order.addItem(item.getCourse(), item.getDiscount_code()));

        return order;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);

        order.addItem(orderItemForm.getCourse(), orderItemForm.getDiscount_code());
//         publisher.publish(
//                new OrderItemCreated(orderItemForm.getCourse().getCourseId().getId(), orderItemForm.getDiscount_code())
//        );
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);

        order.removeItem(orderItemId);
        orderRepository.saveAndFlush(order);
    }
}
