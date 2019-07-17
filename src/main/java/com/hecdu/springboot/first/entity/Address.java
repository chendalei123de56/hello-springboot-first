package com.hecdu.springboot.first.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

@Data
//@Component
public class Address implements Serializable {
  //
  private Integer id;
 /* @Autowired
  @Qualifier("prov")*/
 //@Resource(name = "prov")
  private String province;
 /* @Autowired
  @Qualifier("city")*/
// @Resource(name = "city")
  private String city;
  private String detail;
  private String postcode;
  private String reciver;//收货人
  private String phone;//联系电话

 public Address() {
 }

 public Address(String province, String city, String detail, String postcode, String reciver, String phone) {
  this.province = province;
  this.city = city;
  this.detail = detail;
  this.postcode = postcode;
  this.reciver = reciver;
  this.phone = phone;
 }

 //@Autowired
  private User user;//维护人
}
