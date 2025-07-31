package com.mining.crypto.exception;

import com.mining.crypto.response.ResponseBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    @ExceptionHandler(LoginErrorException.class)
    public ResponseBean<String> handleException(Exception e) {
        return new ResponseBean<>(e, ResponseBean.USERNAME_NOT_FOUND_OR_PASSWORD_ERROR);
    }

}