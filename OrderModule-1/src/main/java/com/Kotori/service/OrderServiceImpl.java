package com.Kotori.service;

import com.Kotori.domain.Order;
import com.Kotori.mapper.OrderMapper;
import com.Kotori.rpc.StockFeignClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private StockFeignClient stockFeignClient;

    @Resource
    private OrderMapper orderMapper;

    public void notifyUpdateStock(Order order) {
        stockFeignClient.updateStock(order.getProductId());
    }

    public Order createOrder(Long productId) {
        Order order = new Order();
        order.setProductId(productId);
        return order;
    }

    public void test() {
        String s = stockFeignClient.test();
        System.out.println(s);
    }

    @Override
    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }
}
