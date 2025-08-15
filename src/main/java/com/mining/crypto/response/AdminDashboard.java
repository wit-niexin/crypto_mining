package com.mining.crypto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class AdminDashboard implements Serializable {

    public static final long serialVersionUID = 1L;

    public Long totalUsers;
    public Long totalMiners;
    public Long todayEarnings;
    public Long pendingWithdrawals;

}