package net.seocoo.ggys.module.goods.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.goods.entity.MerchantBaseGoodsDO;

import java.math.BigDecimal;
import java.util.List;

public interface MerchantBaseGoodsMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(MerchantBaseGoodsDO record);

    int insertSelective(MerchantBaseGoodsDO record);


    MerchantBaseGoodsDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantBaseGoodsDO record);

    int updateByPrimaryKey(MerchantBaseGoodsDO record);

    /*自定义mapper*/

    /**
     * 逻辑删除
     * @param merchantBaseGoodsId 主键
     * @return
     */
    int delete(Integer merchantBaseGoodsId);

    List<MerchantBaseGoodsDO> list(BaseQuery query);

    Integer count(BaseQuery query);

    BigDecimal selectMinPrice(Integer merchantId);

}