package com.sefrinaldi.productservice.service.validation;

import com.sefrinaldi.productservice.entity.Product;
import com.sefrinaldi.productservice.repository.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequestScope
public class ValidationProductService {

    @Autowired
    private ProductRepository productRepository;

    private HashMap<String, Product> productHashMap = new HashMap<>();

    public Product getProductByCode(String code) throws NotFoundException {
        if(!productHashMap.containsKey(code)) {
            Optional<Product> product = productRepository.findByCode(code);
            if (product.isEmpty()) {
                throw new NotFoundException("product code is not found");
            }
            productHashMap.put(code, product.get());
        }
        return productHashMap.get(code);
    }
}
