package com.ln.entity;

public enum  Code {

    Success(1,"请求成功"),
    Fail(-1, "请求出错"),
    NoData(-2, "没有数据");

    Code(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


}
