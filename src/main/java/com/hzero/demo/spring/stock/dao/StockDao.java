package com.hzero.demo.spring.stock.dao;

import com.hzero.demo.spring.stock.model.Stock;

/**
 * 在MySQL数据库中创建一张 “stock”表。 SQL语句如下：
 * <p>
 * CREATE TABLE  `yiibai`.`stock` (
 * `STOCK_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
 * `STOCK_CODE` varchar(10) NOT NULL,
 * `STOCK_NAME` varchar(20) NOT NULL,
 * PRIMARY KEY (`STOCK_ID`) USING BTREE,
 * UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
 * UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
 * ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 *
 * 本类声明能对Stock表进行的操作
 */
public interface StockDao {

    void save(Stock stock);

    void update(Stock stock);

    void delete(Stock stock);

    Stock findByStockCode(String stockCode);

}
