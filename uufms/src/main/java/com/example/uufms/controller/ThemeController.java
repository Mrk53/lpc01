package com.example.uufms.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.uufms.entity.Theme;
import com.example.uufms.service.IThemeService;
import com.example.uufms.util.LayuiTableResponse;
import com.example.uufms.util.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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
    public String getTheme(@RequestParam(name = "page") int page,
                         @RequestParam(name = "limit") int limit,
                            @RequestParam(name = "searchParams",required = false) String searchParams){
        LayuiTableResponse layuiTableResponse =null;
        try {
            QueryWrapper<Theme> queryWrapper = new QueryWrapper<>();
            if(searchParams!=null){
                HashMap<String,String> hashMap = JSON.parseObject(searchParams, HashMap.class);
                String themeTitle = hashMap.get("themeTitle");
                String themeBody = hashMap.get("themeBody");
                if(themeTitle!=null){
                    queryWrapper.like("theme_title",themeTitle);
                }
                if(themeBody!=null){
                    queryWrapper.like("theme_body",themeBody);
                }
            }
            Page<Theme> themePage = new Page<>(page, limit);
            Page<Theme> page1 = iThemeService.page(themePage, queryWrapper);
            layuiTableResponse = new LayuiTableResponse((int) page1.getSize(), page1.getRecords());
            return JSON.toJSONString(layuiTableResponse);
        } catch (Exception e) {
            layuiTableResponse = new LayuiTableResponse(500);
            return JSON.toJSONString(layuiTableResponse);
        }
    }

    @RequestMapping("/saveTheme")
    public ResponseModel saveTheme(Theme theme){
        if(iThemeService.saveOrUpdate(theme)){
            return ResponseModel.success(200,"success",theme);
        }else {
            return ResponseModel.fail(500,"调用接口失败");
        }
    }

    @RequestMapping("/delTheme")
    public ResponseModel delTheme(Integer themeId){
        if(iThemeService.removeById(themeId)){
            return ResponseModel.success(200,"success",themeId);
        }else {
            return ResponseModel.fail(500,"调用接口失败");
        }
    }

    @RequestMapping("/editTheme")
    public ResponseModel editTheme(Theme theme){
        if(iThemeService.updateById(theme)){
            System.out.println("--------------------------------------------------");
            return ResponseModel.success(200,"success",theme);
        }else {
            return ResponseModel.fail(500,"调用接口失败");
        }
    }


}
