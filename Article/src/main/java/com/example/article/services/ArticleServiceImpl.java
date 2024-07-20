package com.example.article.services;

import com.example.article.dto.articleDto;
import com.example.article.dto.stockDto;
import com.example.article.entity.article;
import com.example.article.entity.articleMapper;
import com.example.article.entity.stockClient;
import com.example.article.entity.Typearticle;
import com.example.article.repositories.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    ArticleRepository articleRepository;
    private StockClient stockClient;
    private ArticleMapper articleMapper;
    private RestTemplate restTemplate;
    private static final String Stock_URL = "http://stock-MS/stock/";

    public ArticleDto getArticleById(Long id) {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String token = jwt.getTokenValue();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return articleRepository.findById(id).map(article -> {
            ResponseEntity<stockDto> response = restTemplate.exchange(
                    stock_URL + article.getstockId(),
                    HttpMethod.GET,
                    entity,
                    stockDto.class
            );
            stockDto stockDto = response.getBody();
            ArticleDto articleDto = articleMapper.toDto(article);
            return new ArticleDto(
                    articleDto.idArticle(),
                    articleDto.name(),
                    articleDto.quantity(),
                    articleDto.stockId()
                    , stockDto);
        }).orElseThrow(() -> new IllegalArgumentException("Article not found"));
    }

    public ArticleDto saveArticle(ArticleDto articleDto) {
        stockDto stockDto = stockClient.getstockById(articleDto.stockId());
        if (stockDto != null) {
            Article c = articleMapper.toEntity(articleDto);
            articleRepository.save(c);
            return new articleDto(
                    articleDto.idArticle(),
                    articleDto.name(),
                    articleDto.quantity(),
                    articleDto.stockId()
                    , stockDto);
        } else throw new IllegalArgumentException("stock not found");
    }

    public ArticleDto updateArticle(ArticleDto articleDto) {
        stockDto stockDto = stockClient.getstockById(articleDto.stockId());
        if (stockDto != null) {
            Article c = articleMapper.toEntity(articleDto);
            articleRepository.save(c);
            return new ArticleDto(
                    articleDto.idArticle(),
                    articleDto.name(),
                    articleDto.quantity(),
                    articleDto.stockId()
                    , stockDto);
        } else throw new IllegalArgumentException("stock not found");
    }

    public List<ArticleDto> AllArticles() {
        return articleRepository.findAll().stream()
                .map(c -> {
                    ArticleDto articleDto = articleMapper.toDto(c);
                    stockDto stockDto = stockClient.getstockById(articleDto.stockId());
                    return new ArticleDto(
                            articleDto.idArticle(),
                            articleDto.name(),
                            articleDto.quantity(),
                            articleDto.stockId()
                            , stockDto);
                })
                .collect(Collectors.toList());
    }

    public void deleteArticleById(Long idArticle) {
        articleRepository.deleteById(idarticle);
    }


    
}



