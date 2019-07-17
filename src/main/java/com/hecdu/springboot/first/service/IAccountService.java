package com.hecdu.springboot.first.service;



import com.hecdu.springboot.first.exception.AccoutException;

import java.io.Serializable;

public interface IAccountService {
    //存钱方法
    int deposit(Serializable id, double money) throws AccoutException;
    //取钱方法
    int withdraw(Serializable id, double money) throws AccoutException;
    //转账方法
    int transfor(Serializable from, Serializable to, double money)  throws AccoutException;
}
