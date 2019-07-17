package com.hecdu.springboot.first.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String realName;
    private UserStatus status=UserStatus.正常;
    private List<Address> adderssList;


}
