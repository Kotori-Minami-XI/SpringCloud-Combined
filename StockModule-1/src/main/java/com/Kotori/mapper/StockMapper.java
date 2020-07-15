package com.Kotori.mapper;

import com.Kotori.domain.Stock;

public interface StockMapper {
    void updateStockById(Long productId, int delta);
    Long getStockNumById(Long productId);
}
