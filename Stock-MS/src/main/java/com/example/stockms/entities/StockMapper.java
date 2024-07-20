package com.example.stockms.entities;

import com.example.stockms.dto.StockDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockMapper {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);
    @Mapping(target = "id", source = "stockId")
    StockDto toDto(Stock Stock);
    @Mapping(target = "stockId", source = "id")
    Stock toEntity(StockDto StockDto);
}