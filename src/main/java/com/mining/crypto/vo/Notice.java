package com.mining.crypto.vo;

import lombok.Data;
import java.util.Date;

@Data
public class Notice extends BaseEntity {

    private String title;
    private String content;
    private Date time;
    private Integer status;
    private Integer top;
    private Integer push;

}