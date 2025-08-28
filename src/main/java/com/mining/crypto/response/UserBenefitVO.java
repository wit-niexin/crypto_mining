package com.mining.crypto.response;

import com.mining.crypto.vo.UserBenefit;
import lombok.Data;

@Data
public class UserBenefitVO extends UserBenefit {

    private String userLegalName;   // 对应 user.legal_name

}