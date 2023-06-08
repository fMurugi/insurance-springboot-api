package com.fiona.premiumCalculation.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidatePhoneNumber, String> {
    private static final String PHONE_NUMBER_REGEX = "^[0-9]{10}$";
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);


    @Override
    public boolean isValid(String  phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        if(phoneNumber == null  ){
            return  true; //allow empty and null
        }
        return PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
    }
}
