package com.zx.decoration.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户档案
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-06
 */
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户信息主键ID
     */
    @TableId("users_ID")
    private String usersId;

    /**
     * 用户编码
     */
    @TableField("user_CODE")
    private String userCode;

    /**
     * 用户姓名
     */
    @TableField("user_NAME")
    private String userName;

    /**
     * 0:公司代理，1：装修工人,2:业主
     */
    @TableField("IDENTITY_TYPE")
    private Integer identityType;

    /**
     * 第二身份
     */
    @TableField("SECOND_IDENTITY_TYPE")
    private String secondIdentityType;

    /**
     * 0：正常，1：封存
     */
    @TableField("IDENTITY_STATE")
    private Integer identityState;

    /**
     * 用户联系方式
     */
    @TableField("PHONE_NUM")
    private String phoneNum;

    /**
     * 邮箱地址
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 性别   0：男，1：女
     */
    @TableField("SEX")
    private Integer sex;

    /**
     * 身份证号
     */
    @TableField("ID_NUMBER")
    private String idNumber;

    /**
     * 用户头像URL
     */
    @TableField("PICTURE_URL")
    private String pictureUrl;

    /**
     * 用户创建日期
     */
    @TableField("CREATE_DATE")
    private String createDate;

    @TableField("TS")
    private String ts;


    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }
    public String getSecondIdentityType() {
        return secondIdentityType;
    }

    public void setSecondIdentityType(String secondIdentityType) {
        this.secondIdentityType = secondIdentityType;
    }
    public Integer getIdentityState() {
        return identityState;
    }

    public void setIdentityState(Integer identityState) {
        this.identityState = identityState;
    }
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    @Override
    protected Serializable pkVal() {
        return this.usersId;
    }

    @Override
    public String toString() {
        return "Users{" +
            "usersId=" + usersId +
            ", userCode=" + userCode +
            ", userName=" + userName +
            ", identityType=" + identityType +
            ", secondIdentityType=" + secondIdentityType +
            ", identityState=" + identityState +
            ", phoneNum=" + phoneNum +
            ", email=" + email +
            ", sex=" + sex +
            ", idNumber=" + idNumber +
            ", pictureUrl=" + pictureUrl +
            ", createDate=" + createDate +
            ", ts=" + ts +
        "}";
    }
}
