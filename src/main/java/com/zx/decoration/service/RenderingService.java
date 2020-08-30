package com.zx.decoration.service;

import com.zx.decoration.entity.Rendering;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 效果图表 服务类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
public interface RenderingService extends IService<Rendering> {

    /**
     * 查询所有效果图
     * @throws Exception
     */
    public Rendering[] selectAllRendering()throws Exception;

}
