package com.sefrinaldi.productservice.validator;

import com.sefrinaldi.productservice.service.validation.ValidationProductService;
import com.sefrinaldi.productservice.validator.contraint.ProductCodeIsNotFound;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ProductIsNotFoundValidator implements ConstraintValidator<ProductCodeIsNotFound, String> {

    private final ValidationProductService validationProductService;

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        try {
            validationProductService.getProductByCode(code);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }
}
