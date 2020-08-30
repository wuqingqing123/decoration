package com.zx.decoration.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 进度效果表
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
public class ProgressPicture extends Model<ProgressPicture> {

    private static final long serialVersionUID = 1L;

    private String progressPictureId;

    private String picturePath;

    /**
     * 效果说明
     */
    private String remark;

    private String progressId;

    public String getProgressPictureId() {
        return progressPictureId;
    }

    public void setProgressPictureId(String progressPictureId) {
        this.progressPictureId = progressPictureId;
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
    public String getProgressId() {
        return progressId;
    }

    public void setProgressId(String progressId) {
        this.progressId = progressId;
    }

    @Override
    protected Serializable pkVal() {
        return this.progressPictureId;
    }

    @Override
    public String toString() {
        return "ProgressPicture{" +
            "progressPictureId=" + progressPictureId +
            ", picturePath=" + picturePath +
            ", remark=" + remark +
            ", progressId=" + progressId +
        "}";
    }
}
