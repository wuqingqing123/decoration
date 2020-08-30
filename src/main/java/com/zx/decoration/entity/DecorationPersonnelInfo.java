package com.zx.decoration.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 装修人员表
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-09
 */
public class DecorationPersonnelInfo extends Model<DecorationPersonnelInfo> {

    private static final long serialVersionUID = 1L;

    private String personnelId;

    private String personnelName;

    /**
     * 关联账号
     */
    private String userId;

    /**
     * 装修人员类型
     */
    private String type;

    /**
     * 装修案例数
     */
    private Integer exampleNum;

    /**
     * 从业时间
     */
    private String workTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 好评率
     */
    private Double favorableRating;

    /**
     * 个人照片路径
     */
    @TableField("PICTURE_PATH")
    private String picturePath;

    /**
     * 装修公司推送状态
     */
    private Integer state;

    /**
     * 当前页数
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private  Integer perPage;

    private Users users;

    private UserType userType;

    public String getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(String personnelId) {
        this.personnelId = personnelId;
    }
    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Integer getExampleNum() {
        return exampleNum;
    }

    public void setExampleNum(Integer exampleNum) {
        this.exampleNum = exampleNum;
    }
    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Double getFavorableRating() {
        return favorableRating;
    }

    public void setFavorableRating(Double favorableRating) {
        this.favorableRating = favorableRating;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    protected Serializable pkVal() {
        return this.personnelId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    @Override
    public String toString() {
        return "DecorationPersonnelInfo{" +
            "personnelId=" + personnelId +
            ", personnelName=" + personnelName +
            ", accountId=" + userId +
            ", personnelType=" + type +
            ", exampleNum=" + exampleNum +
            ", workTime=" + workTime +
            ", remark=" + remark +
            ", favorableRating=" + favorableRating +
            ", pictureUrl=" + picturePath +
        "}";
    }
}
