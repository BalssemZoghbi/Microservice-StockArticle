package com.example.stockms.repository;

import com.example.stockms.entities.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String> {
}