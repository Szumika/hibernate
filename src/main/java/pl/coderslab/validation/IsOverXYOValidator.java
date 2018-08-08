package pl.coderslab.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IsOverXYOValidator implements ConstraintValidator<IsOverXYO, Integer> {
private int minimumAge;

    @Override
    public void initialize(IsOverXYO isOverXYO) {
        this.minimumAge = isOverXYO.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return (LocalDate.now().getYear() - value )> this.minimumAge;
    }
}
