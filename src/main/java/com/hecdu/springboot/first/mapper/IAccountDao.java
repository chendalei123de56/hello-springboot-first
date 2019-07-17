package com.hecdu.springboot.first.mapper;



import com.hecdu.springboot.first.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;
@Mapper
public interface IAccountDao {
    int save(Account account);

    int delete(Serializable id);

    int update(Account account);

    Account  findById(Serializable id);

    List<Account> findAll();

}
