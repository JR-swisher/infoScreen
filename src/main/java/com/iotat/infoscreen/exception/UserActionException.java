package com.iotat.infoscreen.exception;

import com.iotat.infoscreen.common.result.ResponseEnum;

/**
 * @Description 用户操作异常
 * @ClassName UserActionException
 * @Author pang
 * @date 2020.01.10 20:50
 */
public class UserActionException extends RuntimeException {

    private ResponseEnum exceptionType;

    public UserActionException() {
        this("用户操作异常", ResponseEnum.SYSTEM_ERROR);
    }

    public UserActionException(String message, ResponseEnum exceptionType) {
        super(message);
        this.exceptionType = exceptionType;
    }

    public ResponseEnum getExceptionType() {
        return exceptionType;
    }
}
