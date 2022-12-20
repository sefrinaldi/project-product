package com.sefrinaldi.productservice.validator;

import com.sefrinaldi.productservice.service.validation.ValidationStockService;
import com.sefrinaldi.productservice.validator.contraint.StockProductIsNotFound;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class StockProductIsNotFoundValidator implements ConstraintValidator<StockProductIsNotFound, Long> {

    private final ValidationStockService validationStockService;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        try {
            validationStockService.getStockById(id);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }
}
