package com.example.uufms.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LayuiTableResponse {
    private int code ;
    private String message;
    private int count;
    private List data;

    public LayuiTableResponse(String message, int count, List data) {
        this.code = 0;
        this.message = message;
        this.count = count;
        this.data = data;
    }

    public LayuiTableResponse(int count, List data) {
        this.code = 0;
        this.message = "success";
        this.count = count;
        this.data = data;
    }

    public LayuiTableResponse(int code) {
        this.code = code;
    }
}
