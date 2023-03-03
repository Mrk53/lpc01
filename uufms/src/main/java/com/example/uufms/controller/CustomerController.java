package com.example.uufms.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.uufms.entity.Customer;
import com.example.uufms.util.LayuiTableResponse;
import com.example.uufms.service.ICustomerService;
import com.example.uufms.util.ResponseModel;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        LayuiTableResponse layuiTableResponse ;
        log.info("page-->"+page);
        log.info("limit-->"+limit);
        log.info("searchParams-->"+searchParams);
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
    public ResponseModel delete (@RequestParam(name = "customerId") Integer customerId){
        try {
            boolean b = iCustomerService.removeById(new Customer(customerId));
            return b? ResponseModel.success() :ResponseModel.fail();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/deleteList")
    public ResponseModel deleteList (@RequestParam String list){
        try {
            List list1 = JSON.parseObject(list, List.class);
            log.info("deleteList参数"+list1);
            boolean b = iCustomerService.removeByIds(list1);
            return b? ResponseModel.success() :ResponseModel.fail();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/insert")
    public ResponseModel insert (@RequestParam Map<String,String> map){
        try {
            String customerName = map.get("customerName");
            String customerPassword = map.get("customerPassword");
            String customerGender = map.get("customerGender");
            String customerMail = map.get("customerMail");
            Customer customer = new Customer(customerName, customerPassword, customerGender, customerMail);
            boolean save = iCustomerService.save(customer);
            return save?ResponseModel.success() :ResponseModel.fail();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/update")
    public ResponseModel update(@RequestParam Map<String,String> map){
        try {
            System.out.println(map);
//            String customerName = map.get("customerName");
//            String customerPassword = map.get("customerPassword");
//            String customerGender = map.get("customerGender");
//            String customerMail = map.get("customerMail");
//            String customerId = map.get("customerId");
            String customerName = map.get("field[customerName]");
            String customerPassword = map.get("field[customerPassword]");
            String customerGender = map.get("field[customerGender]");
            String customerMail = map.get("field[customerMail]");
            String customerId = map.get("field[customerId]");
            boolean update = iCustomerService.updateById(new Customer(Integer.parseInt(customerId),customerName,customerPassword,customerGender,customerMail));
//                return ResponseModel.success(obj);
//            boolean update = iCustomerService.updateById(customer);
            return update?ResponseModel.success() :ResponseModel.fail();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
