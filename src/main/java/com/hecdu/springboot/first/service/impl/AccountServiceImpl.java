package com.hecdu.springboot.first.service.impl;


import com.hecdu.springboot.first.entity.Account;
import com.hecdu.springboot.first.exception.AccoutException;
import com.hecdu.springboot.first.mapper.IAccountDao;
import com.hecdu.springboot.first.service.IAccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountException;
import java.io.Serializable;


@Service
@Transactional(
        propagation = Propagation.REQUIRED,
        isolation= Isolation.READ_COMMITTED,
        timeout = -1,
        readOnly = false,
        rollbackFor = {AccountException.class,RuntimeException.class}
)
public class AccountServiceImpl  implements IAccountService {
    private final Logger LOGGER=Logger.getLogger(AccountServiceImpl.class);
    @Autowired
    private IAccountDao accountDao;
    @Override
    //存钱方法
    public int deposit(Serializable id, double money) throws AccoutException {
        //根据id查询目标账户
        Account from=accountDao.findById(id);
        if(from==null){
            LOGGER.warn("账户["+id+"]不存在");
            throw  new AccoutException("账户["+id+"]不存在");
        }
        from.setBalance(from.getBalance()+money);
        accountDao.update(from);
        return 1;
    }

    @Override
    //取钱
    public int withdraw(Serializable id, double money) throws AccoutException {
        //根据id查询目标账户
        Account from=accountDao.findById(id);
        if(from==null){
            LOGGER.warn("账户["+id+"]不存在");
            throw  new AccoutException("账户不存在");
        }
        if(from.getBalance()<money){
            LOGGER.warn("账户["+id+"]余额不足!!!");
            throw  new AccoutException("账户余额不足!!!");
        }

        from.setBalance(from.getBalance()-money);
        accountDao.update(from);
        return 1;
    }

    @Override
    public int transfor(Serializable from, Serializable to, double money) throws AccoutException {
        Account fromAccount=accountDao.findById(from);
        if(fromAccount==null){
            LOGGER.warn("源账户["+from+"]不存在");
            throw  new AccoutException("源账户不存在");
        }
        Account toAccount=accountDao.findById(to);
        if(toAccount==null){
            LOGGER.warn("目标账户["+to+"]不存在");
            throw  new AccoutException("目标账户不存在");
        }
        if(fromAccount.getBalance()<money){
            LOGGER.warn("账户["+from+"]余额不足");
            throw  new AccoutException("余额不足！！！");
        }
        fromAccount.setBalance(fromAccount.getBalance()-money);
        toAccount.setBalance(toAccount.getBalance()+money);
        accountDao.update(fromAccount);
        accountDao.update(toAccount);
        return 1;
    }
}
