package com.sefrinaldi.productservice.controller;

import com.sefrinaldi.productservice.dto.StockDto;
import com.sefrinaldi.productservice.dto.StockRequestDto;
import com.sefrinaldi.productservice.entity.Stock;
import com.sefrinaldi.productservice.service.StockService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock-service")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/modify/{id}/stock")
    public Stock modifyStock(@PathVariable(value = "id") Long id, @RequestBody StockRequestDto stockRequestDto) throws NotFoundException {
        return stockService.modifyStockProduct(id, stockRequestDto);
    }
}
