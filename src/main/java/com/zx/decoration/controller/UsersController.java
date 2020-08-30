package com.zx.decoration.controller;


import com.zx.decoration.entity.DecorationPersonnelInfo;
import com.zx.decoration.entity.Users;
import com.zx.decoration.service.UsersService;
import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 用户档案 前端控制器
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-06
 */
@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/queryUserInfo/{userId}")
    public ResponseEntity queryUserInfo(@PathVariable("userId")String userId){
        try {
            Users users = usersService.queryUserInfo(userId);
            return new RestReturn().success(users,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }
    }

    /**
     *修改用户邮箱
     * @param users
     * @return
     */
    @PostMapping("/updateUserEmail")
    public ResponseEntity saveUserName(@RequestBody Users users){

        try {
            usersService.updateUserEmail(users);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }
    /**
     *修改用户手机号
     * @param users
     * @return
     */
    @PostMapping("/updateUserPhone")
    public ResponseEntity saveUserPhone(@RequestBody Users users){

        try {
            usersService.updateUserPhone(users);
            return new RestReturn().success("","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e);
        }

    }


}
