package net.seocoo.ggys.module.takeout.mapper;

import java.util.List;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutTypeDO;

public interface MerchantTakeOutTypeMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(MerchantTakeOutTypeDO record);

    int insertSelective(MerchantTakeOutTypeDO record);


    MerchantTakeOutTypeDO selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(MerchantTakeOutTypeDO record);

    int updateByPrimaryKey(MerchantTakeOutTypeDO record);

    /*自定义mapper*/

    /**
     * 逻辑删除
     * @param merchantTakeOutTypeId 主键
     * @return
     */
    int delete(Integer merchantTakeOutTypeId);

    List<MerchantTakeOutTypeDO> list(BaseQuery query);

    Integer count(BaseQuery query);
}