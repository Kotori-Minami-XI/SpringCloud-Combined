package com.Kotori.service;

import com.Kotori.mapper.StockMapper;

import javax.annotation.Resource;

public class StockServiceImpl implements StockService{
    @Resource
    private StockMapper stockMapper;
}
