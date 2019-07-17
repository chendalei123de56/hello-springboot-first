package com.hecdu.springboot.first.service;



import com.hecdu.springboot.first.entity.User;
import com.hecdu.springboot.first.exception.LoginException;

import java.io.Serializable;
import java.util.List;

public interface IUserService{
    User login(String username, String pwd) throws LoginException;

    int register(User user);

    int update(User user);

    User findById(Serializable id);

    List<User> findAll();
}
