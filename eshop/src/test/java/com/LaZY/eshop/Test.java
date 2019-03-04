package com.LaZY.eshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author LaZY(李志一)
 * @create 2019-03-04 20:06
 */
public class Test {
    /***
     * 测试数据库连接
     */
    @org.junit.Test
    public void getConnection(){
        //创建spring核心对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //获得数据源，和xml中id名字相同
        DataSource da = (DataSource) ac.getBean("dataSource");
        try {
            System.out.println(da.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
