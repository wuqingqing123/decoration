package com.zx.decoration.controller;


import com.zx.decoration.entity.ProgressDetail;
import com.zx.decoration.service.ProgressDetailService;
import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 订单进度明细表 前端控制器
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/api/progressDetail")
public class ProgressDetailController {

    @Autowired
    private ProgressDetailService progressDetailService;

    /**
     * 分页查询当前订单下所有进度
     * @param progressDetail
     * @return
     */
    @PostMapping("/queryAllProgress")
    public ResponseEntity queryAllProgress(@RequestBody ProgressDetail progressDetail){
        try{
            ProgressDetail[] progressDetails = progressDetailService.queryAllProgress(progressDetail);
            return new RestReturn().success(progressDetails,"查询成功");
        }catch (Exception e){
            return  new RestReturn().error(e);
        }
    }

    @GetMapping("/queryProgressCount/{orderId}")
    public ResponseEntity queryProgressCount(@PathVariable("orderId") String orderId){
        try{
            Integer count = progressDetailService.queryProgressCount(orderId);
            return new RestReturn().success(count,"数量查找成功");
        }catch (Exception e){
            return new RestReturn().error(e);
        }
    }

    @PostMapping("/onSaveProgress")
    public ResponseEntity onSaveProgress(@RequestBody ProgressDetail progressDetail)throws Exception{
        try{
            progressDetailService.onsaveProgressDetail(progressDetail);
            return new RestReturn().success("","保存成功");
        }catch(Exception e){
            return new RestReturn().error(e);
        }
    }


}
