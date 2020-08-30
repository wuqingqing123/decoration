package com.zx.decoration.service.impl;

import com.zx.decoration.entity.ProgressType;
import com.zx.decoration.mapper.ProgressTypeMapper;
import com.zx.decoration.service.ProgressTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 订单阶段类型表 服务实现类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@Service("progressTypeService")
@Transactional(propagation= Propagation.REQUIRED,rollbackFor =Exception.class)
public class ProgressTypeServiceImpl extends ServiceImpl<ProgressTypeMapper, ProgressType> implements ProgressTypeService {

    @Autowired
    private ProgressTypeMapper progressTypeMapper;

    @Override
    public ProgressType[] queryAllProgress() throws Exception {
        ProgressType[] progressTypes = progressTypeMapper.queryAllProgress();
        return progressTypes;
    }
}
