package com.mining.crypto.response;

import lombok.Data;
import java.io.Serializable;

@Data
public class ResponseBean<T> implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 服务正常
     */
    public static final int SUCCESS = 200;

    /**
     * 服务异常
     */
    public static final int FAIL = 500;

    /**
     * 权限异常
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