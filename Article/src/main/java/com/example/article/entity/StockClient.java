package com.example.article.entity;
import com.example.article.config.FeignConfig;
import com.example.article.dto.StockDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Stock-MS", configuration = FeignConfig.class)
public interface StockClient {
    @GetMapping("api/stock/{id}")
    @CircuitBreaker(name="Stock-MS",fallbackMethod ="fallbackGetStockById")
    StockDto getStockById(@PathVariable("id") String id);

    default StockDto fallbackGetStockById(String id, Throwable throwable) {
        return new StockDto("0", "Fallback Stock", "0");
    }
}
