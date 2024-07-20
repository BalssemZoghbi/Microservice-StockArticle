package com.example.stockms.dto;

import com.example.stockms.entities.Stock;
import com.example.stockms.entities.StockMapper;
import lombok.Builder;

@Builder
public record StockDto(
        String id,
        String title,
        String zone
) {

    public static StockDto mapFromEntity(Stock Stock) {
        return StockMapper.INSTANCE.toDto(Stock);
    }
    public static Stock mapToEntity(StockDto StockDto) {
        return StockMapper.INSTANCE.toEntity(StockDto);
    }
}
