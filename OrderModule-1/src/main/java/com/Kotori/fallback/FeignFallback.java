package com.Kotori.fallback;

import com.Kotori.rpc.StockFeignClient;
import org.springframework.stereotype.Component;

@Component
public class FeignFallback implements StockFeignClient {
    @Override
    public String reduceStock(Long orderId) {
        System.out.println("reduceStock-降级方法------由于库存不足下单失败!");
        if (true) {
            throw new RuntimeException("reduceStock-降级方法------由于库存不足下单失败-------");
        }
        return "reduceStock-降级方法------由于库存不足下单失败!";
    }

    @Override
    public String test() {
        System.out.println("test-降级方法");
        return "test-降级方法";
    }

}
