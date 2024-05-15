package mk.ukim.finki.emt.enrolmentmanagement.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import java.util.UUID;

public class OrderItemId extends DomainObjectId {
    protected OrderItemId() {
        super(""); // Initialize with an empty string or handle appropriately
    }

    public OrderItemId(String id) {
        super(id);
    }

    public static OrderItemId randomId() {
        return new OrderItemId(UUID.randomUUID().toString());
    }

    public static OrderItemId of(String id) {
        return new OrderItemId(id);
    }
}
