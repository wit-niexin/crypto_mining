package com.mining.crypto.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class User extends BaseEntity {

    private String name;
    private String legalName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String avatar;
    private Integer gender;
    private String phone;
    private String email;
    private Date regTime;
    private Integer status;
    private List<Role> roles;

}