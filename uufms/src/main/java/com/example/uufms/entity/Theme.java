package com.example.uufms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Theme implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "theme_id", type = IdType.AUTO)
    private Integer themeId;

    private String themeTitle;

    private String themeBody;

    private Integer themeIssuer;

    private LocalDateTime themeCreateTime;

    private LocalDateTime themeUpdateTime;
}
