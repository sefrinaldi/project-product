package com.sefrinaldi.productservice.validator;

import com.sefrinaldi.productservice.dto.ProductRequestDto;
import com.sefrinaldi.productservice.service.validation.ValidationProductService;
import com.sefrinaldi.productservice.validator.contraint.ProductCodeIsExist;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ProductIsExistValidator implements ConstraintValidator<ProductCodeIsExist, ProductRequestDto> {

    private final ValidationProductService validationProductService;

    @Override
    public boolean isValid(ProductRequestDto productRequestDto, ConstraintValidatorContext constraintValidatorContext) {
        try {
            validationProductService.getProductByCode(productRequestDto.getCode());
            return false;
        } catch (NotFoundException e) {
            return true;
        }
    }
}
