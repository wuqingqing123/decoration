package com.zx.decoration.service;

import com.zx.decoration.entity.UserAccount;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户账号表 服务类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-05
 */
public interface UserAccountService extends IService<UserAccount> {

    /**
     * 根据账号名和密码查询账号
     * @param userAccount
     * @return 账号
     * @throws Exception
     */
    public UserAccount login(UserAccount userAccount) throws Exception;

    /**
     * 注销
     * @param userAccount
     * @throws Exception
     */
    public void logout(UserAccount userAccount) throws Exception;

    /**
     * 保存公司账号信息
     * @param userAccount
     * @return
     * @throws Exception
     */
    public String saveUserAccount(UserAccount userAccount)throws Exception;
    /**
     * 保存业主或用户账号信息
     * @param userAccount
     * @return
     * @throws Exception
     */
    public String saveUserAccountD(UserAccount userAccount)throws Exception;

    /**
     * 更新密码
     * @param userAccount
     * @throws Exception
     */
    public void resetpassword(UserAccount userAccount)throws Exception;

}
