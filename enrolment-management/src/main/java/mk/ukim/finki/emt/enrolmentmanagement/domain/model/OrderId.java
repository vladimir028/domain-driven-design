package mk.ukim.finki.emt.enrolmentmanagement.domain.model;

import mk.ukim.finki.emt.enrolmentmanagement.domain.valueobjects.CourseId;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import java.util.UUID;

public class OrderId extends DomainObjectId {
    protected OrderId() {
        super(""); // Initialize with an empty string or handle appropriately
    }

    public OrderId(String id) {
        super(id);
    }

    public static OrderId randomId() {
        return new OrderId(UUID.randomUUID().toString());
    }

    public static OrderId of(String id) {
        return new OrderId(id);
    }
}
