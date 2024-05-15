package mk.ukim.finki.emt.sharedkernel.infrastructure;

import mk.ukim.finki.emt.sharedkernel.domain.event.DomainEvent;

public interface DomainEventPublisher {
    void publish (DomainEvent event);
}
