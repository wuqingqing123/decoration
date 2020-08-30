package com.zx.decoration.controller;


import com.zx.decoration.entity.ProgressPicture;
import com.zx.decoration.service.ProgressDetailService;
import com.zx.decoration.service.ProgressPictureService;
import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 进度效果表 前端控制器
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/api/progressPicture")
public class ProgressPictureController {

    @Autowired
    private ProgressPictureService progressPictureService;

    /**
     * 查询当前进度下所有照片
     * @param progressId
     * @return
     */
    @GetMapping("/queryAllPicture/{progressId}")
    public ResponseEntity queryAllPicture(@PathVariable("progressId") String progressId){
        try{
            ProgressPicture[] progressPictures = progressPictureService.queryAllPicture(progressId);
            return new RestReturn().success(progressPictures,"查询成功");
        }catch (Exception e){
            return new RestReturn().error(e);
        }
    }

    /**
     * 插入照片记录
     * @param progressPicture
     * @return
     */
    @PostMapping("/saveprogressPicture")
    public ResponseEntity saveprogressPicture(@RequestBody ProgressPicture progressPicture){
        try{
            progressPictureService.saveprogressPicture(progressPicture);
            return new RestReturn().success("","插入成功");
        }catch (Exception e){
            return new RestReturn().error(e);
        }
    }

}
