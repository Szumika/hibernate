package pl.coderslab.model;

import pl.coderslab.validation.IsOverXYO;

public class ValidationTest {
    @IsOverXYO(10)
    public int yearOfBirth;
}
