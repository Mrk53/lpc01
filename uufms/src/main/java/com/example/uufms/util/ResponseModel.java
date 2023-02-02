package com.example.uufms.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModel {

    private int code = 200;
    private String msg ="成功";
    private Object data;

    public ResponseModel(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseModel() {

    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static ResponseModel success() {
        ResponseCodeEnum success = ResponseCodeEnum.SUCCESS;
        return new ResponseModel(success.getCode(), success.getMsg());
    }

    public static ResponseModel success(String msg) {
        ResponseModel ResponseModel = success();
        ResponseModel.msg = msg;
        return ResponseModel;
    }

    public static ResponseModel success(Object data) {
        ResponseModel ResponseModel = success();
        ResponseModel.data = data;
        return ResponseModel;
    }

    public static ResponseModel success(int code, String msg) {
        ResponseModel ResponseModel = new ResponseModel();
        ResponseModel.code = code;
        ResponseModel.msg = msg;
        return ResponseModel;
    }

    public static ResponseModel success(int code, String msg, Object data) {
        ResponseModel ResponseModel = new ResponseModel();
        ResponseModel.code = code;
        ResponseModel.msg = msg;
        ResponseModel.data = data;
        return ResponseModel;
    }

    public static ResponseModel fail() {
        ResponseCodeEnum fail = ResponseCodeEnum.FAIL;
        return new ResponseModel(fail.getCode(), fail.getMsg());
    }

    public static ResponseModel fail(int code, String msg) {
        ResponseModel ResponseModel = new ResponseModel();
        ResponseModel.code = code;
        ResponseModel.msg = msg;
        return ResponseModel;
    }
}
