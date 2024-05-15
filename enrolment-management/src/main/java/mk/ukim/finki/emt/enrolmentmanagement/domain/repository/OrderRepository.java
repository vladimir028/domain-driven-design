package mk.ukim.finki.emt.enrolmentmanagement.domain.repository;

import mk.ukim.finki.emt.enrolmentmanagement.domain.model.Order;
import mk.ukim.finki.emt.enrolmentmanagement.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, OrderId> {

}
