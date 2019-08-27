package net.seocoo.ggys.module.area.mapper;

import net.seocoo.ggys.module.area.entity.AreaDO;

import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AreaDO record);

    int insertSelective(AreaDO record);

    AreaDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AreaDO record);

    int updateByPrimaryKey(AreaDO record);

    /**
     * 查询省市列表
     * @param areaDO
     * @return 地区对象
     */
    List<AreaDO> queryAreaCodeList(AreaDO areaDO);

    /**
     * 查询区县列表
     * @param areaDO
     * @return 地区对象
     */
    List<AreaDO> queryCountyList(AreaDO areaDO);

    /**
     * 查询地区列表
     * @param areaDO
     * @return list
     */
    List<AreaDO> queryAreaList(AreaDO areaDO);
}