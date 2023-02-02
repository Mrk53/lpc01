package com.example.uufms.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.uufms.entity.Customer;
import com.example.uufms.entity.LayuiTableResponse;
import com.example.uufms.entity.Theme;
import com.example.uufms.service.IThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 廉鹏程
 * @since 2023-01-29
 */
@RestController
@RequestMapping("/theme")
public class ThemeController {
    @Autowired
    IThemeService iThemeService;

    @RequestMapping("/getTheme")
    public String getATheme(@RequestParam(name = "page") int page,
                         @RequestParam(name = "limit") int limit){
        LayuiTableResponse layuiTableResponse =null;
        try {
            QueryWrapper<Theme> queryWrapper = new QueryWrapper<>();
            Page<Theme> themePage = new Page<>(page, limit);
            Page<Theme> page1 = iThemeService.page(themePage, queryWrapper);
            layuiTableResponse = new LayuiTableResponse(0, "success", (int) page1.getSize(), page1.getRecords());
            return JSON.toJSONString(layuiTableResponse);
        } catch (Exception e) {
            layuiTableResponse = new LayuiTableResponse(500, "获取数据失败->"+e.getMessage(), 0, new ArrayList<>() );
            return JSON.toJSONString(layuiTableResponse);
        }
    }
}
