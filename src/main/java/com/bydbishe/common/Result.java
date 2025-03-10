package com.bydbishe.common;

import lombok.Data;

import java.io.Serializable;
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }
    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.code = 1;
        result.data = object;
        return result;
    }
    public static <T> Result<T> fail(String msg) {
        Result result = new Result();
        result.code = 0;
        result.msg = msg;
        return result;
    }
    
}
