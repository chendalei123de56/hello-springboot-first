package com.hecdu.springboot.first.controller;

import com.hecdu.springboot.first.entity.User;
import com.hecdu.springboot.first.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "thymeleaf")
public class ThymeleafController {
    @Autowired
    private IUserService userService;
    @RequestMapping("index")
    public String index(Model model){
        //模拟一个User对象
        User user=userService.findById(61);

        List<User> userList = new ArrayList<>();
        User u1 = new User();
        u1.setName("jack");
        u1.setRealName("马云");
        userList.add(u1);

        User u2 = new User();
        u2.setName("peter");
        u2.setRealName("马化腾");
        userList.add(u2);
        //
        model.addAttribute("users",userList);

        model.addAttribute("user",user);
        return "index";//相当于templates/index.html
    }
}


