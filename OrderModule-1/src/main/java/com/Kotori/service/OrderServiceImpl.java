package com.Kotori.service;

import com.Kotori.domain.Order;
import com.Kotori.mapper.OrderMapper;
import com.Kotori.rpc.StockFeignClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private StockFeignClient stockFeignClient;

    @Resource
    private OrderMapper orderMapper;
    // ###################################### 公有方法 ###############################################
    @Override
    @Transactional
    public String generateOrder(Long productId) {
        Order order = this.createOrder(productId);
        this.insertOrder(order);
        return this.notifyReduceStock(order); //远程调用StockModule更新库存
    }

    @Override
    @Transactional
    public void test() {
        String s = stockFeignClient.test();
        System.out.println(s);
    }

    // ###################################### 私有方法 ###############################################
    private String notifyReduceStock(Order order) {
        return stockFeignClient.reduceStock(order.getProductId());
    }

    private Order createOrder(Long productId) {
        Order order = new Order();
        order.setProductId(productId);
        return order;
    }

    private void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }
}
