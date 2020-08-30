package com.zx.decoration.service.impl;

import com.zx.decoration.entity.CorpInfo;
import com.zx.decoration.entity.DecorationPersonnelInfo;
import com.zx.decoration.entity.UserAccount;
import com.zx.decoration.entity.Users;
import com.zx.decoration.mapper.CorpInfoMapper;
import com.zx.decoration.mapper.DecorationPersonnelInfoMapper;
import com.zx.decoration.mapper.UserAccountMapper;
import com.zx.decoration.mapper.UsersMapper;
import com.zx.decoration.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-05
 */
@Service("userAccountService")
@Transactional(propagation= Propagation.REQUIRED,rollbackFor =Exception.class)
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CorpInfoMapper corpInfoMapper;
    @Autowired
    private DecorationPersonnelInfoMapper decorationPersonnelInfoMapper;

    @Override
    public UserAccount login(UserAccount user) throws Exception {
        //获取用户名和密码
        String username = user.getAccountName();
        String password = user.getAccountPassword();
        try{
            //查询是否存在该用户
            UserAccount userAccount = userAccountMapper.queryUserAccount(username, password);
            if(userAccount==null){
                throw new Exception("账号或密码错误");
            }
            //判断该用户是否在线
            Integer online = userAccount.getOnline();
            if(online==1){
                throw new Exception("该用户已上线");
            }
            //修改在线状态,从不在线改为在线
//            userAccountMapper.updateOnline(username,1);
            return userAccount;
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public void logout(UserAccount user) throws Exception {
        //获取用户名和密码
        String username = user.getAccountName();
        String password = user.getAccountPassword();
        try{
            //查询是否存在该用户
            UserAccount userAccount = userAccountMapper.queryUserAccount(username, password);
            Integer online = userAccount.getOnline();
            //修改在线状态,从不在线改为在线
            userAccountMapper.updateOnline(username,0);
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public String saveUserAccount(UserAccount userAccount) throws Exception {
        try{
            //获取用户信息
            Users users = userAccount.getUsers();
            //获取公司信息
            CorpInfo corpInfo = userAccount.getCorpInfo();
            //获取用户id
            String userId= UUID.randomUUID().toString();
            users.setUsersId(userId);
            users.setIdentityType(0);
            users.setSecondIdentityType("01");
            corpInfo.setUserId(userId);
            corpInfo.setType("01");
            userAccount.setUserId(userId);
            //判断注册账号是否已经注册过
            UserAccount[] userAccounts = userAccountMapper.selectUserAccountByName(userAccount.getAccountName());
            if(userAccounts.length>0){
                throw new Exception("该账号注册");
            }
            usersMapper.saveUser(users);
            corpInfoMapper.saveCorpInfo(corpInfo);
            userAccountMapper.saveUserAccount(userAccount);
            return "保存成功";
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public String saveUserAccountD(UserAccount userAccount) throws Exception {
        try{
            //取出用户信息
            Users users = userAccount.getUsers();
            //取装修人员信息
            DecorationPersonnelInfo decorationPersonnelInfo = new DecorationPersonnelInfo();
            //生成用户id
            String uuid = UUID.randomUUID().toString();
            //将用户id存进用户和账号中
            users.setUsersId(uuid);
            userAccount.setUserId(uuid);
            //判断注册账号是否已经注册过
            UserAccount[] userAccounts = userAccountMapper.selectUserAccountByName(userAccount.getAccountName());
            if(userAccounts.length>0){
                throw new Exception("该账号注册");
            }
            //判断该用户是否装修人员
            if(!"02".equals(users.getSecondIdentityType())){
                decorationPersonnelInfo.setUserId(uuid);
                decorationPersonnelInfo.setType(users.getSecondIdentityType());
                decorationPersonnelInfo.setPersonnelName(users.getUserName());
                users.setIdentityType(1);
                decorationPersonnelInfoMapper.savePersonnel(decorationPersonnelInfo);
                usersMapper.saveUser(users);
                userAccountMapper.saveUserAccount(userAccount);

            }else{
                users.setIdentityType(2);
                usersMapper.saveUser(users);
                userAccountMapper.saveUserAccount(userAccount);
            }

            return "保存成功";
        }catch(Exception e){
            throw e;
        }

    }

    @Override
    public void resetpassword(UserAccount userAccount) throws Exception {
        userAccountMapper.resetpassword(userAccount);
    }


}
