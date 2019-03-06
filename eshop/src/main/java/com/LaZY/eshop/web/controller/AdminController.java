package com.LaZY.eshop.web.controller;

import com.LaZY.eshop.model.User;
import com.LaZY.eshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**管理员
 * @author LaZY(李志一)
 * @create 2019-03-06 19:43
 */
@Controller
public class AdminController {
    @Resource
    private UserService us;
    /**
     * 查看用户列表
     */
    @RequestMapping(value = "/admin/userlist",method = RequestMethod.GET)
    public String userList(Model m){
        List<User> allUsers = us.findAllEntities();
        m.addAttribute("allUsers",allUsers);
        return "userList";
    }
}
