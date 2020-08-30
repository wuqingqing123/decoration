package com.zx.decoration.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 公司信息表
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-08
 */
public class CorpInfo extends Model<CorpInfo>  {

    private static final long serialVersionUID = 1L;

    private String corpId;

    /**
     * 公司名称
     */
    private String corpName;

    /**
     * 关联账号
     */
    private String userId;

    private String remark;

    /**
     * 员工数
     */
    private Integer empNum;

    /**
     * 0：有效，1:无效
     */
    private Integer state;

    /**
     * 设计案例
     */
    private Integer example;

    /**
     * 装修工地
     */
    private Integer decorationNum;

    /**
     * 好评率
     */
    private String favorableRating;

    private String picturePath;

    private String type;

    /**
     * 当前页数
     */
    private Integer currentPage;

    /**
     * 每页数据条数
     */
    private Integer perPage;

    /**
     * 创建时间
     */
    private String establish_time;

    private Users users;

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }
    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getEmpNum() {
        return empNum;
    }

    public void setEmpNum(Integer empNum) {
        this.empNum = empNum;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public Integer getExample() {
        return example;
    }

    public void setExample(Integer example) {
        this.example = example;
    }
    public Integer getDecorationNum() {
        return decorationNum;
    }

    public void setDecorationNum(Integer decorationNum) {
        this.decorationNum = decorationNum;
    }
    public String getFavorableRating() {
        return favorableRating;
    }

    public void setFavorableRating(String favorableRating) {
        this.favorableRating = favorableRating;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getEstablish_time() {
        return establish_time;
    }

    public void setEstablish_time(String establish_time) {
        this.establish_time = establish_time;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    protected Serializable pkVal() {
        return this.corpId;
    }

    @Override
    public String toString() {
        return "CorpInfo{" +
                "corpId='" + corpId + '\'' +
                ", corpName='" + corpName + '\'' +
                ", userId='" + userId + '\'' +
                ", remark='" + remark + '\'' +
                ", empNum=" + empNum +
                ", state=" + state +
                ", example=" + example +
                ", decorationNum=" + decorationNum +
                ", favorableRating='" + favorableRating + '\'' +
                ", establish_time='" + establish_time + '\'' +
                '}';
    }
}
