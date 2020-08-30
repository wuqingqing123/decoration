package com.zx.decoration.mapper;

import com.zx.decoration.entity.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 协议订单主表 Mapper 接口
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-19
 */
@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    /**
     * 保存订单
     * @param orderInfo
     * @throws Exception
     */
    public void saveOrder(OrderInfo orderInfo) throws Exception;

    /**
     * 查询为接收订单
     * @return
     * @throws Exception
     */
    public OrderInfo[] queryOrderInfo()throws Exception;

    /**
     * 修改订单信息
     * @param orderInfo
     * @throws Exception
     */
    public void updateOrder(OrderInfo orderInfo)throws Exception;

    /**
     * 修改订单状态
     * @param orderId
     * @param state
     * @throws Exception
     */
    public  void updateOrderState(String orderId,Integer state)throws Exception;

    /**
     * 查看装修方订单
     * @param usersId
     * @param type
     * @return
     * @throws Exception
     */
    public OrderInfo[] queryDecorationOrder(String usersId,Integer type)throws Exception;

    /**
     * 查看业主订单
     * @param usersId
     * @param type
     * @return
     * @throws Exception
     */
    public OrderInfo[] queryUserOrder(String usersId,Integer type)throws Exception;

    /**
     * 根据订单id查询订单
     * @param orderId
     * @return
     * @throws Exception
     */
    public OrderInfo queryOrderInfoById(String orderId)throws Exception;

}
