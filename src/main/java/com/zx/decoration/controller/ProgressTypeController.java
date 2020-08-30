package com.zx.decoration.controller;


import com.zx.decoration.entity.ProgressType;
import com.zx.decoration.service.ProgressTypeService;
import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单阶段类型表 前端控制器
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/api/progressType")
public class ProgressTypeController {

    @Autowired
    private ProgressTypeService progressTypeService;

    @GetMapping("queryAllProgress")
    public ResponseEntity queryAllProgress(){
        try{
            ProgressType[] progressTypes = progressTypeService.queryAllProgress();
            return  new RestReturn().success(progressTypes,"");
        }catch (Exception e){
            return  new RestReturn().error(e);
        }
    }

}
