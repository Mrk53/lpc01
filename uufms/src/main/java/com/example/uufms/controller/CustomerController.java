package com.example.uufms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.uufms.entity.Customer;
import com.example.uufms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        customerQueryWrapper.eq("customerName",customerName).eq("customerPassword",customerPassword);
        Customer one = iCustomerService.getOne(customerQueryWrapper);
        return null == one ? "false":"true";
    }

}
