package com.mining.crypto.vo;

import lombok.Data;
import java.util.Date;

@Data
public class UserWallet extends BaseEntity {

    private String username;
    private Date time;
    private Integer status;
    private Double money;

}