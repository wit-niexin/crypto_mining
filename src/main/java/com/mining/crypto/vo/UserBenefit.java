package com.mining.crypto.vo;

import lombok.Data;
import java.util.Date;

@Data
public class UserBenefit extends BaseEntity {

    private String userName;
    private String miningRigName;
    private Date launchDate;
    private Integer status;
    private Integer daysRunning;
    private Double dailyAverageReturn;
    private Double cumulativeReturn;
    private Double annualizedYield;
    private Double totalReturn;

}