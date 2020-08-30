package com.zx.decoration.service.impl;

import com.zx.decoration.entity.ProgressDetail;
import com.zx.decoration.mapper.OrderInfoMapper;
import com.zx.decoration.mapper.ProgressDetailMapper;
import com.zx.decoration.service.ProgressDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 订单进度明细表 服务实现类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@Service("progressDetailService")
@Transactional(propagation= Propagation.REQUIRED,rollbackFor =Exception.class)
public class ProgressDetailServiceImpl extends ServiceImpl<ProgressDetailMapper, ProgressDetail> implements ProgressDetailService {

    @Autowired
    private ProgressDetailMapper progressDetailMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public ProgressDetail[] queryAllProgress(ProgressDetail progressDetail) throws Exception {
        //获取订单号和页码、数据量
        String orderId = progressDetail.getOrderId();
        Integer currentPage = progressDetail.getCurrentPage();
        Integer perPage = progressDetail.getPerPage();
        //将页码转换成当前页第一个数据序号
        progressDetail.setCurrentPage((currentPage-1)*perPage);
        try{
            ProgressDetail[] progressDetails = progressDetailMapper.queryAllProgress(progressDetail);
            return progressDetails;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Integer queryProgressCount(String orderId) throws Exception {
        try{
            Integer count = progressDetailMapper.queryProgressCount(orderId);
            return count;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void onsaveProgressDetail(ProgressDetail progressDetail) throws Exception {
        //获取新增阶段编码
        Integer state = progressDetail.getState();
        String orderId = progressDetail.getOrderId();
        try{
            //如果新增阶段为已完成，那么该订单状态为已完成
            if(state==7){
               orderInfoMapper.updateOrderState(orderId,4);
            }
            progressDetailMapper.insertProgress(progressDetail);
        }catch (Exception e){
            throw e;
        }
    }


}
