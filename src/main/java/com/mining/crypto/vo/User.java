package com.mining.crypto.vo;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class User extends BaseEntity {

    private String name;
    private String password;
    private Integer gender;
    private String email;
    private Date regTime;
    private Integer status;
    private List<Role> roles;
    
}