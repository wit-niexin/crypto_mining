package com.mining.crypto.vo;

import lombok.Data;
import java.util.Date;

@Data
public class MiningRig extends BaseEntity {

    private String name;
    private String model;
    private Integer status;  // 状态标记 0: 运行中1:待机
    private Double price;
    private Date commissioningDate;

}