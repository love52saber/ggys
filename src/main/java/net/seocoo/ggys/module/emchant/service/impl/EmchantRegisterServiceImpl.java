package net.seocoo.ggys.module.emchant.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.emchat.EmchantApi;
import net.seocoo.ggys.core.emchat.constans.EmchantConstans;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.emchant.constans.RegisterStateEnum;
import net.seocoo.ggys.module.emchant.entity.EmchantRegisterDO;
import net.seocoo.ggys.module.emchant.mapper.EmchantRegisterMapper;
import net.seocoo.ggys.module.emchant.query.EmchantRegisterQuery;
import net.seocoo.ggys.module.emchant.service.EmchantRegisterService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/14 0014 17:21
 * @Email xieheng91@163.com
 * @Desc 环信注册失败账号
 */
@Service
public class EmchantRegisterServiceImpl extends BaseService implements EmchantRegisterService {
    @Autowired
    private EmchantRegisterMapper emchantRegisterMapper;

    @Autowired
    private EmchantApi emchantApi;

    @Override
    public EmchantRegisterDO get(Integer id) {
        return emchantRegisterMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean save(EmchantRegisterDO emchantRegisterDO) {
        insertSetDefaultValue(emchantRegisterDO);
        return emchantRegisterMapper.insertSelective(emchantRegisterDO) < 1 ? false : true;
    }

    @Override
    public Boolean delete(Integer id) {
        return emchantRegisterMapper.delete(id) < 1 ? false : true;
    }

    @Override
    public Boolean update(EmchantRegisterDO emchantRegisterDO) {
        updateSetDefaultValue(emchantRegisterDO);
        return emchantRegisterMapper.updateByPrimaryKeySelective(emchantRegisterDO) < 1 ? false : true;
    }

    @Override
    public List<EmchantRegisterDO> listQuery(EmchantRegisterQuery query) {
        return emchantRegisterMapper.listQuery(query);
    }

    @Override
    public PageBean<EmchantRegisterDO> pageQuery(EmchantRegisterQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<EmchantRegisterDO> list = emchantRegisterMapper.listQuery(query);
        Integer count = emchantRegisterMapper.countQuery(query);
        return new PageBean<EmchantRegisterDO>(list, query.getPageNum(), query.getPageSize(), count);
    }

    @Override
    public Boolean registerForSingle(UserInfoDO userInfoDO) {

        EmchantRegisterQuery query = new EmchantRegisterQuery();
        query.setUserName(userInfoDO.getUuid());
        Integer exist = emchantRegisterMapper.countQuery(query);
        if(exist>0){
            logger.error("此注册用户已经注册存在{}",userInfoDO.toString());
            return false;
        }

        EmchantRegisterDO emchantRegisterDO = null;
        //注册环信通讯用户
        Boolean register = emchantApi.registerUserIMForSingle(userInfoDO.getUuid(), EmchantConstans.DEFAULT_PASSWORD);
        //本平台成功注册的用户的环信账户注册记录
        emchantRegisterDO = new EmchantRegisterDO();
        insertSetDefaultValue(emchantRegisterDO);
        emchantRegisterDO.setUserId(userInfoDO.getId());
        emchantRegisterDO.setUserName(userInfoDO.getUuid());
        emchantRegisterDO.setPassword(EmchantConstans.DEFAULT_PASSWORD);
        emchantRegisterDO.setUuid(StringEx.newUUID());
        //根据注册的结果,记录此账号注册状态,若失败,通过后台管理将此数据进行环信注册激活
        emchantRegisterDO.setRegisterState(register ? RegisterStateEnum.SUCCESS : RegisterStateEnum.FAIL);
        this.save(emchantRegisterDO);

        return register;

    }


    @Override
    public Boolean againRegister(Integer id) {
        EmchantRegisterDO registerDO = get(id);
        return emchantApi.registerUserIMForSingle(registerDO.getUserName(), registerDO.getPassword());
    }

    @Override
    public Boolean existByUserName(String userName) {
        EmchantRegisterQuery query = new EmchantRegisterQuery();
        query.setUserName(userName);
        return emchantRegisterMapper.countQuery(query) < 1 ? false : true;
    }
}
