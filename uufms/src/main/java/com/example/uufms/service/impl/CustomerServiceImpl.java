package com.example.uufms.service.impl;

import com.example.uufms.entity.Customer;
import com.example.uufms.mapper.CustomerMapper;
import com.example.uufms.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 廉鹏程
 * @since 2023-01-29
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
