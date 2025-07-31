package com.mining.crypto.exception;

public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CommonException() {
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

}