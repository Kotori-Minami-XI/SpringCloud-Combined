package com.Kotori.service;

import com.Kotori.mapper.StockMapper;

public interface StockService {
    void updateStock(Long productId, int delta);
    Long getStockNumById(Long productId) throws InterruptedException;
}
