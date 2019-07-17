package com.hecdu.springboot.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping( "index")
    @ResponseBody
    public String sayhi(){
        return "欢迎使用Springboot,它会使你快乐!!!";
    }
}
