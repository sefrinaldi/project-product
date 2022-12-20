package com.sefrinaldi.productservice.service;

import com.sefrinaldi.productservice.dto.StockDto;
import com.sefrinaldi.productservice.dto.StockRequestDto;
import com.sefrinaldi.productservice.entity.Stock;
import com.sefrinaldi.productservice.repository.StockRepository;
import com.sefrinaldi.productservice.service.validation.ValidationStockService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final ValidationStockService validationStockService;
    private final StockRepository stockRepository;
    private final MapperFacade mapperFacade;

    public Stock modifyStockProduct(Long id, StockRequestDto stockRequestDto) throws NotFoundException {
        Stock stock = validationStockService.getStockById(id);
        stock.setStockProduct(stock.getStockProduct() + stockRequestDto.getStockProduct());
        stockRepository.save(stock);
        return stock;
    }
}
