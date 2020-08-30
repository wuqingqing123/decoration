package com.zx.decoration.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 协议订单主表
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-19
 */
public class OrderInfo extends Model<OrderInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 创建人
     */
    private String userId;

    /**
     * 接收人
     */
    private String receiverId;

    /**
     * 0:已提交，1:已接收，3:关闭，4完成
     */
    private Integer state;

    /**
     * 接收人类型
     */
    private String receiverType;

    /**
     * 房屋面积
     */
    private Double houseArea;

    /**
     * 预算
     */
    private Double budget;

    /**
     * 支付金额
     */
    private Double pay;

    /**
     * 备注
     */
    private String remark;

    /**
     * 附件图片
     */
    private String picturePath;

    /**
     * 下单时间
     */
    private String createTime;

    private String userName;

    private String receiverName;

    private Users user;

    private Users receiver;

    private UserType userType;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }
    public Double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Double houseArea) {
        this.houseArea = houseArea;
    }
    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getReceiver() {
        return receiver;
    }

    public void setReceiver(Users receiver) {
        this.receiver = receiver;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
            "orderId=" + orderId +
            ", orderCode=" + orderCode +
            ", userId=" + userId +
            ", receiverId=" + receiverId +
            ", state=" + state +
            ", receiverType=" + receiverType +
            ", houseArea=" + houseArea +
            ", budget=" + budget +
            ", pay=" + pay +
            ", remark=" + remark +
            ", picturePath=" + picturePath +
        "}";
    }
}
