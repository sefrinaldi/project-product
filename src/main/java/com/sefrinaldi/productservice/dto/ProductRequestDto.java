package com.sefrinaldi.productservice.dto;

import com.sefrinaldi.productservice.validator.contraint.ProductCodeIsExist;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@Validated
@ProductCodeIsExist
public class ProductRequestDto {

    private String code;
    private String label;
    private BigDecimal amount;
}
