package com.hzero.demo.spring.stock.bo;

import com.hzero.demo.spring.stock.model.Stock;

/**
 * 定义当前业务具有哪些功能
 */
public interface StockBo {

    public void save(Stock stock);

    public void update(Stock stock);

    public void delete(Stock stock);

    public Stock findByStockCode(String stockCode);

}
