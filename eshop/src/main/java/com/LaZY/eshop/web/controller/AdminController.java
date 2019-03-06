package com.LaZY.eshop.web.controller;

import com.LaZY.eshop.model.User;
import com.LaZY.eshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(value = "/admin/userList",method = RequestMethod.GET)
    public String userList(Model m){
        System.out.println("userList-----------------------------");//log
        List<User> allUsers = us.findAllEntities();
        m.addAttribute("allUsers",allUsers);
        return "userList";
    }

    /***
     * 删除用户
     * @param uid
     * @return
     */
    @RequestMapping(value="/admin/delUser",method = RequestMethod.GET)
    public String delUser(@RequestParam("uid") int uid){
        User u = new User();
        u.setId(uid);
        us.deleteEntity(u);
        //重定向到新的url地址
        return "redirect:/admin/userList";
    }
    @RequestMapping(value="/admin/viewUser",method = RequestMethod.GET)
    public String viewUser(@RequestParam("uid") int uid,Model m){
        User u = us.getEntity(uid);
        m.addAttribute("user",u);
        return "/viewUser";
    }
}
