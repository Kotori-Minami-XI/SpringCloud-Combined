package com.Kotori.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-microservice-group")
public interface StockFeignClient {
    @RequestMapping("/updateStock/{productId}")
    public String updateStock(@PathVariable Long productId);

    @RequestMapping("/test")
    public String test();
}
