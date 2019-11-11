package com.hzero.demo.spring.stock.dao.impl;

import com.hzero.demo.spring.stock.dao.StockDao;
import com.hzero.demo.spring.stock.model.Stock;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DAO实现类扩展了 Spring 的“HibernateDaoSupport”，以使Spring框架支持Hibernate
 * 现在可以通过getHibernateTemplate()执行 Hibernate 功能
 * <p>
 * DAO采用了Spring容器的事务管理策略，如果操作方法的名称和事务策略中指定的被管理的名称不能被匹配上
 * spring 就会自动采取默认的事务管理策略(PROPAGATION_REQUIRED,read only)
 * 如果是插入和修改操作，就不会被允许，会抛出异常：Write operations are not allowed in read-only mode
 * <p>
 * 涉及到数据库的读写都要添加 @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
 * 同时需要在资源文件：Hibernate.xml中启用事务扫描
 */
public class StockDaoImpl extends HibernateDaoSupport implements StockDao {

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void save(Stock stock) {
        getHibernateTemplate().save(stock);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void update(Stock stock) {
        getHibernateTemplate().update(stock);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Stock stock) {
        getHibernateTemplate().delete(stock);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Stock findByStockCode(String stockCode) {
        List list = getHibernateTemplate().find("from Stock where stockCode=?", stockCode);
        return (Stock) list.get(0);
    }

}
