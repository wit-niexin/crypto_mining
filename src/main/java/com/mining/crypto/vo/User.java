package com.mining.crypto.vo;

import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableField(exist = false)
    private List<Role> roles;
    
}