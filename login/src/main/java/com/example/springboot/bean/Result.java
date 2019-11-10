package com.example.springboot.bean;


public class Result<T> {
    //返回信息
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getDetail() {
        return detail;
    }

    //数据是否正常请求
    private boolean success;
    //具体返回的数据
    private T detail;

}

