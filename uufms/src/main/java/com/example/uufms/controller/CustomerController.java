package com.example.uufms.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.uufms.entity.Customer;
import com.example.uufms.util.LayuiTableResponse;
import com.example.uufms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
                         @RequestParam(name = "limit") int limit,
                         @RequestParam(name = "searchParams",required = false) String searchParams){
        LayuiTableResponse layuiTableResponse =null;
        try {
            QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
            Page<Customer> customerPage = new Page<>(page, limit);
            if (null != searchParams){
                HashMap<String,String> hashMap = JSON.parseObject(searchParams, HashMap.class);
                String customerName = hashMap.get("customerName");
                String customerGender = hashMap.get("customerGender");
                if (null!=customerName){
                    queryWrapper.like("customer_name",customerName);

                }
                if (null!=customerGender){
                    queryWrapper.like("customer_gender",customerGender);
                }
            }

            Page<Customer> page1 = iCustomerService.page(customerPage, queryWrapper);
             layuiTableResponse = new LayuiTableResponse((int) iCustomerService.count(queryWrapper), page1.getRecords());
            return JSON.toJSONString(layuiTableResponse);
        } catch (Exception e) {
            layuiTableResponse = new LayuiTableResponse(500);
            return JSON.toJSONString(layuiTableResponse);
        }
    }

    @DeleteMapping("/delete")
    public String delete (@RequestParam(name = "customerId") Integer customerId){
        try {
            boolean b = iCustomerService.removeById(new Customer(customerId));
            return b?"success":"false";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/insert")
    public String insert (@RequestBody Map<String,String> map){
        try {
            String customerName = map.get("customerName");
            String customerPassword = map.get("customerPassword");
            String customerGender = map.get("customerGender");
            String customerMail = map.get("customerMail");
            Customer customer = new Customer(customerName, customerPassword, customerGender, customerMail);
            boolean save = iCustomerService.save(customer);
            return save?"success":"false";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/update")
    public String update(@RequestBody Customer customer){
        try {
            boolean update = iCustomerService.updateById(customer);
            return update?"success":"false";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
