package com.zx.decoration.mapper;

import com.zx.decoration.entity.UserType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户类型表 Mapper 接口
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-12
 */
@Mapper
public interface UserTypeMapper extends BaseMapper<UserType> {

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
