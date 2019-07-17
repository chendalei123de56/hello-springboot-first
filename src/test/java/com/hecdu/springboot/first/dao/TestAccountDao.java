package com.hecdu.springboot.first.dao;

import com.hecdu.springboot.first.entity.Account;
import com.hecdu.springboot.first.mapper.IAccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAccountDao
{
    @Autowired
    private IAccountDao accountDao;
    @Test
    public void testFindAll(){
        List<Account> accountList = accountDao.findAll();
        if(accountList!=null){
            accountList.forEach(System.out::println);
        }
    }
}
