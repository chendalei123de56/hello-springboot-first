package com.hecdu.springboot.first.dao.impl;



import com.hecdu.springboot.first.dao.IUserDao;
import com.hecdu.springboot.first.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Component
@Transactional
public class UserDaoImpl implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void save(User user) {
        if (null == user) {
            return;
        }
        String sql = "insert into user(name,password,realName,status) values(?,?,?,?)";
        int update = jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getRealName()
                , user.getStatus().toString()

        );

    }

    @Override
    public void delete(Serializable id) {
        if (null == id) {
            return;
        }
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(User user) {
        if (null == user) {
            return;
        }
        String sql = "update user set name=?,password=?,realName=?,status=? where id=?";
        jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getRealName()
                , user.getStatus().toString(), user.getId()
        );

    }

    @Override
    public User findById(Serializable id) {
        if (null == id) {
            return null;
        }
        String sql = "select * from user where id=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public User findByName(String name) {
        if (null == name) {
            return null;
        }
        String sql = "select * from user where name=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, name);
    }
}
