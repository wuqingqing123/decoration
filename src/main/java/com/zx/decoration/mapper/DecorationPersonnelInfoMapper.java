package com.zx.decoration.mapper;

import com.zx.decoration.entity.CorpInfo;
import com.zx.decoration.entity.DecorationPersonnelInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 装修人员表 Mapper 接口
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-09
 */
@Mapper
public interface DecorationPersonnelInfoMapper extends BaseMapper<DecorationPersonnelInfo> {

    /**
     * 查询装修人员信息
     * @param userId
     * @return
     * @throws Exception
     */
    public DecorationPersonnelInfo queryDecorationPersonnel(@Param("userId") String userId) throws Exception;

    /**
     * 根据用户id修改装修人员名
     * @param userIdString
     * @param personnelName
     * @return
     * @throws Exception
     */
    public void updatePersonnelName(@Param("userId") String userIdString ,@Param("personnelName")String personnelName)throws Exception;


    /**
     * 修改工种
     * @param userId
     * @param type
     * @return
     * @throws Exception
     */
    public void updatePersonnelType(@Param("userId")String userId,@Param("type")String type) throws Exception;

    /**
     * 修改工作经验
     * @param userId
     * @param personnelType
     * @return
     * @throws Exception
     */
    public void updateUserWork(@Param("userId")String userId,@Param("workTime")String personnelType) throws Exception;
    /**
     * 修改案例数
     * @param userId
     * @param exampleNum
     * @return
     * @throws Exception
     */
    public void updatePersonnelExample(@Param("userId")String userId,@Param("example")Integer exampleNum) throws Exception;

    /**
     * 修改备注
     * @param userId
     * @param remark
     * @return
     * @throws Exception
     */
    public void updatePersonnelRemark(@Param("userId")String userId,@Param("remark")String remark) throws Exception;

    /**
     * 保存装修人员信息
     * @param decorationPersonnelInfo
     * @throws Exception
     */
    public void savePersonnel(DecorationPersonnelInfo decorationPersonnelInfo)throws Exception;

    /**
     * 修改头像路径
     * @param userId
     * @param picturePath
     */
    public void updatePicturePath(@Param("userId")String userId,@Param("picturePath")String picturePath);

    /**
     * 修改公司状态
     * @param userId
     * @param state
     */
    public void updatePersonnelState(@Param("userId")String userId,@Param("state")Integer state);

    /**
     * 分页查询所有工人
     * @param currentPage
     * @param perPage
     * @return
     * @throws Exception
     */
    public DecorationPersonnelInfo[] queryAllPersonnel(Integer currentPage, Integer perPage,@Param("personnelInfo")DecorationPersonnelInfo decorationPersonnelInfo)throws Exception;

    /**
     * 查询所有工人数
     * @return
     * @throws Exception
     */
    public Integer queryPersonnelCount(DecorationPersonnelInfo decorationPersonnelInfo)throws Exception;
}
