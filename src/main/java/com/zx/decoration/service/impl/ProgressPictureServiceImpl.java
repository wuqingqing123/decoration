package com.zx.decoration.service.impl;

import com.zx.decoration.entity.ProgressPicture;
import com.zx.decoration.mapper.ProgressPictureMapper;
import com.zx.decoration.service.ProgressPictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 进度效果表 服务实现类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@Service("progressPictureService")
@Transactional(propagation= Propagation.REQUIRED,rollbackFor =Exception.class)
public class ProgressPictureServiceImpl extends ServiceImpl<ProgressPictureMapper, ProgressPicture> implements ProgressPictureService {

    @Autowired
    private ProgressPictureMapper progressPictureMapper;

    @Override
    public ProgressPicture[] queryAllPicture(String progressId) throws Exception {
        ProgressPicture[] progressPictures = progressPictureMapper.queryAllPicture(progressId);
        return progressPictures;
    }

    @Override
    public void saveprogressPicture(ProgressPicture progressPicture) throws Exception {
        progressPictureMapper.saveprogressPicture(progressPicture);
    }
}
