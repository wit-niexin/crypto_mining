package com.mining.crypto.response;

import com.mining.crypto.vo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserInfo implements Serializable {

    public static final long serialVersionUID = 1L;

    public User user;
    public String token;

}