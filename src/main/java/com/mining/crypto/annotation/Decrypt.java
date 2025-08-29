package com.mining.crypto.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Decrypt {
    String value() default "password";
}

