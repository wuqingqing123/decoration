package com.zx.decoration.service;

import com.zx.decoration.entity.CorpInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.decoration.entity.DecorationPersonnelInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 公司信息表 服务类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-08
 */
public interface CorpInfoService extends IService<CorpInfo> {

    /**
     * 查询装修公司信息
     * @param userId
     * @return
     * @throws Exception
     */
    public CorpInfo queryCorpInfo(String userId) throws Exception;

    /**
     * 更新公司名
     * @param corpInfo
     * @return
     * @throws Exception
     */
    public String updateCorpName(CorpInfo corpInfo)throws Exception;

    /**
     * 修改案例数
     * @param corpInfo
     * @return
     * @throws Exception
     */
    public void updateCorpExample(CorpInfo corpInfo) throws Exception;

    /**
     * 修改备注
     * @param corpInfo
     * @return
     * @throws Exception
     */
    public void updateCorpRemark(CorpInfo corpInfo) throws Exception;

    /**
     * 修改创建时间
     * @param corpInfo
     * @return
     * @throws Exception
     */
    public void updateCorpEstablish(CorpInfo corpInfo) throws Exception;

    /**
     * 修改图片路径
     * @param corpInfo
     * @throws Exception
     */
    public void updatePicturePath(CorpInfo corpInfo)throws Exception;

    /**
     * 分页查询所有公司
     * @param corpInfo
     * @return
     * @throws Exception
     */
    public CorpInfo[] queryAllCorp(CorpInfo corpInfo)throws Exception;

    /**
     * 查询所有公司数
     * @return
     * @throws Exception
     */
    public Integer queryCorpCount(CorpInfo corpInfo)throws Exception;

    /**
     * 修改公司推送状态
     * @param corpInfo
     * @throws Exception
     */
    public void updateCorpState(CorpInfo corpInfo)throws Exception;

    /**
     * 修改公司员工数
     * @param corpInfo
     * @throws Exception
     */
    public void updateCorpEmpNum(CorpInfo corpInfo)throws Exception;

}
