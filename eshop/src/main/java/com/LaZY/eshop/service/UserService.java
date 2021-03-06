package com.LaZY.eshop.service;

import com.LaZY.eshop.model.User;
import org.springframework.stereotype.Service;

/**
 * UserService业务接口
 */

public interface UserService extends  BaseService<User>{
    /***
     * 验证邮箱
     * @param email
     * @return
     */
    public boolean isRegisted(String email);
}
