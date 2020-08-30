package com.zx.decoration.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 订单进度明细表
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
public class ProgressDetail extends Model<ProgressDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 进度ID
     */
    private String progressId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 接收人
     */
    private String receiverId;

    /**
     * 0:房屋情况，1：设计阶段，2：拆改阶段，3：水电阶段，4：泥工阶段，5：木工阶段，6：油漆阶段，7：竣工阶段
     */
    private Integer state;

    /**
     * 阶段名
     */
    private String stateName;

    /**
     * 操作时间
     */
    private String operateTime;

    /**
     * 附件图片
     */
    private String picturePath;

    /**
     * 备注
     */
    private String remark;

    private List<ProgressPicture> progressPictures;

    /**
     * 当前页数
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private Integer perPage;

    public String getProgressId() {
        return progressId;
    }

    public void setProgressId(String progressId) {
        this.progressId = progressId;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPerPage() {
        return perPage;
    }


    public List<ProgressPicture> getProgressPictures() {
        return progressPictures;
    }

    public void setProgressPictures(List<ProgressPicture> progressPictures) {
        this.progressPictures = progressPictures;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    @Override
    protected Serializable pkVal() {
        return this.progressId;
    }

    @Override
    public String toString() {
        return "ProgressDetail{" +
            "progressId=" + progressId +
            ", orderId=" + orderId +
            ", receiverId=" + receiverId +
            ", state=" + state +
            ", stateName=" + stateName +
            ", operateTime=" + operateTime +
            ", picturePath=" + picturePath +
            ", remark=" + remark +
        "}";
    }
}
