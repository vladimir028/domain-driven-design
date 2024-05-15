package mk.ukim.finki.emt.enrolmentmanagement.service;

import mk.ukim.finki.emt.enrolmentmanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.enrolmentmanagement.domain.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.enrolmentmanagement.domain.model.Order;
import mk.ukim.finki.emt.enrolmentmanagement.domain.model.OrderId;
import mk.ukim.finki.emt.enrolmentmanagement.domain.model.OrderItemId;
import mk.ukim.finki.emt.enrolmentmanagement.service.forms.OrderForm;
import mk.ukim.finki.emt.enrolmentmanagement.service.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderId placeOrder(OrderForm orderForm);
    List<Order> findAll();
    Optional<Order> findById(OrderId orderId);
    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException;
    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException;
}
