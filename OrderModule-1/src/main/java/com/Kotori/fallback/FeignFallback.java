package com.Kotori.fallback;

import com.Kotori.rpc.StockFeignClient;
import org.springframework.stereotype.Component;

@Component
public class FeignFallback implements StockFeignClient {
    @Override
    public String updateStock(Long orderId) {
        return "updateStock-降级方法";
    }

    @Override
    public String test() {
        return "test-降级方法";
    }
}
