package com.mining.crypto.response;

import lombok.Data;
import java.io.Serializable;

@Data
public class ResponseBean<T> implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * Token错误
     */
    public static final int NO_LOGIN = -1;

    /**
     * 业务操作成功
     */
    public static final int SUCCESS = 200;

    /**
     * 业务操作失败
     */
    public static final int FAIL = 500;

    /**
     * 验证码错误
     */
    public static final int INVALID_VALIDATE_CODE_ERROR = 478;

    /**
     * 用户名或或密码错误
     */
    public static final int USERNAME_NOT_FOUND_OR_PASSWORD_ERROR = 400;

    /**
     * 当前操作没有权限
     */
    public static final int UNAUTHORIZED = 401;

    private String msg = "success";
    private int code = SUCCESS;
    private T data;

    public ResponseBean(T data) {
        this.data = data;
    }

    public ResponseBean(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public ResponseBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseBean(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public ResponseBean(Throwable e) {
        this.msg = e.getMessage();
        this.code = FAIL;
    }

    public ResponseBean(Throwable e, int code) {
        this.msg = e.getMessage();
        this.code = code;
    }

}