package com.example.article.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name="Article")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private long numeroArticle;
    @Enumerated(EnumType.STRING)
    private TypeArticle typeC;
    private String stockId;
}
