package com.zx.decoration.service.impl;

import com.zx.decoration.entity.OrderInfo;
import com.zx.decoration.entity.ProgressDetail;
import com.zx.decoration.entity.Users;
import com.zx.decoration.mapper.OrderInfoMapper;
import com.zx.decoration.mapper.ProgressDetailMapper;
import com.zx.decoration.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.decoration.util.billcodeutil.BillCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * <p>
 * 协议订单主表 服务实现类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-19
 */
@Service("orderInfoService")
@Transactional(propagation= Propagation.REQUIRED,rollbackFor =Exception.class)
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private ProgressDetailMapper progressDetailMapper;

    @Override
    public void makeOrder(OrderInfo orderInfo) throws Exception {
        //获取订单编码
        String billcode = BillCode.getBillcode("DD");
        orderInfo.setOrderCode(billcode);
        String uuid = UUID.randomUUID().toString();
        orderInfo.setOrderId(uuid);
        //创建订单进度对象
        ProgressDetail progressDetail = new ProgressDetail();
        progressDetail.setOrderId(uuid);
        if(orderInfo.getReceiverId()!=null){
            progressDetail.setReceiverId(orderInfo.getReceiverId());
        }else{
            progressDetail.setReceiverId("");
        }

        progressDetail.setState(0);
        progressDetail.setStateName("房屋情况");
        progressDetailMapper.insertProgress(progressDetail);
        orderInfoMapper.saveOrder(orderInfo);
    }

    @Override
    public OrderInfo[] queryOrderInfo() throws Exception {
        OrderInfo[] orderInfos = orderInfoMapper.queryOrderInfo();
        return orderInfos;
    }

    @Override
    public void receiverOrder(OrderInfo orderInfo) throws Exception {
        orderInfoMapper.updateOrder(orderInfo);
        //创建进度对象
        ProgressDetail progressDetail=new ProgressDetail();
        progressDetail.setOrderId(orderInfo.getOrderId());
        progressDetail.setReceiverId(orderInfo.getReceiverId());
        progressDetail.setState(0);
        progressDetailMapper.updateProgressReceiver(progressDetail);

    }

    @Override
    public void closeOrder(OrderInfo orderInfo) throws Exception {
        //获取订单id
        String orderId = orderInfo.getOrderId();
        orderInfoMapper.updateOrderState(orderId,3);
    }

    @Override
    public void refuseOrder(OrderInfo orderInfo) throws Exception {
//获取订单id
        String orderId = orderInfo.getOrderId();
        orderInfoMapper.updateOrderState(orderId,5);
    }

    @Override
    public OrderInfo[] queryMyOrder(Users users) throws Exception {
        //获取用户名和身份
        String usersId = users.getUsersId();
        Integer type = users.getIdentityType();
        OrderInfo[] orderInfos=null;
        if(type==2){
             orderInfos = orderInfoMapper.queryUserOrder(usersId, type);
        }else{
             orderInfos = orderInfoMapper.queryDecorationOrder(usersId, type);
        }

        return orderInfos;
    }

    @Override
    public OrderInfo queryOrderInfoById(String orderId) throws Exception {
        try{
            OrderInfo orderInfo = orderInfoMapper.queryOrderInfoById(orderId);
            return orderInfo;
        }catch(Exception e){
            throw e;
        }
    }
}
