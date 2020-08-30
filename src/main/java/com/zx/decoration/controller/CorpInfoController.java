package com.zx.decoration.controller;


import com.zx.decoration.entity.CorpInfo;
import com.zx.decoration.entity.DecorationPersonnelInfo;
import com.zx.decoration.service.CorpInfoService;
import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 公司信息表 前端控制器
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/api/corpInfo")
public class CorpInfoController {
    @Autowired
    private CorpInfoService corpInfoService;

    /**
     * 查询公司基本信息
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/queryCorpInfo/{userId}")
    public ResponseEntity queryCorpInfo(@PathVariable("userId") String userId)  {
        CorpInfo corpInfo = null;
        try {
            corpInfo = corpInfoService.queryCorpInfo(userId);
            return new RestReturn().success(corpInfo,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     * 分页查询所有公司
     * @param corpInfo
     * @return
     */
    @PostMapping("/queryAllCorp")
    public ResponseEntity queryAllCorp(@RequestBody CorpInfo corpInfo){
        try {
            CorpInfo[] corpInfos = corpInfoService.queryAllCorp(corpInfo);
            return new RestReturn().success(corpInfos,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }
    }

    /**
     * 查询所有公司数量
     * @return
     */
    @PostMapping("/queryCorpCount")
    public ResponseEntity queryCorp( CorpInfo corpInfo){
        try {
            Integer count = corpInfoService.queryCorpCount(corpInfo);
            return new RestReturn().success(count,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }
    }

    /**
     * 保存指定装修公司名
     *
     * @param corpInfo
     * @return
     */
    @PostMapping(value = "/updateCorpName")
    public ResponseEntity savePersonnelName(@RequestBody CorpInfo corpInfo) {

        try {
            corpInfoService.updateCorpName(corpInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }


    /**
     * 保存公司案例数
     *
     * @param corpInfo
     * @return
     */
    @PostMapping(value = "/updateCorpExample")
    public ResponseEntity updateCorpExample(@RequestBody CorpInfo corpInfo) {

        try {
            corpInfoService.updateCorpExample(corpInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     * 保存公司备注
     *
     * @param corpInfo
     * @return
     */
    @PostMapping(value = "/updateCorpRemark")
    public ResponseEntity updateCorpremark(@RequestBody CorpInfo corpInfo) {

        try {
            corpInfoService.updateCorpRemark(corpInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     * 保存公司创建时间
     *
     * @param corpInfo
     * @return
     */
    @PostMapping(value = "/updateCorpEstablish")
    public ResponseEntity updateCorpEstablish(@RequestBody CorpInfo corpInfo) {

        try {
            corpInfoService.updateCorpEstablish(corpInfo);
            return new RestReturn().success("","保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     * 保存公司图片
     *
     * @param corpInfo
     * @return
     */
    @PostMapping(value = "/updateCorpPicturePath")
    public ResponseEntity updatePicturePath(@RequestBody CorpInfo corpInfo){

        try {
            corpInfoService.updatePicturePath(corpInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e,"修改失败");
        }

    }

    /**
     * 修改公司推送状态
     *
     * @param corpInfo
     * @return
     */
    @PostMapping(value = "/updateCorpState")
    public ResponseEntity updateCorpState(@RequestBody CorpInfo corpInfo){

        try {
            corpInfoService.updateCorpState(corpInfo);
            return new RestReturn().success("","推送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e,"推送失败");
        }

    }

    /**
     * 修改公司员工数
     *
     * @param corpInfo
     * @return
     */
    @PostMapping(value = "/updateEmpNum")
    public ResponseEntity updateEmpNum(@RequestBody CorpInfo corpInfo){

        try {
            corpInfoService.updateCorpEmpNum(corpInfo);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e,"修改失败");
        }

    }

}
