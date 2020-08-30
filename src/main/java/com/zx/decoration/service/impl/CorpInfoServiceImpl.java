package com.zx.decoration.service.impl;

import com.zx.decoration.entity.CorpInfo;
import com.zx.decoration.mapper.CorpInfoMapper;
import com.zx.decoration.mapper.UsersMapper;
import com.zx.decoration.service.CorpInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 公司信息表 服务实现类
 * </p>
 *
 * @author wuqingqing
 * @since 2020-04-08
 */
@Service("corpInfoService")
@Transactional(propagation= Propagation.REQUIRED,rollbackFor =Exception.class)
public class CorpInfoServiceImpl extends ServiceImpl<CorpInfoMapper, CorpInfo> implements CorpInfoService {
    @Autowired
    private CorpInfoMapper corpInfoMapper;
    @Autowired
    private UsersMapper usersMapper;


    @Override
    public CorpInfo queryCorpInfo(String userId) throws Exception {
        CorpInfo corpInfo = corpInfoMapper.queryCorpInfo(userId);
        return corpInfo;
    }

    @Override
    public String updateCorpName(CorpInfo corpInfo) throws Exception {
        try{
            //获取公司名和用户id
            String corpName = corpInfo.getCorpName();
            String userId = corpInfo.getUserId();
             corpInfoMapper.updateCorpName(userId, corpName);
            return "保存成功";
        }catch (Exception e){
            return "保存失败";
        }

    }

    @Override
    public void updateCorpExample(CorpInfo corpInfo) throws Exception {
        //获取用户名和案例数
        Integer example = corpInfo.getExample();
        String userId = corpInfo.getUserId();
        corpInfoMapper.updateCorpExample(userId,example);
    }

    @Override
    public void updateCorpRemark(CorpInfo corpInfo) throws Exception {
        String remark = corpInfo.getRemark();
        String userId = corpInfo.getUserId();
        corpInfoMapper.updateCorpRemark(userId,remark);
    }

    @Override
    public void updateCorpEstablish(CorpInfo corpInfo) throws Exception {
        String establish_time = corpInfo.getEstablish_time();
        String userId = corpInfo.getUserId();
        corpInfoMapper.updateCorpEstablish(userId,establish_time);
    }

    @Override
    public void updatePicturePath(CorpInfo corpInfo) throws Exception {
        String userId = corpInfo.getUserId();
        String picturePath = corpInfo.getPicturePath();
        usersMapper.updatePicturePath(userId,picturePath);
        corpInfoMapper.updatePicturePath(userId,picturePath);

    }

    @Override
    public CorpInfo[] queryAllCorp(CorpInfo corpInfo) throws Exception {
        //获取实体类分页的页数和每页条数
        Integer currentPage = corpInfo.getCurrentPage();
        Integer perPage = corpInfo.getPerPage();
        CorpInfo[] corpInfos = corpInfoMapper.queryAllCorp((currentPage-1)*perPage, perPage,corpInfo);
        return corpInfos;
    }

    @Override
    public Integer queryCorpCount(CorpInfo corpInfo) throws Exception {
        Integer count = corpInfoMapper.queryCorpCount(corpInfo);
        return count;
    }

    @Override
    public void updateCorpState(CorpInfo corpInfo) throws Exception {
        //获取用户id和公司状态
        String userId = corpInfo.getUserId();
        Integer state = corpInfo.getState();
        corpInfoMapper.updateCorpState(userId,state);
    }

    @Override
    public void updateCorpEmpNum(CorpInfo corpInfo) throws Exception {
        //获取用户id和公司员工数
        String userId = corpInfo.getUserId();
        Integer empNum = corpInfo.getEmpNum();
        corpInfoMapper.updateCorpEmpNum(userId,empNum);
    }
}
