package com.hecdu.springboot.first.controller;

import com.hecdu.springboot.first.data.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @Autowired
    private Data data;
    @Autowired
    private Environment env;
    @RequestMapping(value = "data")
    public String getData(){
        System.out.println("title--->"+data.getTitle());
        System.out.println("title--->"+data.getBody());

        System.out.println("env:titlle:"+env.getProperty("message.title"));
        return data.getTitle()+data.getBody();
    }
}
