package com.Kotori.controller;

import com.Kotori.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("/buy/{productId}")
    @ResponseBody
    public String buy(@PathVariable Long productId) {
        String result = null;
        try {
            result = orderService.generateOrder(productId);
        } catch (RuntimeException e) {
            return "库存系统发现库存不够，下单失败";
        }
        return result;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("test...");
        orderService.test();
        return "商品";
    }
}
