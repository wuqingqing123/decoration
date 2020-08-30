package com.zx.decoration.controller;


import com.zx.decoration.entity.CorpInfo;
import com.zx.decoration.entity.DecorationPersonnelInfo;
import com.zx.decoration.entity.UserAccount;
import com.zx.decoration.service.DecorationPersonnelInfoService;
import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 装修人员表 前端控制器
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-09
 */
@RestController
@RequestMapping("/api/personnelInfo")
public class DecorationPersonnelInfoController {
    @Autowired
    private DecorationPersonnelInfoService decorationPersonnelInfoService;
    /**
     * @param userId
     * @return
     */
    @GetMapping(value = "/queryPersonnelInfo/{userId}")
    public ResponseEntity saveAccount(@PathVariable("userId") String userId) {
        try {

            DecorationPersonnelInfo decorationPersonnelInfo = decorationPersonnelInfoService.queryDecorationPersonnel(userId);
            return new RestReturn().success(decorationPersonnelInfo,"查询成功");
        } catch (Exception e) {
           e.getMessage();
           return new RestReturn().error(e);
        }
    }

    @GetMapping(value = "/queryAllPersonnel")
    public ResponseEntity queryAllPersonnel() {


        try {
            DecorationPersonnelInfo[] decorationPersonnelInfos = decorationPersonnelInfoService.queryAllPersonnel();
            return new RestReturn().success(decorationPersonnelInfos,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     *保存指定装修人员的用户名
     * @param decorationPersonnelInfo
     * @return
     */
    @PostMapping(value = "/updatePersonnelName")
    public ResponseEntity savePersonnelName(@RequestBody DecorationPersonnelInfo decorationPersonnelInfo) {

        try {
            decorationPersonnelInfoService.updatePersonnelName(decorationPersonnelInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     *保存指定装修人员工种
     * @param decorationPersonnelInfo
     * @return
     */
    @PostMapping(value = "/updatePersonnelType")
    public ResponseEntity updatePersonnelType(@RequestBody DecorationPersonnelInfo decorationPersonnelInfo){

        try {
            decorationPersonnelInfoService.updatePersonnelType(decorationPersonnelInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }
    /**
     *保存指定装修人员工作经验
     * @param decorationPersonnelInfo
     * @return
     */
    @PostMapping(value = "/updateUserWork")
    public ResponseEntity updateUserWork(@RequestBody DecorationPersonnelInfo decorationPersonnelInfo){

        try {
            decorationPersonnelInfoService.updateUserWork(decorationPersonnelInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     *保存指定装修人员案例数
     * @param decorationPersonnelInfo
     * @return
     */
    @PostMapping(value = "/updatePersonnelExample")
    public ResponseEntity updatePersonnelExample(@RequestBody DecorationPersonnelInfo decorationPersonnelInfo){

        try {
            decorationPersonnelInfoService.updatePersonnelExample(decorationPersonnelInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     *保存指定装修人员备注
     * @param decorationPersonnelInfo
     * @return
     */
    @PostMapping(value = "/updatePersonnelRemark")
    public ResponseEntity updatePersonnelRemark(@RequestBody DecorationPersonnelInfo decorationPersonnelInfo){

        try {
            decorationPersonnelInfoService.updatePersonnelRemark(decorationPersonnelInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     * 保存工人图片
     *
     * @param decorationPersonnelInfo
     * @return
     */
    @PostMapping(value = "/updatePersonnelPicturePath")
    public ResponseEntity updatePicturePath(@RequestBody DecorationPersonnelInfo decorationPersonnelInfo){

        try {
            decorationPersonnelInfoService.updatePicturePath(decorationPersonnelInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     * 修改工人推送状态
     *
     * @param decorationPersonnelInfo
     * @return
     */
    @PostMapping(value = "/updatePersonnelState")
    public ResponseEntity updatePersonnelState(@RequestBody DecorationPersonnelInfo decorationPersonnelInfo){

        try {
            decorationPersonnelInfoService.updatePersonnelState(decorationPersonnelInfo);
            return new RestReturn().success("","推送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     * 分页查询所有工人
     * @param decorationPersonnelInfo
     * @return
     */
    @PostMapping("/queryAllPersonnel")
    public ResponseEntity queryAllPersonnel(@RequestBody  DecorationPersonnelInfo decorationPersonnelInfo){
        try {
            DecorationPersonnelInfo[] decorationPersonnelInfos = decorationPersonnelInfoService.queryAllPersonnel(decorationPersonnelInfo);
            return new RestReturn().success(decorationPersonnelInfos,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }
    }

    /**
     * 查询所有工人数量
     * @return
     */
    @PostMapping("/queryPersonnelCount")
    public ResponseEntity queryPersonnel(@RequestBody DecorationPersonnelInfo decorationPersonnelInfo){
        try {
            Integer count = decorationPersonnelInfoService.queryPersonnelCount(decorationPersonnelInfo);
            return new RestReturn().success(count,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }
    }



}
