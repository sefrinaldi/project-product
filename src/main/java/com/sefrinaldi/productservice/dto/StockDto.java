package com.sefrinaldi.productservice.dto;

import com.sefrinaldi.productservice.entity.Product;
import lombok.Data;

@Data
public class StockDto {

    private Long id;
    private Integer stockProduct;
    private Product product;
}
