package com.zx.decoration.controller;


import com.zx.decoration.entity.CorpInfo;
import com.zx.decoration.entity.OrderInfo;
import com.zx.decoration.entity.Users;
import com.zx.decoration.service.OrderInfoService;
import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 协议订单主表 前端控制器
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-19
 */
@RestController
@RequestMapping("/api/orderInfo")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 保存订单
     * @param orderInfo
     * @return
     */
    @PostMapping("/makeOrder")
    public ResponseEntity makeOrder(@RequestBody OrderInfo orderInfo){

        try {
            orderInfoService.makeOrder(orderInfo);
            return new RestReturn().success("","下单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e,"下单失败");
        }

    }
    /**
     * 展示订单
     * @return
     */
    @PostMapping("/queryOrderInfo")
    public ResponseEntity queryOrderInfo(){

        try {
            OrderInfo[] orderInfos = orderInfoService.queryOrderInfo();
            return new RestReturn().success(orderInfos,"下单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e,"下单失败");
        }

    }

    /**
     * 根据订单id查询订单
     * @return
     */
    @GetMapping("/queryorderInfoById/{orderId}")
    public ResponseEntity queryOrderInfoById(@PathVariable("orderId")String orderId){

        try {
            OrderInfo orderInfo = orderInfoService.queryOrderInfoById(orderId);
            return new RestReturn().success(orderInfo,"查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e,"查询失败");
        }

    }



    /**
     * 查看自己的订单
     * @return
     */
    @PostMapping("/queryMyOrder")
    public ResponseEntity queryMyOrder(@RequestBody Users users){

        try {
            OrderInfo[] orderInfos = orderInfoService.queryMyOrder(users);
            return new RestReturn().success(orderInfos,"下单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e,"下单失败");
        }

    }

    /**
     * 接受订单
     * @param orderInfo
     * @return
     */
    @PostMapping("/receiverOrder")
    public ResponseEntity receiverOrder(@RequestBody OrderInfo orderInfo){
        try {
             orderInfoService.receiverOrder(orderInfo);
            return new RestReturn().success("","接单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e,"接单失败");
        }
    }

    /**
     * 关闭订单
     * @param orderInfo
     * @return
     */
    @PostMapping("/closeOrder")
    public ResponseEntity closeOrder(@RequestBody OrderInfo orderInfo){
        try {
            orderInfoService.closeOrder(orderInfo);
            return new RestReturn().success("","关闭成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e,"关闭失败");
        }
    }

    /**
     * 拒绝订单
     * @param orderInfo
     * @return
     */
    @PostMapping("/refuseOrder")
    public ResponseEntity refuseOrder(@RequestBody OrderInfo orderInfo){
        try {
            orderInfoService.refuseOrder(orderInfo);
            return new RestReturn().success("","接单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new RestReturn().error(e,"接单失败");
        }
    }



}
