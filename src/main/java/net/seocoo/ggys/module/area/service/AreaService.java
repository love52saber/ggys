package net.seocoo.ggys.module.area.service;

import net.seocoo.ggys.module.area.entity.AreaDO;

import java.util.List;

/**
 * @author PanChengHao
 * @date 2018/6/5 12:47
 */
public interface AreaService {
  /**
   * 查询地区
   * @param areaDO
   * @return 地区对象
   */
  List<AreaDO> queryAreaCodeList(AreaDO areaDO);

  /**
   * 查询区县列表
   * @param areaDO
   * @return 区县list
   */
  List<AreaDO> queryCountyList(AreaDO areaDO);

  /**
   * 查询地区列表
   * @param areaDO
   * @return list
   */
  List<AreaDO> queryAreaList(AreaDO areaDO);
}
