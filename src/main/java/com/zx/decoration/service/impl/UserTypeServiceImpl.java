package com.zx.decoration.service.impl;

import com.zx.decoration.entity.UserType;
import com.zx.decoration.mapper.UserTypeMapper;
import com.zx.decoration.service.UserTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户类型表 服务实现类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-12
 */
@Service("userTypeService")
public class UserTypeServiceImpl extends ServiceImpl<UserTypeMapper, UserType> implements UserTypeService {

    @Autowired
    private UserTypeMapper userTypeMapper;

    @Override
    public UserType[] queryAllType() throws Exception {
        UserType[] userTypes = userTypeMapper.queryAllType();
        return userTypes;
    }

    @Override
    public UserType[] queryAllTypes() throws Exception {
        UserType[] userTypes = userTypeMapper.queryAllTypes();
        return userTypes;
    }

    @Override
    public UserType[] queryAllTypeD() throws Exception {
        UserType[] userTypes = userTypeMapper.queryAllTypeD();
        return userTypes;
    }

    @Override
    public UserType[] queryTypes() throws Exception {
        UserType[] userTypes = userTypeMapper.queryTypes();
        return userTypes;
    }
}
