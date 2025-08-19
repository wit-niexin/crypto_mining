package com.mining.crypto.vo;

import lombok.Data;

@Data
public class UserDashboard extends BaseEntity {

    private String userName;
    private Double totalProfit;
    private Double todayProfit;
    private Double annualizedReturn;
    private Double walletBalance;

}