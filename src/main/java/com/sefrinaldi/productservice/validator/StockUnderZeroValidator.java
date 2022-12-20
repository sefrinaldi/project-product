package com.sefrinaldi.productservice.validator;

import com.sefrinaldi.productservice.dto.StockRequestDto;
import com.sefrinaldi.productservice.entity.Stock;
import com.sefrinaldi.productservice.service.validation.ValidationStockService;
import com.sefrinaldi.productservice.validator.contraint.StockUnderZero;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import net.logstash.logback.encoder.org.apache.commons.lang3.math.NumberUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

@RequiredArgsConstructor
public class StockUnderZeroValidator implements ConstraintValidator<StockUnderZero, StockRequestDto> {

    private final ValidationStockService validationStockService;

    @Override
    public boolean isValid(StockRequestDto stockRequestDto, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Stock stock = validationStockService.getStock();
            if (Objects.isNull(stock)) {
                throw new NotFoundException("Stock Product not found");
            }
            int totalStock = stock.getStockProduct() + stockRequestDto.getStockProduct();
            return totalStock > NumberUtils.INTEGER_ZERO;
        } catch (NotFoundException e) {
            return false;
        }
    }
}
