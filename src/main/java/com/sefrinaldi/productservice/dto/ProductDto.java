package com.sefrinaldi.productservice.dto;

import com.sefrinaldi.productservice.entity.Product;
import com.sefrinaldi.productservice.entity.Stock;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private Long id;
    private String code;
    private String label;
    private BigDecimal amount;
    private Product.Status isActive;
}
