package com.hecdu.springboot.first.dao;




import com.hecdu.springboot.first.entity.User;

import java.io.Serializable;
import java.util.List;

public interface IUserDao {
    void save(User user);

    void delete(Serializable id);

    void update(User user);

    User findById(Serializable id);


    List<User> findAll();

    User findByName(String name);
}
