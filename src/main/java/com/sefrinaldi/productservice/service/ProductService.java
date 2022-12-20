package com.sefrinaldi.productservice.service;

import com.sefrinaldi.productservice.dto.ProductCreatedDto;
import com.sefrinaldi.productservice.dto.ProductDto;
import com.sefrinaldi.productservice.dto.ProductRequestDto;
import com.sefrinaldi.productservice.entity.Product;
import com.sefrinaldi.productservice.entity.Stock;
import com.sefrinaldi.productservice.repository.ProductRepository;
import com.sefrinaldi.productservice.service.validation.ValidationProductService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import net.logstash.logback.encoder.org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ValidationProductService validationProductService;
    private final MapperFacade mapperFacade;

    public ProductCreatedDto createProduct(ProductRequestDto productRequestDto) {

        Product product = mapperFacade.map(productRequestDto, Product.class);

        Stock stock = Stock.builder()
                .product(product)
                .stockProduct(NumberUtils.INTEGER_ZERO)
                .build();

        product.setStock(stock);

        productRepository.save(product);
        return mapperFacade.map(product, ProductCreatedDto.class);
    }

    public Product getProduct(String code) throws NotFoundException {
        return validationProductService.getProductByCode(code);
    }

    public Page<Product> getAllProduct(Pageable pageable) throws NotFoundException {
        return validationProductService.getProductByStatusActive(Product.Status.ACTIVE, pageable);
//        return productRepository.findAll();
    }

    public ProductDto editProduct(String code, ProductRequestDto productRequestDto) throws NotFoundException {
        Product product = validationProductService.getProductByCode(code);

        Product newProduct = Product.builder()
                .id(product.getId())
                .code(product.getCode())
                .label(Objects.isNull(productRequestDto.getLabel()) ? product.getLabel() : productRequestDto.getLabel())
                .amount(Objects.isNull(productRequestDto.getAmount()) ? product.getAmount() : productRequestDto.getAmount())
                .createdAt(product.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
        productRepository.save(newProduct);
        return mapperFacade.map(newProduct, ProductDto.class);
    }

    public ProductDto deleteProduct(String code, String status) throws NotFoundException {
        Product product = validationProductService.getProductByCode(code);
        product.setStatus(Product.Status.valueOf(status));
        productRepository.save(product);
        return mapperFacade.map(product, ProductDto.class);
    }
}
