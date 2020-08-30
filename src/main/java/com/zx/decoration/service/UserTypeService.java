package com.zx.decoration.service;

import com.zx.decoration.entity.UserType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户类型表 服务类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-12
 */
public interface UserTypeService extends IService<UserType> {

    /**
     * 查询所有工种
     * @return
     * @throws Exception
     */
    public UserType[] queryAllType()throws Exception;

    /**
     * 查询所有个体身份
     * @return
     * @throws Exception
     */
    public UserType[] queryAllTypes()throws Exception;

    /**
     * 查询所有装修方身份
     * @return
     * @throws Exception
     */
    public UserType[] queryAllTypeD()throws Exception;

    /**
     * 查询所有身份
     * @return
     * @throws Exception
     */
    public UserType[] queryTypes()throws Exception;
}
