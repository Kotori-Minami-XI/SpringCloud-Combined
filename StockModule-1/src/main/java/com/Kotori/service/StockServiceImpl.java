package com.Kotori.service;

import com.Kotori.mapper.StockMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StockServiceImpl implements StockService{
    @Resource
    private StockMapper stockMapper;

    @Override
    @Transactional
    public void updateStock(Long productId, int delta) throws RuntimeException{
        Long stockNum = getStockNumById(productId);
        if (stockNum <= 0) {
            throw new RuntimeException("库存不足！下单失败");
        }
        stockMapper.updateStockById(productId, delta);
    }

    @Override
    public Long getStockNumById(Long productId) {
        return stockMapper.getStockNumById(productId);
    }
}
