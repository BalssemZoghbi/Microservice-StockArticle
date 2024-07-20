package com.example.article.entity;

import com.example.article.dto.ArticleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);
    @Mapping(source = "id", target = "idArticle")
    ArticleDto toDto(Article Article);
    @Mapping(source = "idArticle", target = "id")
    Article toEntity(ArticleDto ArticleDto);

}
