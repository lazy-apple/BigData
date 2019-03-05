package com.LaZY.eshop;

import com.LaZY.eshop.model.User;
import com.LaZY.eshop.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LaZY(李志一)
 * @create 2019-03-04 22:43
 */
public class TestUserService {
    @Test
    public void saveService(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = (UserService) ac.getBean("userService");
        User u = new User();
        u.setName("tom");
        u.setPassword("123456");
        us.saveEntity(u);
    }
}
