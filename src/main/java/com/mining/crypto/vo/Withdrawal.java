package com.mining.crypto.vo;

import lombok.Data;
import java.util.Date;

@Data
public class Withdrawal extends BaseEntity {

    private String userName;
    private Double money;
    private Double handlingFee;
    private String walletId;
    private String address;
    private String network;
    private Date applicationTime;
    private Date approvalTime;
    private Integer status;
    private String approver;

}