package net.seocoo.ggys.module.emchant.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.emchant.entity.EmchantRegisterDO;
import net.seocoo.ggys.module.emchant.query.EmchantRegisterQuery;
import net.seocoo.ggys.module.user.entity.UserInfoDO;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/14 0014 17:21
 * @Email xieheng91@163.com
 * @Desc TODO
 */
public interface EmchantRegisterService {


    EmchantRegisterDO get(Integer id);

    /**
     * 新增
     *
     * @param emchantExceptionRegisterDO 实体类
     * @return dao操作结果
     */
    Boolean save(EmchantRegisterDO emchantExceptionRegisterDO);

    /**
     * 删除
     *
     * @param id 主键
     * @return dao操作结果
     */
    Boolean delete(Integer id);

    /**
     * 更新
     *
     * @param emchantExceptionRegisterDO 实体类
     * @return doa操作结果
     */
    Boolean update(EmchantRegisterDO emchantExceptionRegisterDO);

    /**
     * 按条件查询返回list结果
     *
     * @param query
     * @return 查询结果list
     */
    List<EmchantRegisterDO> listQuery(EmchantRegisterQuery query);

    /**
     * 按条件分页查询
     *
     * @param query
     * @return
     */
    PageBean<EmchantRegisterDO> pageQuery(EmchantRegisterQuery query);

    /**
     * 注册账户
     */
    Boolean registerForSingle(UserInfoDO userInfoDO);


    /**
     * 重新注册该账户
     *
     * @param id
     * @return
     */
    Boolean againRegister(Integer id);

    /**
     * 判断该用户是否存在
     *
     * @param userName
     * @return
     */
    Boolean existByUserName(String userName);


}
