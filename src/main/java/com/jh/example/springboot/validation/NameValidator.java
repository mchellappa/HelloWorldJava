package com.jh.example.springboot.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<CustomNameValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return true;
    }

}
