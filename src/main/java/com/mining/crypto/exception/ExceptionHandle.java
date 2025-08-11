package com.mining.crypto.exception;

import com.mining.crypto.response.ResponseBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    @ExceptionHandler(LoginErrorException.class)
    public ResponseBean<String> handleException1(Exception e) {
        return new ResponseBean<>(e.getMessage(), "fasle");
    }

    @ExceptionHandler(SaveErrorException.class)
    public ResponseBean<String> handleException2(Exception e) {
        return new ResponseBean<>(e.getMessage(), "fasle");
    }

    @ExceptionHandler(TokenErrorException.class)
    public ResponseBean<String> handleException3(Exception e) {
        return new ResponseBean<>(e.getMessage(), "fasle");
    }

}