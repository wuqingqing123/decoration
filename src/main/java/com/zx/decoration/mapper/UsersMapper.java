package com.zx.decoration.mapper;

import com.zx.decoration.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * 用户档案 Mapper 接口
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-06
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {



    /**
     * 根据id查询用户
     * @param id 用户主键
     * @return
     * @throws Exception
     */
    public Users selectById(String id) throws Exception;

    /**
     * 根据账号名和密码查询用户
     * @param accountName  账号名
     * @param password 密码
     * @return
     * @throws Exception
     */
    public Users selectUserAccount(@Param("username")String accountName, @Param("password")String password) throws Exception;

    /**
     * 保存账号和用户信息
     * @param users
     * @return
     * @throws Exception
     */
    public void saveUser(Users users)throws Exception;

    /**
     * 根据用户id修改用户名
     * @param userIdString
     * @param personnelName
     * @return
     * @throws Exception
     */
    public void updateUserName(@Param("userId") String userIdString ,@Param("userName")String personnelName)throws Exception;

    /**
     * 更新邮箱
     * @param usersId
     * @param email
     * @return
     * @throws Exception
     */
    public String updateUserEmail(@Param("usersId")String usersId,@Param("email")String email)throws Exception;

    /**
     * 更新手机号
     * @param usersId
     * @param email
     * @return
     * @throws Exception
     */
    public String updateUserPhone(@Param("usersId")String usersId,@Param("phoneNum")String email)throws Exception;

    /**
     * 修改头像路径
     * @param userId
     * @param picturePath
     */
    public void updatePicturePath(@Param("userId")String userId,@Param("picturePath")String picturePath);

}
