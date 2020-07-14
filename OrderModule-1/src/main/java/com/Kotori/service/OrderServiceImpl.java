package com.Kotori.service;

import com.Kotori.domain.Order;
import com.Kotori.rpc.StockFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private StockFeignClient stockFeignClient;

    public void notifyUpdateStock(Order order) {
        stockFeignClient.updateStock(order.getProductId());
    }

    public Order createOrder(Long productId) {
        Order order = new Order();
        order.setOrderId(12345L);
        order.setProductId(productId);
        return order;
    }

    public void test() {
        String s = stockFeignClient.test();
        System.out.println(s);
    }

}
