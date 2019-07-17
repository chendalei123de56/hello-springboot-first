package com.hecdu.springboot.first.dao.impl;




import com.hecdu.springboot.first.dao.IAddressDao;
import com.hecdu.springboot.first.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Component
@Transactional(
        propagation = Propagation.NESTED,
        isolation = Isolation.READ_COMMITTED,
        timeout = -1,
        readOnly = false
)
public class AddressDaoImpl implements IAddressDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public void save(Address address) {
        if (null == address) {
            return;
        }
        String sql = "insert into address(province,city,detail,postcode,reciver,phone,user_id) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, address.getProvince(), address.getCity(), address.getDetail(), address.getPostcode()
                , address.getReciver(), address.getUser().getId(),
                address.getUser().getId() != null ? address.getUser().getId() : null);
    }

    @Override
    public void delete(Serializable id) {
        if (null == id) {
            return;
        }
        String sql = "delete from address where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Address address) {
        String sql = "update address set province=?,city=?,detail=?,postcode=?,reciver=?,phone=? where id=? ";
        jdbcTemplate.update(sql, address.getProvince(), address.getCity(), address.getDetail(),address.getPostcode()
                ,address.getReciver(),address.getPhone(),address.getId());
    }

    @Override
    public Address findById(Serializable id) {
        if (null == id) {
            return null;
        }
        String sql = "select * from address where id=?";
        RowMapper<Address> rowMapper=new BeanPropertyRowMapper<>(Address.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public List<Address> findAll() {
        String sql = "select * from address";
        RowMapper<Address> rowMapper=new BeanPropertyRowMapper<>(Address.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
    @Override
    public List<Address> findByUserId(Serializable userId) {
        if(null==userId){
            return null;
        }
        String sql = "select * from address where user_id= userId";
        RowMapper<Address> rowMapper=new BeanPropertyRowMapper<>(Address.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
}
