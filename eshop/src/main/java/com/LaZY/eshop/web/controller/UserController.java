package com.LaZY.eshop.web.controller;

import com.LaZY.eshop.dao.impl.UserDaoImpl;
import com.LaZY.eshop.model.User;
import com.LaZY.eshop.service.UserService;
import com.LaZY.eshop.service.impl.UserServiceImpl;
import com.LaZY.eshop.util.ValidateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
     * @param user
     * @param req
     * @param m
     * @return
     */
    @RequestMapping(value = "/doReg",method = RequestMethod.POST)
    public String doReg(User user,HttpServletRequest req,Model m){
        String confirmPass = req.getParameter("confirmPass");
        String email = user.getEmail();
        if(!(user.getPassword().equals(confirmPass))){
            m.addAttribute("error.password.nosame","两次密码输入不一致，确认后请重新输入!!");
            return "userReg";
        }
        if(us.isRegisted(email)){
            m.addAttribute("error.email.registed","邮箱已被注册!!");
            return "userReg";
        }
        us.saveEntity(user);
        System.out.println("---------regest-finish----------");
        return "login";
    }

    /***
     * 跳转到登录也
     * @return
     */
    @RequestMapping(value = "toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    /**
     * 处理登录信息
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(User user, HttpSession session,Model m){
        String sql = "from User u where u.name = ? and u.password = ?";
        List<User> list = us.findByHQL(sql,user.getName(),user.getPassword());
        if (list == null || list.isEmpty()){
            m.addAttribute("error","用户名、密码错误");
        }else {
            //name 存放在session中
            User u = list.get(0);
            session.setAttribute("name",u.getName());
            System.out.println("----------登录成功---------");
        }
        return "index";
    }
}
