package com.zx.decoration.service;

import com.zx.decoration.entity.CorpInfo;
import com.zx.decoration.entity.DecorationPersonnelInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 装修人员表 服务类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-09
 */
public interface DecorationPersonnelInfoService extends IService<DecorationPersonnelInfo> {
    /**
     * 查询装修人员信息
     * @param userId
     * @return
     * @throws Exception
     */
    public DecorationPersonnelInfo queryDecorationPersonnel( String userId) throws Exception;

    public DecorationPersonnelInfo[] queryAllPersonnel()throws Exception;

    public String updatePersonnelName(DecorationPersonnelInfo decorationPersonnelInfo)throws Exception;

    public String updatePersonnelType(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception;

    public String updateUserWork(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception;

    /**
     * 修改案例数
     * @param decorationPersonnelInfo
     * @return
     * @throws Exception
     */
    public void updatePersonnelExample(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception;

    /**
     * 修改备注
     * @param decorationPersonnelInfo
     * @return
     * @throws Exception
     */
    public void updatePersonnelRemark(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception;

    /**
     * 修改图片路径
     * @param decorationPersonnelInfo
     * @throws Exception
     */
    public void updatePicturePath(DecorationPersonnelInfo decorationPersonnelInfo)throws Exception;

    /**
     * 修改工人推送状态
     * @param decorationPersonnelInfo
     * @throws Exception
     */
    public void updatePersonnelState(DecorationPersonnelInfo decorationPersonnelInfo)throws Exception;

    /**
     * 分页查询所有工人
     * @param decorationPersonnelInfo
     * @return
     * @throws Exception
     */
    public DecorationPersonnelInfo[] queryAllPersonnel(DecorationPersonnelInfo decorationPersonnelInfo)throws Exception;

    /**
     * 查询所有工人数
     * @return
     * @throws Exception
     */
    public Integer queryPersonnelCount(DecorationPersonnelInfo decorationPersonnelInfo)throws Exception;
}
