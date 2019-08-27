package net.seocoo.ggys.module.advertisement.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.advertisement.entity.AdvertisementDO;

import java.util.List;

public interface AdvertisementDOMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(AdvertisementDO record);

    int insertSelective(AdvertisementDO record);

    AdvertisementDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdvertisementDO record);

    int updateByPrimaryKey(AdvertisementDO record);


    /*自定义mapper*/

    /**
     * 逻辑删除
     *
     * @param id 主键
     * @return
     */
    int delete(Integer id);

    List<AdvertisementDO> list();

    List<AdvertisementDO> listQuery(BaseQuery query);

    Integer countQuery(BaseQuery query);
}