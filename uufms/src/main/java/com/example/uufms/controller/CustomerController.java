package com.example.uufms.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.uufms.entity.Customer;
import com.example.uufms.entity.LayuiTableResponse;
import com.example.uufms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 廉鹏程
 * @since 2023-01-29
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @PostMapping("/login")
    public String login(@RequestParam(name = "customerName") String customerName,
                        @RequestParam(name = "customerPassword") String customerPassword){
        QueryWrapper<Customer> customerQueryWrapper = new QueryWrapper<>();
        customerQueryWrapper.eq("customer_name",customerName).eq("customer_password",customerPassword);
        Customer one = iCustomerService.getOne(customerQueryWrapper);
        return null == one ? "false":"true";
    }

    @GetMapping("/getAll")
    public String getAll(@RequestParam(name = "page") int page,
                         @RequestParam(name = "limit") int limit){
        LayuiTableResponse layuiTableResponse =null;
        try {
            QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
            Page<Customer> customerPage = new Page<>(page, limit);
            Page<Customer> page1 = iCustomerService.page(customerPage, queryWrapper);
             layuiTableResponse = new LayuiTableResponse(0, "success", (int) page1.getSize(), page1.getRecords());
            return JSON.toJSONString(layuiTableResponse);
        } catch (Exception e) {
            layuiTableResponse = new LayuiTableResponse(500, "获取数据失败->"+e.getMessage(), 0, new ArrayList<>() );
            return JSON.toJSONString(layuiTableResponse);
        }
    }
}
