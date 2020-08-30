package com.zx.decoration.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户账号表
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-05
 */
public class UserAccount extends Model<UserAccount> {

    private static final long serialVersionUID = 1L;

    private String accountId;

    private String accountName;

    private  Users users;

    private CorpInfo corpInfo;

    private  DecorationPersonnelInfo decorationPersonnelInfo;

    /**
     * 来源用户
     */
    private String userId;

    private String accountPassword;

    /**
     * 0：有效，1:无效
     */
    private Integer state;

    private String ts;

    /**
     * 在线状态0：不在线，1:在线
     */
    private Integer online;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public CorpInfo getCorpInfo() {
        return corpInfo;
    }

    public void setCorpInfo(CorpInfo corpInfo) {
        this.corpInfo = corpInfo;
    }

    public DecorationPersonnelInfo getDecorationPersonnelInfo() {
        return decorationPersonnelInfo;
    }

    public void setDecorationPersonnelInfo(DecorationPersonnelInfo decorationPersonnelInfo) {
        this.decorationPersonnelInfo = decorationPersonnelInfo;
    }

    @Override
    protected Serializable pkVal() {
        return this.accountId;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
            "accountId=" + accountId +
            ", accountName=" + accountName +
            ", userId=" + userId +
            ", accountPassword=" + accountPassword +
            ", state=" + state +
            ", ts=" + ts +
            ", online=" + online +
        "}";
    }
}
