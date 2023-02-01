package com.example.uufms.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LayuiTableResponse {
    private int code;
    private String message;
    private int count;
    private List data;
}
