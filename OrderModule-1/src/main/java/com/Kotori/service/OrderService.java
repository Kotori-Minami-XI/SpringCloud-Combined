package com.Kotori.service;

import com.Kotori.domain.Order;

public interface OrderService {
    public void notifyUpdateStock(Order order);
    public Order createOrder(Long productId);
    public void test();
}
