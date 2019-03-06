package com.LaZY.eshop.web.controller;

import com.LaZY.eshop.dao.impl.UserDaoImpl;
import com.LaZY.eshop.model.User;
import com.LaZY.eshop.service.UserService;
import com.LaZY.eshop.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LaZY(李志一)
 * @create 2019-03-06 13:51
 */
@Controller
public class UserController {
    //注入userservice给controller
    @Resource(name = "userService")
    private UserService us;

    /***
     * 去注册页面
     * @return
     */
    @RequestMapping(value = "/pageReg" ,method = RequestMethod.GET)
    public String pageReg(){
        return "userReg";
    }

    /***
     * 完成注册，存入数据库
     * @param user 表单信息
     * @return
     */
    @RequestMapping(value = "/doReg",method = RequestMethod.POST)
    public String doReg(User user){
        us.saveEntity(user);
        System.out.println("---------regest-success----------");
        return "login";
    }

    @RequestMapping(value = "toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(User user){
        String sql = "from User u where u.name = ? and u.password = ?";
        List<User> list = us.findByHQL(sql,user.getName(),user.getPassword());
        if (list == null || list.isEmpty()){

        }else {
            System.out.println("----------登录成功---------");
        }
        return "success";
    }
}
