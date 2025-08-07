package com.mining.crypto.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRole extends BaseEntity {

    private String userId;
    private String roleId;

}