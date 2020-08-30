package com.zx.decoration.service.impl;

import com.zx.decoration.entity.Users;
import com.zx.decoration.mapper.UsersMapper;
import com.zx.decoration.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户档案 服务实现类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-06
 */
@Service("usersService")
@Transactional(propagation= Propagation.REQUIRED,rollbackFor =Exception.class)
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users selectUserAccount(String accountName, String password) throws Exception {
        return usersMapper.selectUserAccount(accountName,password);
    }

    @Override
    public Users queryUserInfo(String userId) throws Exception {
        Users users = usersMapper.selectById(userId);
        return users;
    }

    @Override
    public String updateUserEmail(Users users) throws Exception {

        try{
            //获取用户名和邮箱
            String usersId = users.getUsersId();
            String email = users.getEmail();
            usersMapper.updateUserEmail(usersId,email);
            return "修改成功";
        }catch (Exception e){
            return "修改失败";
        }
    }

    @Override
    public String updateUserPhone(Users users) throws Exception {
        try{
            //获取用户名和手机号
            String usersId = users.getUsersId();
            String phoneNum = users.getPhoneNum();
            usersMapper.updateUserPhone(usersId,phoneNum);
            return "修改成功";
        }catch (Exception e){
            return "修改失败";
        }
    }
}
