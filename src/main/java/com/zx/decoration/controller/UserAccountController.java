package com.zx.decoration.controller;


import com.zx.decoration.entity.UserAccount;
import com.zx.decoration.service.UserAccountService;
import com.zx.decoration.service.UsersService;
import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 用户账号表 前端控制器
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/api/userAccount")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private UsersService usersService;

    /**
     * 登录
     *
     * @param user
     * @return
     */

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserAccount user) {
        UserAccount userAccount = null;
        try {
            userAccount = userAccountService.login(user);
            return new RestReturn().success(userAccount, "登录成功");
        } catch (Exception e) {
            return new RestReturn().error(e);
        }
    }

    /**
     * 注销
     *
     * @param user
     * @return
     */

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody UserAccount user) {
        UserAccount userAccount = null;
        try {
            userAccountService.logout(user);
            return new RestReturn().success("", "注销成功");
        } catch (Exception e) {
            return new RestReturn().error(e);
        }


    }


    /**
     * @param userAccount
     * @return
     */
    @PostMapping("/saveAccount")
    public ResponseEntity saveAccount(@RequestBody UserAccount userAccount) {
        try {
            String s = userAccountService.saveUserAccount(userAccount);
            return new RestReturn().success("","保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }
    }

    /**
     * 装修人员或业主注册
     *
     * @param userAccount
     * @return
     */
    @PostMapping("/saveAccountD")
    public ResponseEntity saveAccountD(@RequestBody UserAccount userAccount)  {


        try {
            String s = userAccountService.saveUserAccountD(userAccount);
            return new RestReturn().success("","注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }

    /**
     * 账号密码修改
     *
     * @param userAccount
     * @return
     */
    @PostMapping("/resetpassword")
    public ResponseEntity resetpassword(@RequestBody UserAccount userAccount)  {


        try {
            userAccountService.resetpassword(userAccount);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }




}
