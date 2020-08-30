package com.zx.decoration.service;

import com.zx.decoration.entity.ProgressDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单进度明细表 服务类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
public interface ProgressDetailService extends IService<ProgressDetail> {

    /**
     * 查询当前订单下所有进度
     * @param progressDetail
     * @return
     * @throws Exception
     */
    public ProgressDetail[] queryAllProgress(ProgressDetail progressDetail)throws Exception;

    /**
     * 查询当前订单下所有进度数
     * @param orderId
     * @return
     * @throws Exception
     */
    public Integer queryProgressCount(String orderId)throws Exception;

    /**
     * 保存进度
     * @param progressDetail
     * @throws Exception
     */
    public void onsaveProgressDetail(ProgressDetail progressDetail)throws Exception;

}
