package com.example.uufms.util;

public enum ResponseCodeEnum {
    SUCCESS(200, "成功"),
    NOT_FOUND(404, "资源不存在"),
    FAIL(500, "服务异常"),
    EXCEPTION_PARAMS(407, "异常参数");

    private final int code;
    private final String msg;

    private ResponseCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
