package net.seocoo.ggys.module.groupon.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.groupon.entity.MerchantGrouponTemplatePictureDO;

import java.util.List;

public interface MerchantGrouponTemplatePictureMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(MerchantGrouponTemplatePictureDO record);

    int insertSelective(MerchantGrouponTemplatePictureDO record);


    MerchantGrouponTemplatePictureDO selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(MerchantGrouponTemplatePictureDO record);

    int updateByPrimaryKey(MerchantGrouponTemplatePictureDO record);


    /*自定义mapper*/

    /**
     * 逻辑删除
     * @param merchantGrouponId 主键
     * @return
     */
    int delete(Integer merchantGrouponId);

    List<MerchantGrouponTemplatePictureDO> list(BaseQuery query);

    Integer count(BaseQuery query);
}