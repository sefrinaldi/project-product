package com.sefrinaldi.productservice.controller;

import com.sefrinaldi.productservice.dto.ProductDto;
import com.sefrinaldi.productservice.dto.ProductRequestDto;
import com.sefrinaldi.productservice.entity.Product;
import com.sefrinaldi.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/product-service")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create-product")
    public Product createProduct(@RequestBody @Valid ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }
}
