package com.zx.decoration.mapper;

import com.zx.decoration.entity.Rendering;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 效果图表 Mapper 接口
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@Mapper
public interface RenderingMapper extends BaseMapper<Rendering> {

    /**
     * 查询所有效果图
     * @throws Exception
     */
    public Rendering[] selectAllRendering()throws Exception;

}
