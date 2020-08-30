package com.zx.decoration.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户类型表
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-19
 */
public class UserType extends Model<UserType> {

    private static final long serialVersionUID = 1L;

    private String userTypeId;

    /**
     * 0:公司代理，1：装修师傅，2：业主
     */
    private Integer fcode;

    /**
     * 01:公司代理，02：业主，03:设计师，04打墙师傅，05：水电师傅，06泥工师傅，07木工师傅，08：粉刷师傅
     */
    private String ccode;

    /**
     * 用户类型名
     */
    private String cname;

    /**
     * 0：有效，1:无效
     */
    private Integer state;

    private String createTime;

    private String ts;

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }
    public Integer getFcode() {
        return fcode;
    }

    public void setFcode(Integer fcode) {
        this.fcode = fcode;
    }
    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    @Override
    protected Serializable pkVal() {
        return this.userTypeId;
    }

    @Override
    public String toString() {
        return "UserType{" +
            "userTypeId=" + userTypeId +
            ", fcode=" + fcode +
            ", ccode=" + ccode +
            ", cname=" + cname +
            ", state=" + state +
            ", createTime=" + createTime +
            ", ts=" + ts +
        "}";
    }
}
