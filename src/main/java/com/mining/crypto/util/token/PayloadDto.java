package com.mining.crypto.util.token;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("Payload实体类")
@Builder
@EqualsAndHashCode(callSuper = false)
public class PayloadDto {

    @ApiModelProperty("主题")
    private String sub;

    @ApiModelProperty("签发时间")
    private Long iat;

    @ApiModelProperty("过期时间")
    private Long exp;

    @ApiModelProperty("JWT ID")
    private String jti;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户权限")
    private List<String> authorities;
}