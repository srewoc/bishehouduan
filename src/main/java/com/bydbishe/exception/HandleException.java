package com.bydbishe.exception;

import com.bydbishe.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        return Result.fail(ex.getMessage());
    }
}
