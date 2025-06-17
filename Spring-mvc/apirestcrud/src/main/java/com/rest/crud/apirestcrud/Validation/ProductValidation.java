package com.rest.crud.apirestcrud.Validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rest.crud.apirestcrud.Entities.Product;


@Component
public class ProductValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "100","default mesg");
        if(product.getDescription() == null || product.getDescription().isBlank()){
            errors.rejectValue("description", "200","Es DESCRIPTION DFKJFDK");
        }
    }
    
}
