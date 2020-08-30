package com.zx.decoration.mapper;

import com.zx.decoration.entity.ProgressPicture;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 进度效果表 Mapper 接口
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-24
 */
@Mapper
public interface ProgressPictureMapper extends BaseMapper<ProgressPicture> {

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
