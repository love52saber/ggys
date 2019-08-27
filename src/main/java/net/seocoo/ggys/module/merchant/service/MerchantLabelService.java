package net.seocoo.ggys.module.merchant.service;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.merchant.entity.MerchantLabelDO;
import net.seocoo.ggys.module.merchant.form.LabelForm;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/4 0031 10:10
 * @Email xieheng91@163.com
 * @Desc 商户标签service接口
 */
public interface MerchantLabelService {
    /**
     * 新增
     * @param merchantLabelDO 实体类
     * @return dao操作结果
     */
    public Boolean save(MerchantLabelDO merchantLabelDO);

    /**
     * 新增时检查标签
     * @param labelForm
     * @return dao操作结果
     */
    public Boolean saveLimitCheck(LabelForm labelForm);

    /**
     * 新增
     * @param labelForm
     * @return dao操作结果
     */
    public Boolean save(LabelForm labelForm);

    /**
     * 删除
     * @param id 主键
     * @param merchantId 商户主键
     * @return dao操作结果
     */
    public Boolean delete(Integer merchantId ,Integer id);

    /**
     * 更新
     * @param merchantLabelDO 实体类
     * @return doa操作结果
     */
    public Boolean update(MerchantLabelDO merchantLabelDO);

    /**
     * 按条件查询返回list结果
     * @param baseQuery
     * @return 查询结果list
     */
    public List<MerchantLabelDO> list(BaseQuery baseQuery);

    /**
     * 查询商家的所有标签
     * @param merchantId 商家Id
     * @return 标签集合
     */
    List<MerchantLabelDO> listByMerchantId(Integer merchantId);

    /**
     * 获取商家标签的名字集合
     * @param merchantId
     * @return
     */
    List<String> listNameByMerchantId(Integer merchantId);
}
