package net.seocoo.ggys.module.takeout.mapper;

import java.util.List;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutRuleDO;

public interface MerchantTakeOutRuleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MerchantTakeOutRuleDO record);

    int insertSelective(MerchantTakeOutRuleDO record);


    MerchantTakeOutRuleDO selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(MerchantTakeOutRuleDO record);

    int updateByPrimaryKey(MerchantTakeOutRuleDO record);

    /*自定义mapper*/

    /**
     * 逻辑删除
     * @param merchantTakeOutRuleId 主键
     * @return
     */
    int delete(Integer merchantTakeOutRuleId);

    List<MerchantTakeOutRuleDO> list(BaseQuery query);

    Integer count(BaseQuery query);

}