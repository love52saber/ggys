package net.seocoo.ggys.module.area.service.impl;

import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.module.area.constants.LevelEnum;
import net.seocoo.ggys.module.area.entity.AreaDO;
import net.seocoo.ggys.module.area.mapper.AreaMapper;
import net.seocoo.ggys.module.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地区service层实现类
 *
 * @author PanChengHao
 * @date 2018/6/5 14:52
 */
@Service
public class AreaServiceImpl extends BaseService implements AreaService {
  @Autowired
  private AreaMapper areaMapper;

  @Override
  public List<AreaDO> queryAreaCodeList(AreaDO areaDO) {
    String areaDistrictCode = areaDO.getAreaDistrictCode();
    String areaDistrictCodeLike = "";
    if (areaDistrictCode != null && areaDistrictCode != "") {
      areaDistrictCodeLike = areaDistrictCode.substring(0, 2);
    }
    areaDO.setAreaDistrictCode(areaDistrictCodeLike);
    return this.areaMapper.queryAreaCodeList(areaDO);
  }

  @Override
  public List<AreaDO> queryCountyList(AreaDO areaDO) {
    String areaDistrictCode=areaDO.getAreaDistrictCode();
    String areaDistrictCodeLike = "";
    if(areaDistrictCode != null && areaDistrictCode != ""){
      areaDistrictCodeLike = areaDistrictCode.substring(0, 4);
    }
    areaDO.setAreaDistrictCode(areaDistrictCodeLike);
    return this.areaMapper.queryCountyList(areaDO);
  }

  /**
   * 查询地区列表
   *
   * @param areaDO
   * @return list
   */
  @Override
  public List<AreaDO> queryAreaList(AreaDO areaDO) {
    return this.areaMapper.queryAreaList(areaDO);
  }
}
