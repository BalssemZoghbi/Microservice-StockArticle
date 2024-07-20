package com.example.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableKafka
public class ArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}
}
