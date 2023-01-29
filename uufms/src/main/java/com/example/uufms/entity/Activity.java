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
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "activity_id", type = IdType.AUTO)
    private Integer activityId;

    private String activityTitle;

    private String activityBody;

    private Integer activityMoney;
}
