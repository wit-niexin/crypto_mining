package com.mining.crypto.vo;

import lombok.Data;
import java.util.Date;

@Data
public class User extends BaseEntity {

    private String name;
    private String password;
    private Integer gender;
    private String email;
    private Date regTime;
    private Integer status;
    
}