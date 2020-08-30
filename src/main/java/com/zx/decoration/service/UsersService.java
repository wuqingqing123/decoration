package com.zx.decoration.service;

import com.zx.decoration.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户档案 服务类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-06
 */
public interface UsersService extends IService<Users> {

    /**
     * 根据账号名和密码查询用户
     * @param accountName  账号名
     * @param password 密码
     * @return
     * @throws Exception
     */
    public Users selectUserAccount(String accountName,String password) throws Exception;

    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     * @throws Exception
     */
    public Users queryUserInfo(String userId)throws Exception;

    /**
     * 更新邮箱
     * @param users
     * @return
     * @throws Exception
     */
    public String updateUserEmail(Users users)throws Exception;

    /**
     * 更新手机号
     * @param users
     * @return
     * @throws Exception
     */
    public String updateUserPhone(Users users)throws Exception;

}
