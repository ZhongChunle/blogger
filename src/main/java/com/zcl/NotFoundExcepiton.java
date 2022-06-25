package com.zcl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 项目名称：blogger
 * 描述：资源找不到异常
 *
 * @author zhong
 * @date 2022-06-24 21:50
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExcepiton extends RuntimeException{
    public NotFoundExcepiton() {
    }

    public NotFoundExcepiton(String message) {
        super(message);
    }

    public NotFoundExcepiton(String message, Throwable cause) {
        super(message, cause);
    }
}
