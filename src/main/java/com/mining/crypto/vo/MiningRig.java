package com.mining.crypto.vo;

import lombok.Data;
import java.util.Date;

@Data
public class MiningRig extends BaseEntity {

    private String name;
    private String model;
    private Integer status;
    private Double price;
    private Date commissioningDate;

}