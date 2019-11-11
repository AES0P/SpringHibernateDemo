package com.hzero.demo.spring;

import com.hzero.demo.spring.stock.bo.StockBo;
import com.hzero.demo.spring.stock.model.Stock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "spring/config/BeanLocations.xml");

        StockBo stockBo = (StockBo) appContext.getBean("stockBo");

        /** insert **/
        Stock stock = new Stock();
        stock.setStockCode("300170");
        stock.setStockName("HAND");
        stockBo.save(stock);

        /** select **/
        Stock stock2 = stockBo.findByStockCode("300170");
        System.out.println(stock2);

        /** update **/
        stock2.setStockName("Hand");
        stockBo.update(stock2);

        /** delete **/
        //stockBo.delete(stock2);

        System.out.println("Done");
    }
}
