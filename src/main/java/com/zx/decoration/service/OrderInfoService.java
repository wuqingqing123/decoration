package com.zx.decoration.service;

import com.zx.decoration.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.decoration.entity.Users;

/**
 * <p>
 * 协议订单主表 服务类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-19
 */
public interface OrderInfoService extends IService<OrderInfo> {

    /**
     * 下订单
     * @param orderInfo
     * @throws Exception
     */
    public void makeOrder(OrderInfo orderInfo) throws Exception;

    /**
     * 查询为接收订单
     * @return
     * @throws Exception
     */
    public OrderInfo[] queryOrderInfo()throws Exception;

    /**
     * 接受订单
     * @param orderInfo
     * @throws Exception
     */
    public void receiverOrder(OrderInfo orderInfo)throws Exception;

    /**
     * 关闭订单
     * @param orderInfo
     * @throws Exception
     */
    public void closeOrder(OrderInfo orderInfo)throws Exception;

    /**
     * 拒绝订单
     * @param orderInfo
     * @throws Exception
     */
    public void refuseOrder(OrderInfo orderInfo)throws Exception;

    /**
     * 查看自己订单
     * @param users
     * @return
     * @throws Exception
     */
    public OrderInfo[] queryMyOrder(Users users)throws Exception;

    /**
     * 根据订单id查询订单
     * @param orderId
     * @return
     * @throws Exception
     */
    public OrderInfo queryOrderInfoById(String orderId)throws Exception;

}
