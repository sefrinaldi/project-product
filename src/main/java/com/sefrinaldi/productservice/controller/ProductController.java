package com.sefrinaldi.productservice.controller;

import com.sefrinaldi.productservice.dto.ProductCreatedDto;
import com.sefrinaldi.productservice.dto.ProductDto;
import com.sefrinaldi.productservice.dto.ProductRequestDto;
import com.sefrinaldi.productservice.entity.Product;
import com.sefrinaldi.productservice.service.ProductService;
import com.sefrinaldi.productservice.validator.contraint.ProductCodeIsNotFound;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product-service")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create-product")
    public ProductCreatedDto createProduct(@RequestBody @Valid ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/get-product/{code}")
    public Product getProduct(@PathVariable(value = "code") String code) throws NotFoundException {
        return productService.getProduct(code);
    }

    @GetMapping("/get-product")
    public Page<Product> productPage(Pageable pageable) throws NotFoundException {
        return productService.getAllProduct(pageable);
    }

    @PutMapping("/edit-product/{code}")
    public ProductDto editProduct(
            @PathVariable(value = "code") @ProductCodeIsNotFound String code,
            @RequestBody ProductRequestDto productRequestDto) throws NotFoundException {
        return productService.editProduct(code, productRequestDto);
    }

    @PatchMapping("/active-product/{code}")
    public ProductDto deleteProduct(
            @PathVariable(value = "code")
            @ProductCodeIsNotFound
                    String code,
            @RequestBody String status) throws NotFoundException {
        return productService.deleteProduct(code, status);
    }
}
