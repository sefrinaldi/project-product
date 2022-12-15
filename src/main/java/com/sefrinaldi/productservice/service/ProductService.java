package com.sefrinaldi.productservice.service;

import com.sefrinaldi.productservice.dto.ProductDto;
import com.sefrinaldi.productservice.dto.ProductRequestDto;
import com.sefrinaldi.productservice.entity.Product;
import com.sefrinaldi.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
//    private final MapperFacade mapperFacade;

    public Product createProduct(ProductRequestDto productRequestDto) {
//        Product product = mapperFacade.map(productRequestDto, Product.class);
        Product product = Product.builder()
                .code(productRequestDto.getCode())
                .label(productRequestDto.getLabel())
                .amount(productRequestDto.getAmount())
                .build();

        productRepository.save(product);
        return product;
    }
}
