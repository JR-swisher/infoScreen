package com.iotat.infoscreen.exception;

/**
 * @Description Token认证超时异常
 * @ClassName TokenTimeOutException
 * @Author pang
 * @date 2020.01.10 21:01
 */
public class TokenTimeOutException extends RuntimeException {
    private String token;

    public TokenTimeOutException(String token) {
        this("token过期，请重新登录", token);
    }

    public TokenTimeOutException(String message, String token) {
        super(message);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
