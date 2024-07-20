package com.example.article.dto;

import lombok.Builder;

@Builder
public record StockDto(
        String id,
        String name,
        String address
) {
}
