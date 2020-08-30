package com.zx.decoration.mapper;

import com.zx.decoration.entity.ProgressDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单进度明细表 Mapper 接口
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@Mapper
public interface ProgressDetailMapper extends BaseMapper<ProgressDetail> {

    /**
     * 分页查询当前订单所有进度
     * @return
     * @throws Exception
     */
    public ProgressDetail[] queryAllProgress(ProgressDetail progressDetail)throws Exception;

    /**
     * 查询当前订单下所有进度数
     * @param orderId 订单id
     * @return
     * @throws Exception
     */
    public Integer queryProgressCount(String orderId)throws Exception;

    /**
     * 插入一条进度记录
     * @param progressDetail
     * @throws Exception
     */
    public void insertProgress(ProgressDetail progressDetail)throws Exception;

    /**
     * 更新进度的接收者
     * @param progressDetail
     * @throws Exception
     */
    public void updateProgressReceiver(ProgressDetail progressDetail)throws Exception;

}
