package com.Kotori.controller;

import com.Kotori.domain.Order;
import com.Kotori.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("/createOrder/{productId}")
    @ResponseBody
    public String createOrder(@PathVariable Long productId) {
        Order order = orderService.createOrder(productId);
        orderService.notifyUpdateStock(order);
        return "商品" + productId + "已下单";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("test...");
        orderService.test();
        return "商品";
    }
}
