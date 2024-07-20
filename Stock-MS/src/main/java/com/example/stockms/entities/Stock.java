package com.example.stockms.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(value= "Stock")
public class Stock {
    @Id
    private String StockId;
    private String title;
    private String zone;
}
