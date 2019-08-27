package net.seocoo.ggys.module.merchant.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.merchant.entity.MerchantSecondClassifyDO;

import java.util.List;

public interface MerchantSecondClassifyMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(MerchantSecondClassifyDO record);

    int insertSelective(MerchantSecondClassifyDO record);


    MerchantSecondClassifyDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantSecondClassifyDO record);

    int updateByPrimaryKey(MerchantSecondClassifyDO record);

    /*自定义mapper*/
    int delete(Integer secondClassifyId);

    int deleteByMerchantId(Integer merchantId);

    List<MerchantSecondClassifyDO> list(BaseQuery query);

    int insertBatch(List<MerchantSecondClassifyDO> list);
}