package com.example.stockms.controllers;

import com.example.stockms.dto.StockDto;
import com.example.stockms.services.StockService;
import com.example.stockms.services.IStockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Stock")
@Slf4j
@RequiredArgsConstructor
@RefreshScope
public class StockController {
    private final IStockService StockService;

    @GetMapping
    public List<StockDto> getAllStock() {
        return StockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public StockDto getStockById(@PathVariable String id) {
        return StockService.getStockById(id);
    }

    @PostMapping
    public StockDto saveStock(@RequestBody StockDto StockDto) {
        return StockService.saveStock(StockDto);
    }

    @PutMapping("/{id}")
    public StockDto updateStock(@PathVariable String id, @RequestBody StockDto StockDto) {return StockService.saveStock(StockDto);}

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable String id) {
        StockService.deleteStock(id);
    }

}
