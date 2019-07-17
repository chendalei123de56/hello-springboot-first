package com.hecdu.springboot.first.service.impl;

import com.hecdu.springboot.first.dao.IAddressDao;
import com.hecdu.springboot.first.entity.Address;
import com.hecdu.springboot.first.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
@Transactional
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private IAddressDao addressDao;
    @Override
    public List<Address> findAllByUser(Serializable userId) {
        return addressDao.findByUserId(userId);
    }

    @Override
    public int addAddress(Address address) {
        return 0;
    }

    @Override
    public int deleteAddress(Serializable addressId) {
        return 0;
    }

    @Override
    public Address findById(Serializable addressId) {
        return null;
    }
}
