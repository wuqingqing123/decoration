package com.zx.decoration.service;

import com.zx.decoration.entity.ProgressType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单阶段类型表 服务类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
public interface ProgressTypeService extends IService<ProgressType> {

    /**
     * 查询所有可能的施工阶段
     * @return
     * @throws Exception
     */
    public ProgressType[] queryAllProgress()throws Exception;

}
