package com.zx.decoration.service.impl;

import com.zx.decoration.entity.CorpInfo;
import com.zx.decoration.entity.DecorationPersonnelInfo;
import com.zx.decoration.entity.Users;
import com.zx.decoration.mapper.DecorationPersonnelInfoMapper;
import com.zx.decoration.mapper.UsersMapper;
import com.zx.decoration.service.DecorationPersonnelInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 装修人员表 服务实现类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-09
 */
@Service("decorationPersonnelInfoService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DecorationPersonnelInfoServiceImpl extends ServiceImpl<DecorationPersonnelInfoMapper, DecorationPersonnelInfo> implements DecorationPersonnelInfoService {

    @Autowired
    private DecorationPersonnelInfoMapper decorationPersonnelInfoMapper;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public DecorationPersonnelInfo queryDecorationPersonnel(String userId) throws Exception {
        DecorationPersonnelInfo decorationPersonnelInfo = decorationPersonnelInfoMapper.queryDecorationPersonnel(userId);
        return decorationPersonnelInfo;
    }

    @Override
    public DecorationPersonnelInfo[] queryAllPersonnel() throws Exception {
        return null;
    }

    @Override
    public String updatePersonnelName(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception {

        //获取用户名和密码
        String userId = decorationPersonnelInfo.getUserId();
        String personnelName = decorationPersonnelInfo.getPersonnelName();
        //查询用户信息
        Users users = usersMapper.selectById(userId);
        if(users.getIdentityType()==1){
            //修改装修人员表名称
            decorationPersonnelInfoMapper.updatePersonnelName(userId, personnelName);
        }
        usersMapper.updateUserName(userId, personnelName);
        return "修改成功";


    }

    @Override
    public String updatePersonnelType(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception {

        //获取用户名和工种
        String userId = decorationPersonnelInfo.getUserId();
        String type = decorationPersonnelInfo.getType();
        //修改装修人员表名称
        decorationPersonnelInfoMapper.updatePersonnelType(userId, type);
        return "修改成功";


    }

    @Override
    public String updateUserWork(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception {
        //获取用户名和工作经验
        String userId = decorationPersonnelInfo.getUserId();
        String workTime = decorationPersonnelInfo.getWorkTime();
        decorationPersonnelInfoMapper.updateUserWork(userId, workTime);
        return "修改成功";
    }

    @Override
    public void updatePersonnelExample(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception {
        Integer example = decorationPersonnelInfo.getExampleNum();
        String userId = decorationPersonnelInfo.getUserId();
        decorationPersonnelInfoMapper.updatePersonnelExample(userId, example);
    }

    @Override
    public void updatePersonnelRemark(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception {
        String remark = decorationPersonnelInfo.getRemark();
        String userId = decorationPersonnelInfo.getUserId();
        decorationPersonnelInfoMapper.updatePersonnelRemark(userId, remark);
    }

    @Override
    public void updatePicturePath(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception {
        String userId = decorationPersonnelInfo.getUserId();
        String picturePath = decorationPersonnelInfo.getPicturePath();

        //查询用户信息
        Users users = usersMapper.selectById(userId);
        if(users.getIdentityType()==1){
            decorationPersonnelInfoMapper.updatePicturePath(userId, picturePath);
        }
        usersMapper.updatePicturePath(userId, picturePath);
    }

    @Override
    public void updatePersonnelState(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception {
        //获取用户id和公司状态
        String userId = decorationPersonnelInfo.getUserId();
        Integer state = decorationPersonnelInfo.getState();
        decorationPersonnelInfoMapper.updatePersonnelState(userId, state);
    }

    @Override
    public DecorationPersonnelInfo[] queryAllPersonnel(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception {
        //获取当前页数和每页条数
        Integer currentPage = decorationPersonnelInfo.getCurrentPage();
        Integer perPage = decorationPersonnelInfo.getPerPage();
        DecorationPersonnelInfo[] decorationPersonnelInfos = decorationPersonnelInfoMapper.queryAllPersonnel((currentPage - 1) * perPage, perPage,decorationPersonnelInfo);
        return decorationPersonnelInfos;
    }

    @Override
    public Integer queryPersonnelCount(DecorationPersonnelInfo decorationPersonnelInfo) throws Exception {
        Integer count = decorationPersonnelInfoMapper.queryPersonnelCount(decorationPersonnelInfo);
        return count;
    }


}
