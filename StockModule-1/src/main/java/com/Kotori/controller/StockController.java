package com.Kotori.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {
    /***
     * 更新库存
     * http://127.0.0.1:8001/updateStock/111
     */
    @RequestMapping("/updateStock/{productId}")
    public String updateStock(@PathVariable Long productId) {
        System.out.println("库存更新...");
        return "库存更新成功,产品号为" + productId;
    }

    @RequestMapping("/test")
    public String test() {
        System.out.println("test...");
        return "test";
    }

}
