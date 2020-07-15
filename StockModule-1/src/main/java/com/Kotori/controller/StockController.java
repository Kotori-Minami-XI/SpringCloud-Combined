package com.Kotori.controller;

import com.Kotori.service.StockService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class StockController {
    @Resource
    private StockService stockService;
    /***
     * 更新库存
     * http://127.0.0.1:8001/reduceStock/111
     */
    @RequestMapping("/reduceStock/{productId}")
    public String reduceStock(@PathVariable Long productId) {
        stockService.updateStock(productId, -1);
        return "库存更新成功,产品号为" + productId;
    }

    @RequestMapping("/test")
    public String test() {
        System.out.println("test...");
        return "test";
    }

}
