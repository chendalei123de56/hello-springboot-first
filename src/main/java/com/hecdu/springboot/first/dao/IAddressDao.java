package com.hecdu.springboot.first.dao;



import com.hecdu.springboot.first.entity.Address;

import java.io.Serializable;
import java.util.List;

public interface IAddressDao {
    void save(Address address);

    void delete(Serializable id);

    void update(Address address);

    Address findById(Serializable id);

    List<Address> findAll();

    List<Address> findByUserId(Serializable userId);
}
