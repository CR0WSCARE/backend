package com.example.backend.exception;

import com.example.backend.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class globalException {
    @ExceptionHandler(serviceException.class)
    @ResponseBody
    public Result serviceException(serviceException e){
        return Result.error("500", e.getMessage());
    }
}
