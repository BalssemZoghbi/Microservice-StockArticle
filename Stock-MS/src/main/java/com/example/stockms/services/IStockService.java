package com.example.stockms.services;

import com.example.stockms.dto.StockDto;

import java.util.List;

public interface IStockService {
    List<StockDto> getAllStocks();
    StockDto getStockById(String id);
    StockDto saveStock(StockDto stockDto);
    void deleteStock(String id);

}
