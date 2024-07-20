package com.example.article.dto;

import lombok.*;

@Builder
public record ArticleDto(
        Long idArticle,
        long name,
        String quantity,
        String stockId,
        StockDto stockDto
) {

}
