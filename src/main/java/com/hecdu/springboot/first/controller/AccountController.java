package com.hecdu.springboot.first.controller;


import com.hecdu.springboot.first.exception.AccoutException;
import com.hecdu.springboot.first.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @RequestMapping("/deposit/{id}/{money}")
    public String deposit(@PathVariable("id") Integer id,
                          @PathVariable("money") Double money,
                          Model model){
        try {
            int i=accountService.deposit(id,money);
            System.out.println("========调用deposit方法=========");
            if(i>0){
                model.addAttribute("deposit_key","存钱成功！！！");
            }

        } catch (AccoutException e) {
            model.addAttribute("deposit_key",e.getMessage());
        }
        return "forward:/account.jsp";
    }
    @RequestMapping("/withdraw")
    public String withdraw(Integer id, Double money, Model model){
        try {
            int i=accountService.withdraw(id,money);
            if(i>0){
                model.addAttribute("withdraw_key","取钱成功！！！");
            }

        } catch (AccoutException e) {
            model.addAttribute("withdraw_key",e.getMessage());
        }
        return "forward:/account.jsp";
    }
    @RequestMapping("/transfor")
    public String transfor(Integer from,Integer to,Double money, Model model){
        try {
            int i=accountService.transfor(from,to,money);
            if(i>0){
                model.addAttribute("transfor_key","转账成功！！！");
            }

        } catch (AccoutException e) {
            model.addAttribute("transfor_key",e.getMessage());
        }
        return "forward:/account.jsp";
    }
    @RequestMapping(value = "/hello",produces = "application/json")
    @ResponseBody()
    public String hello(){
        System.out.println("hello被调用了！！！");
        return "{id:1,name:'jack'}";
    }
}
