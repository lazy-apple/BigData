package com.LaZY.eshop.service.impl;

import com.LaZY.eshop.dao.BaseDao;
import com.LaZY.eshop.model.Stat;
import com.LaZY.eshop.model.User;
import com.LaZY.eshop.service.StatService;
import com.LaZY.eshop.service.UserService;
import com.LaZY.eshop.util.ValidateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *UserService具体实现类
         */

@Service("StatService")
public class StatServiceImpl extends BaseServiceImpl<Stat> implements StatService {


    /**
     * 重新该方法，需要注入指定的UserDao对象
     */
    @Resource(name = "statDao")
    public void setDao(BaseDao<Stat> dao) {
        super.setDao(dao);
    }

}
