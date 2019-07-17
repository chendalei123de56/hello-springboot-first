package com.hecdu.springboot.first.service.impl;


import com.hecdu.springboot.first.dao.IUserDao;
import com.hecdu.springboot.first.entity.User;
import com.hecdu.springboot.first.exception.LoginException;
import com.hecdu.springboot.first.exception.LoginNameNotExistsException;
import com.hecdu.springboot.first.exception.PasswordIncorrectException;
import com.hecdu.springboot.first.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
//@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public User login(String username, String pwd) throws LoginException {
        User user=null;
        try {
          user= userDao.findByName(username);
        }catch (RuntimeException e){
            throw new  LoginException("登陆异常！！！");
        }

        if(user==null){
           throw new LoginNameNotExistsException("用户名不存在！！！");
        }
        //进一步判断密码
        if(!user.getPassword().equals(pwd)){
            //密码是错的
            throw  new PasswordIncorrectException("密码不正确！！！");
        }
        return user;
    }

    @Override
    public int register(User user) {
        try {
            userDao.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int update(User user) {
        try {
            userDao.update(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public User findById(Serializable id) {

        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
