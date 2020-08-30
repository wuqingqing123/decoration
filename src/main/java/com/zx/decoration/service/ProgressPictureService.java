package com.zx.decoration.service;

import com.zx.decoration.entity.ProgressPicture;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 进度效果表 服务类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
public interface ProgressPictureService extends IService<ProgressPicture> {
    /**
     * 根据进度id查询所有照片
     * @param progressId
     * @return
     * @throws Exception
     */
    public ProgressPicture[] queryAllPicture(String progressId)throws Exception;

    /**
     * 插入进度照片
     * @throws Exception
     */
    public void saveprogressPicture(ProgressPicture progressPicture)throws Exception;

}
