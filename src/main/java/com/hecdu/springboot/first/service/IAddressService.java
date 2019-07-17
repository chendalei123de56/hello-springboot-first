package com.hecdu.springboot.first.service;



import com.hecdu.springboot.first.entity.Address;

import java.io.Serializable;
import java.util.List;

public interface IAddressService {
    List<Address> findAllByUser(Serializable userId);

    int addAddress(Address address);

    int  deleteAddress(Serializable addressId);

    Address findById(Serializable addressId);
}
