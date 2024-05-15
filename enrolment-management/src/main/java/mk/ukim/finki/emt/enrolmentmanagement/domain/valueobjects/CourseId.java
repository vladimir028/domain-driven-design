package mk.ukim.finki.emt.enrolmentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import java.util.UUID;

@Embeddable
public class CourseId extends DomainObjectId {
    protected CourseId() {
        super(""); // Initialize with an empty string or handle appropriately
    }

    public CourseId(String id) {
        super(id);
    }

    public static CourseId randomId() {
        return new CourseId(UUID.randomUUID().toString());
    }

    public static CourseId of(String id) {
        return new CourseId(id);
    }
}
