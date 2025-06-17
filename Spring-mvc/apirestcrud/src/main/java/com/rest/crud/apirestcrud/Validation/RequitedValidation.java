package com.rest.crud.apirestcrud.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequitedValidation implements ConstraintValidator<IsRequired, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (value != null && !value.isEmpty() && !value.isBlank());
    }
    
}
