package com.Kotori.rpc;

import com.Kotori.fallback.FeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-microservice-group", fallback = FeignFallback.class)
public interface StockFeignClient {
    @RequestMapping("/reduceStock/{productId}")
    public String reduceStock(@PathVariable Long productId);

    @RequestMapping("/test")
    public String test();
}
