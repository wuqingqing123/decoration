package com.zx.decoration.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 订单阶段类型表
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
public class ProgressType extends Model<ProgressType> {

    private static final long serialVersionUID = 1L;

    private String progressTypeId;

    /**
     * 1:房屋情况，2改装阶段，3：设计阶段，4改造阶段，5水电阶段，6：泥工阶段，7：木工阶段，8：油漆阶段，9：竣工阶段
     */
    private String progressCode;

    /**
     * 阶段类型名
     */
    private String progressName;

    /**
     * 0：有效，1:无效
     */
    private Integer state;

    public String getProgressTypeId() {
        return progressTypeId;
    }

    public void setProgressTypeId(String progressTypeId) {
        this.progressTypeId = progressTypeId;
    }
    public String getProgressCode() {
        return progressCode;
    }

    public void setProgressCode(String progressCode) {
        this.progressCode = progressCode;
    }
    public String getProgressName() {
        return progressName;
    }

    public void setProgressName(String progressName) {
        this.progressName = progressName;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.progressTypeId;
    }

    @Override
    public String toString() {
        return "ProgressType{" +
            "progressTypeId=" + progressTypeId +
            ", progressCode=" + progressCode +
            ", progressName=" + progressName +
            ", state=" + state +
        "}";
    }
}
