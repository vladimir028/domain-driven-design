package mk.ukim.finki.emt.enrolmentmanagement.infrastructure;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.event.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.infrastructure.DomainEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DomainEventPublisherImpl implements DomainEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void publish(DomainEvent event) {
        kafkaTemplate.send(event.getTopic(), event.toJson());
    }
}
