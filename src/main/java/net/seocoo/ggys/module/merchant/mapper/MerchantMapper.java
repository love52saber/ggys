package net.seocoo.ggys.module.merchant.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.merchant.entity.MerchantDO;

import java.util.List;

public interface MerchantMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(MerchantDO record);

    int insertSelective(MerchantDO record);


    MerchantDO selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(MerchantDO record);

    int updateByPrimaryKey(MerchantDO record);

    /*自定义mapper*/
    int delete(Integer secondClassifyId);

    List<MerchantDO> list(BaseQuery query);

    Integer count(BaseQuery query);

    MerchantDO get(BaseQuery query);


    String getFunction(Integer id);
}