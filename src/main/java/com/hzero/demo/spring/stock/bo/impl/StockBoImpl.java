package com.hzero.demo.spring.stock.bo.impl;

import com.hzero.demo.spring.stock.bo.StockBo;
import com.hzero.demo.spring.stock.dao.StockDao;
import com.hzero.demo.spring.stock.model.Stock;

/**
 * Stock 业务对象(BO)接口的实现，它是用来实现项目的业务功能
 * 数据库操作(CRUD)工作不应该参与这一个类，而是通过一个DAO(StockDao)类来做到这一点
 * <p>
 * 即这个类里面只写和业务有关的逻辑，而CRUD相关操作的实现，可由相应的DAO层去实现
 */
public class StockBoImpl implements StockBo {

    StockDao stockDao;

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    public void save(Stock stock) {
        stockDao.save(stock);
    }

    public void update(Stock stock) {
        stockDao.update(stock);
    }

    public void delete(Stock stock) {
        stockDao.delete(stock);
    }

    public Stock findByStockCode(String stockCode) {
        return stockDao.findByStockCode(stockCode);
    }
}
