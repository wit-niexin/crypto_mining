package com.mining.crypto.vo;

import lombok.Data;
import java.util.Date;

@Data
public class UserBenefits extends BaseEntity {

    private String username;
    private String miningRigName;
    private Date launchDate;
    private Integer daysRunning;
    private Double dailyAverageReturn;
    private Double cumulativeReturn;
    private Double annualizedYield;
    private Double totalReturn;

}