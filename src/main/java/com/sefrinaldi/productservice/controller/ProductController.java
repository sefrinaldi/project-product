package com.sefrinaldi.productservice.controller;

import com.sefrinaldi.productservice.dto.ProductDto;
import com.sefrinaldi.productservice.dto.ProductRequestDto;
import com.sefrinaldi.productservice.entity.Product;
import com.sefrinaldi.productservice.service.ProductService;
import com.sefrinaldi.productservice.validator.contraint.ProductCodeIsNotFound;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product-service")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create-product")
    public ProductDto createProduct(@RequestBody @Valid ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/get-product/{code}")
    public Product getProduct(@PathVariable(value = "code") String code) throws NotFoundException {
        return productService.getProduct(code);
    }

    @GetMapping("/get-product")
    public Page<Product> productPage(Pageable pageable) {
        return productService.getAllProduct(pageable);
    }

    @PutMapping("/edit-product/{code}")
    public Product editProduct(
            @PathVariable(value = "code") @Valid @ProductCodeIsNotFound String code,
            @RequestBody ProductRequestDto productRequestDto) throws NotFoundException {
        return productService.editProduct(code, productRequestDto);
    }
}
