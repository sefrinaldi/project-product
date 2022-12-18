package com.sefrinaldi.productservice.service.validation;

import com.sefrinaldi.productservice.entity.Stock;
import com.sefrinaldi.productservice.repository.StockRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Objects;
import java.util.Optional;

@Service
@RequestScope
public class ValidationStockService {

    @Autowired
    private StockRepository stockRepository;

    private Stock stock;

    public Stock getStockById(Long id) throws NotFoundException {
        if (Objects.isNull(stock)) {
            Optional<Stock> stockOptional = stockRepository.findById(id);
            if (stockOptional.isEmpty()) {
                throw new NotFoundException("stock product is not found");
            }
            stock = stockOptional.get();
        }
        return stock;
    }
}
