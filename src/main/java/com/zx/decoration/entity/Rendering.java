package com.zx.decoration.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 效果图表
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
public class Rendering extends Model<Rendering> {

    private static final long serialVersionUID = 1L;

    private String renderingId;

    /**
     * 图片名
     */
    private String renderingName;

    /**
     * 备注
     */
    private String remark;

    public String getRenderingId() {
        return renderingId;
    }

    public void setRenderingId(String renderingId) {
        this.renderingId = renderingId;
    }
    public String getRenderingName() {
        return renderingName;
    }

    public void setRenderingName(String renderingName) {
        this.renderingName = renderingName;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.renderingId;
    }

    @Override
    public String toString() {
        return "Rendering{" +
            "renderingId=" + renderingId +
            ", renderingName=" + renderingName +
            ", remark=" + remark +
        "}";
    }
}
