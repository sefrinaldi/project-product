package com.sefrinaldi.productservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private String code;
    private String label;
    private BigDecimal amount;
}
