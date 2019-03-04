package com.LaZY.eshop.service.impl;

import com.LaZY.eshop.dao.BaseDao;
import com.LaZY.eshop.service.UserService;
import com.LaZY.eshop.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *UserService具体实现类
         */

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    /**
     * 重新该方法，需要注入指定的UserDao对象
     */
    @Resource(name = "userDao")
    public void setDao(BaseDao<User> dao) {
        super.setDao(dao);
    }
}
