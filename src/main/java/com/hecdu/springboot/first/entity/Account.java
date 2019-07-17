package com.hecdu.springboot.first.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Account implements Serializable {
    private Integer id;

    private String serialNo;

    private String pinCode;

    private double balance;

    private String owner;

}
