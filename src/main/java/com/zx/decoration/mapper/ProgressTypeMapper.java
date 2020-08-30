package com.zx.decoration.mapper;

import com.zx.decoration.entity.ProgressType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单阶段类型表 Mapper 接口
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@Mapper
public interface ProgressTypeMapper extends BaseMapper<ProgressType> {

    /**
     * 查询所有可能的施工阶段
     * @return
     * @throws Exception
     */
    public ProgressType[] queryAllProgress()throws Exception;
}
