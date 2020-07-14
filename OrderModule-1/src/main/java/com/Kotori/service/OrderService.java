package com.Kotori.service;

import com.Kotori.domain.Order;

public interface OrderService {
    void notifyUpdateStock(Order order);
    Order createOrder(Long productId);
    void test();

    void insertOrder(Order order);
}
