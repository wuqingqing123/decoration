package com.zx.decoration.service.impl;

import com.zx.decoration.entity.Rendering;
import com.zx.decoration.mapper.RenderingMapper;
import com.zx.decoration.service.RenderingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 效果图表 服务实现类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@Service("renderingService")
public class RenderingServiceImpl extends ServiceImpl<RenderingMapper, Rendering> implements RenderingService {

    @Autowired
    private RenderingMapper renderingMapper;

    @Override
    public Rendering[] selectAllRendering() throws Exception {
        Rendering[] renderings = renderingMapper.selectAllRendering();
        return renderings;
    }
}
