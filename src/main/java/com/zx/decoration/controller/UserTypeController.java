package com.zx.decoration.controller;


import com.zx.decoration.entity.UserType;
import com.zx.decoration.service.UserTypeService;
import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户类型表 前端控制器
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-12
 */
@RestController
@RequestMapping("/api/userType")
public class UserTypeController {
    @Autowired
    private UserTypeService userTypeService;

    /**
     * 查询所有工种
     * @return
     * @throws Exception
     */
    @GetMapping("/queryAllType")
    public ResponseEntity queryAllType(){
        try {
            UserType[] userTypes = userTypeService.queryAllType();
            return new RestReturn().success(userTypes,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }
    }

    /**
     * 查询所有个体身份
     * @return
     * @throws Exception
     */
    @GetMapping("/queryAllTypes")
    public ResponseEntity queryAllTypes(){
        try {
            UserType[] userTypes = userTypeService.queryAllTypes();
            return new RestReturn().success(userTypes,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }
    }

    /**
     * 查询所有装修方身份
     * @return
     * @throws Exception
     */
    @GetMapping("/queryAllTypeD")
    public ResponseEntity queryAllTypeD(){
        try {
            UserType[] userTypes = userTypeService.queryAllTypeD();
            return new RestReturn().success(userTypes,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }
    }

    /**
     * 查询所有身份
     * @return
     * @throws Exception
     */
    @GetMapping("/queryTypes")
    public ResponseEntity queryTypes(){
        try {
            UserType[] userTypes = userTypeService.queryTypes();
            return new RestReturn().success(userTypes,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }
    }

}
