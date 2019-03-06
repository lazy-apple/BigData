package com.LaZY.eshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LaZY(李志一)
 * @create 2019-03-05 13:52
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String toHome(){
        return  "index";
    }

}
