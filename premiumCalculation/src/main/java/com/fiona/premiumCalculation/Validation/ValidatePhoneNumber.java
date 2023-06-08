package com.fiona.premiumCalculation.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface ValidatePhoneNumber {
    String message() default "Invalid phone number";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
