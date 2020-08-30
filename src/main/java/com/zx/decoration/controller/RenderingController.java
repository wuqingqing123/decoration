package com.zx.decoration.controller;


import com.zx.decoration.entity.Rendering;
import com.zx.decoration.service.RenderingService;
import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 效果图表 前端控制器
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/api/rendering")
public class RenderingController {

    @Autowired
    private RenderingService renderingService;

    @GetMapping("queryAllRendering")
    public ResponseEntity selectAllRendering(){
        try{
            Rendering[] renderings = renderingService.selectAllRendering();
            return new RestReturn().success(renderings,"查询成功");
        }catch (Exception e){
            return new RestReturn().error(e);
        }
    }


}
