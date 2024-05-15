package mk.ukim.finki.emt.coursecatalog.domain.valueobjects;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;

@Embeddable
@Getter
public class CouponCode implements ValueObject {
    private final String code;

    protected CouponCode(){
        this.code = "discount_code";
    }

    public CouponCode(@Nonnull String code){
       this.code = code;
    }
}
