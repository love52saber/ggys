package net.seocoo.ggys.module.merchant.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.merchant.entity.MerchantLabelDO;

import java.util.List;

public interface MerchantLabelMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MerchantLabelDO record);

    int insertSelective(MerchantLabelDO record);


    MerchantLabelDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantLabelDO record);

    int updateByPrimaryKey(MerchantLabelDO record);

    /*自定义mapper*/

    /**
     * 逻辑删除
     * @param merchantLabelId 主键
     * @return
     */
    int delete(Integer merchantLabelId);

    List<MerchantLabelDO> list(BaseQuery query);

    Integer countByMerchantId(Integer merchantId);
}