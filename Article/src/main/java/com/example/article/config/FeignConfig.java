package com.example.article.config;

import com.example.article.services.FeignClientInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignClientInterceptor feignClientInterceptor() {
        return new FeignClientInterceptor();
    }
}
