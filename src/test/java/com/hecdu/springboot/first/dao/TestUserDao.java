package com.hecdu.springboot.first.dao;

import com.hecdu.springboot.first.HelloSpringbootFirstApplication;
import com.hecdu.springboot.first.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class TestUserDao {
    @Autowired
    private IUserDao userDao;
    @Test
    public void testFindAll(){
        List<User> userList=userDao.findAll();
        if(userList!=null){
            userList.forEach( System.out::println);
        }
    }
}
