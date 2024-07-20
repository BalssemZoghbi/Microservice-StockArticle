package com.example.article.services;

import com.example.article.dto.ArticleDto;
import com.example.article.entity.Article;

import java.util.List;

public interface IArticleService {
    ArticleDto getarticleById(Long idArticle);
    ArticleDto savearticle(ArticleDto articleDto);
    ArticleDto updatearticle(ArticleDto articleDto);
    List<ArticleDto> Allarticles();
    void deleteArticleById(Long idArticle);
}
