package com.example.uufms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "测试接口")
public class Test {
    @GetMapping("/test1")
    @ApiOperation(value = "测试接口1")
    public String test1(){
        return "hello,world";
    }
}
