package com.example.uufms.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 廉鹏程
 * @since 2023-01-29
 */
@Getter
@Setter
@AllArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
      @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;

    private String customerName;

    private String customerPassword;

    /**
     * 1是管理员，0是普通用户
     */
    private String customerLevel;

    private LocalDateTime createTime;

    private LocalDateTime lastLoadTime;

    /**
     * 1是男，2是女，0为空
     */
    private String customerGender;

    private String customerMail;


    public Customer(String customerName, String customerPassword, String customerGender, String customerMail) {
        this.customerGender= customerGender;
        this.customerPassword= customerPassword;
        this.customerName= customerName;
        this.customerMail= customerMail;
    }

    public Customer(Integer customerId, String customerName, String customerPassword, String customerGender, String customerMail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPassword = customerPassword;
        this.customerGender = customerGender;
        this.customerMail = customerMail;
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }
}
