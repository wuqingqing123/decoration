package com.zx.decoration.mapper;

import com.zx.decoration.entity.UserAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户账号表 Mapper 接口
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-05
 */
@Mapper
public interface UserAccountMapper extends BaseMapper<UserAccount> {

    /**
     * 根据账号名和密码查询账号
     * @param username 用户名
     * @param password 密码
     * @return 账号
     * @throws Exception
     */
    public UserAccount queryUserAccount(@Param("username") String username, @Param("password") String password) throws Exception;

    /**
     * 修改在线状态
     * @param accountName
     * @throws Exception
     */
    public void updateOnline(String accountName,Integer online)throws Exception;


    /**
     * 根据id查询账号
     * @param accountId 账号id
     * @return
     * @throws Exception
     */
    public UserAccount selectUserAccountById(@Param("accountId") String accountId) throws Exception;

    /**
     * 保存账号信息
     * @param userAccount
     * @return
     * @throws Exception
     */
    public void saveUserAccount(UserAccount userAccount)throws Exception;

    /**
     * 查询所有账号
     * @param  accountName
     * @return
     * @throws Exception
     */
    public UserAccount[] selectUserAccountByName(String accountName)throws Exception;

    /**
     * 更新密码
     * @param userAccount
     * @throws Exception
     */
    public void resetpassword(UserAccount userAccount)throws Exception;
}
