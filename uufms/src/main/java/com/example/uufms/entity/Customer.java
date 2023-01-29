package com.example.uufms.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
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

      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private LocalDateTime lastLoadTime;

    /**
     * 1是男，2是女，0为空
     */
    private String customerGender;

    private String customerMail;
}
