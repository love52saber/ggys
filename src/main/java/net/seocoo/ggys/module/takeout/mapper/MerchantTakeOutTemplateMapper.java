package net.seocoo.ggys.module.takeout.mapper;

import java.util.List;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutTemplateDO;


public interface MerchantTakeOutTemplateMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(MerchantTakeOutTemplateDO record);

    int insertSelective(MerchantTakeOutTemplateDO record);


    MerchantTakeOutTemplateDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantTakeOutTemplateDO record);

    int updateByPrimaryKey(MerchantTakeOutTemplateDO record);


    /*自定义mapper*/

    /**
     * 逻辑删除
     * @param merchantTakeOutTemplateId 主键
     * @return
     */
    int delete(Integer merchantTakeOutTemplateId);

    List<MerchantTakeOutTemplateDO> list(BaseQuery query);

    Integer count(BaseQuery query);
}