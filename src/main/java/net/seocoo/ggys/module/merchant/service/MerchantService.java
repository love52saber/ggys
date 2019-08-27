package net.seocoo.ggys.module.merchant.service;

import com.github.pagehelper.PageInfo;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.merchant.constans.MerchantFunctionEnum;
import net.seocoo.ggys.module.merchant.dto.H5CMerchantBaseDTO;
import net.seocoo.ggys.module.merchant.entity.MerchantDO;
import net.seocoo.ggys.module.merchant.entity.MerchantDTO;
import net.seocoo.ggys.module.merchant.form.MerchantForm;
import net.seocoo.ggys.module.merchant.query.MerchantQuery;
import net.seocoo.ggys.module.user.entity.UserInfoDO;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/29 0029 17:52
 * @Email xieheng91@163.com
 * @Desc 商户service接口
 */
public interface MerchantService {
    /**
     * 新增
     * @param merchantForm 表单提交对象
     * @return dao操作结果
     */
    Boolean save(MerchantForm merchantForm);

    /**
     * 删除
     * @param merchantId 主键
     * @return dao操作结果
     */

    Boolean delete(Integer merchantId);

    /**
     * 更新
     * @param merchantForm 实体类
     * @return doa操作结果
     */
    Boolean update(MerchantForm merchantForm);

    /**
     * 按条件查询返回list结果
     * @param baseQuery
     * @return 查询结果list
     */
    List<MerchantDO> list(MerchantQuery baseQuery);

    /**
     * 按条件进行分页查询
     * @param baseQuery
     * @return
     */
    PageBean<MerchantDTO> page(MerchantQuery baseQuery);

    /**
     * 获取单条记录
     * @param baseQuery
     * @return
     */
    MerchantDO get(MerchantQuery baseQuery);

    /**
     * 通过商户主键获取商户信息
     * @param merchantId 商户主键
     * @return
     */
    MerchantDTO get(Integer merchantId,UserInfoDO currUser);

    MerchantDTO get(Integer merchantId);

    /**
     * 通过商户userId,获取商户主键
     * @param merchantUserId
     * @return
     */
    Integer getMerchantIdByMerchantUserId(Integer merchantUserId);

    /**
     * 通过商户userId获得商户信息
     * @param merchantUserId userId
     * @return 商户信息
     */
    MerchantDO getMerchantByMerchantUserId(Integer merchantUserId);



    /**
     * 通过商户id,获取商户的功能
     * @param merchantId
     * @return
     */
    List<MerchantFunctionEnum> getFunction(Integer merchantId);

    /**
     * 根据二级分类和城市查询
     */
    List<MerchantDO> listBySecondClassifyAndCityId(MerchantQuery query);
    /**
     * 根据一级分类和城市查询
     */
    List<MerchantDO> listByFirstClassifyAndCityId(MerchantQuery query);

    /**
     * C端H5商家首页
     * @param query
     */
    H5CMerchantBaseDTO listClientH5Index(MerchantQuery query, UserInfoDO userInfo);


    /**
     * 通过商户主键获取商户信息
     * @param userId 商户主键
     * @return
     */
    MerchantDTO getMerchantByUserId(Integer userId);
}
