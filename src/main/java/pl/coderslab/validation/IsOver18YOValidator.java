package pl.coderslab.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IsOver18YOValidator implements ConstraintValidator<IsOver18YO, Integer> {

    @Override
    public void initialize(IsOver18YO isOver18YO) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return (LocalDate.now().getYear() - value )> 18;
    }
}
