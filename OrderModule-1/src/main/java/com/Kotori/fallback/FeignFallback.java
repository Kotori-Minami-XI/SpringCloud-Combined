package com.Kotori.fallback;

import com.Kotori.rpc.StockFeignClient;
import org.springframework.stereotype.Component;

@Component
public class FeignFallback implements StockFeignClient {
    @Override
    public String reduceStock(Long orderId) {
        return "reduceStock-降级方法------由于库存不足下单失败!";
    }

    @Override
    public String test() {
        return "test-降级方法";
    }

}
