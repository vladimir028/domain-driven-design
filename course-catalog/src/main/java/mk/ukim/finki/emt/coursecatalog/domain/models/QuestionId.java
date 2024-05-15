package mk.ukim.finki.emt.coursecatalog.domain.models;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import java.util.UUID;

@Embeddable
public class QuestionId extends DomainObjectId {
    protected QuestionId() {
        super(""); // Initialize with an empty string or handle appropriately
    }

    public QuestionId(String id) {
        super(id);
    }

    public static QuestionId randomId() {
        return new QuestionId(UUID.randomUUID().toString());
    }

    public static QuestionId of(String id) {
        return new QuestionId(id);
    }
}
