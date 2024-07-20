package com.example.stockms.services;

import com.example.stockms.dto.StockDto;
import com.example.stockms.entities.Stock;
import com.example.stockms.repository.StockRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class StockService implements IStockService {
    private StockRepository stockRepository;
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "stock-topic";

    public List<StockDto> getAllStocks() {
        return stockRepository.findAll().stream()
                .map(StockDto::mapFromEntity)
                .collect(Collectors.toList());
    }

    public StockDto getStockById(String id) {
        Stock stock = stockRepository.findById(id).orElse(null);
        return StockDto.mapFromEntity(stock);
    }

    public StockDto saveStock(StockDto stockDto) {
        Stock stock = stockDto.mapToEntity(stockDto);
        stock = stockRepository.save(stock);
        return StockDto.mapFromEntity(stock);
    }

    public void deleteStock(String id) {
        stockRepository.deleteById(id);
    }


}

