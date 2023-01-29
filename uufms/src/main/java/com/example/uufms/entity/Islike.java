package com.example.uufms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
public class Islike implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "islike_id", type = IdType.AUTO)
    private Integer islikeId;

    private Integer discussId;

    private Integer customerId;
}
