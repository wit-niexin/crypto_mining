package com.mining.crypto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class AdminDashboard implements Serializable {

    public static final long serialVersionUID = 1L;

    public Integer totalUsers;
    public Integer totalMiners;
    public Double todayEarnings;
    public Integer pendingWithdrawals;

}