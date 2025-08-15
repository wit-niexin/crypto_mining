package com.mining.crypto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserDashboard implements Serializable {

    public static final long serialVersionUID = 1L;

    public Long totalProfit;
    public Long todayProfit;
    public Double annualizedReturn;
    public Long walletBalance;

}