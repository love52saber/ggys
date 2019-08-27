package net.seocoo.ggys.module.area.mapper;

import net.seocoo.ggys.module.area.entity.BusinessDistrictDO;
import net.seocoo.ggys.module.area.query.BusinessDistrictQuery;

import java.util.List;

public interface BusinessDistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusinessDistrictDO record);

    int insertSelective(BusinessDistrictDO record);

    BusinessDistrictDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessDistrictDO record);

    int updateByPrimaryKey(BusinessDistrictDO record);

    /**
     * 分页查询商圈列表
     * @param query
     * @return 商圈列表
     */
    List<BusinessDistrictDO> listByPageQuery(BusinessDistrictQuery query);

    /**
     * 查询总数
     * @param query
     * @return
     */
    Integer countByQuery(BusinessDistrictQuery query);
}