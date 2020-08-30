package com.zx.decoration.mapper;

import com.zx.decoration.entity.CorpInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zx.decoration.entity.DecorationPersonnelInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 公司信息表 Mapper 接口
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-08
 */
@Mapper
public interface CorpInfoMapper extends BaseMapper<CorpInfo> {

    /**
     * 查询装修公司信息
     * @param userId
     * @return
     * @throws Exception
     */
    public CorpInfo queryCorpInfo(@Param("userId") String userId) throws Exception;

    /**
     * 保存公司信息
     * @param corpInfo
     * @return
     * @throws Exception
     */
    public void saveCorpInfo(CorpInfo corpInfo)throws Exception;

    /**
     * 根据用户id修改装修公司名
     * @param userIdString
     * @param corpName
     * @return
     * @throws Exception
     */
    public void updateCorpName(@Param("userId") String userIdString , @Param("corpName")String corpName)throws Exception;

    /**
     * 修改案例数
     * @param userId
     * @param example
     * @return
     * @throws Exception
     */
    public void updateCorpExample(@Param("userId")String userId,@Param("example")Integer example) throws Exception;

    /**
     * 修改备注
     * @param userId
     * @param remark
     * @return
     * @throws Exception
     */
    public void updateCorpRemark(@Param("userId")String userId,@Param("remark")String remark) throws Exception;

    /**
     * 修改创建时间
     * @param userId
     * @param establish
     * @return
     * @throws Exception
     */
    public void updateCorpEstablish(@Param("userId")String userId,@Param("establishTime")String establish) throws Exception;

    /**
     * 修改头像路径
     * @param userId
     * @param picturePath
     */
    public void updatePicturePath(@Param("userId")String userId,@Param("picturePath")String picturePath);

    /**
     * 分页查询所有公司
     * @param currentPage
     * @param perPage
     * @return
     * @throws Exception
     */
    public CorpInfo[] queryAllCorp(Integer currentPage,Integer perPage,CorpInfo corpInfo)throws Exception;

    /**
     * 查询所有公司数
     * @return
     * @throws Exception
     */
    public Integer queryCorpCount(CorpInfo corpInfo)throws Exception;

    /**
     * 修改公司状态
     * @param userId
     * @param state
     */
    public void updateCorpState(@Param("userId")String userId,@Param("state")Integer state);

    /**
     * 修改公司员工数
     * @param userId
     * @param empNum
     */
    public void updateCorpEmpNum(@Param("userId")String userId,@Param("empNum")Integer empNum);
}
