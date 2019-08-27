package net.seocoo.ggys.module.area.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.area.constants.LevelEnum;
import net.seocoo.ggys.module.area.entity.AreaDO;
import net.seocoo.ggys.module.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地区码控制层
 * @author PanChengHao
 * @date 2018/6/5 12:44
 */
@Api(value="地区码接口",description = "地区码接口")
@RestController
@RequestMapping(value="/pc/area")
//@CrossOrigin
public class AreaController extends BaseController {

  @Autowired
  private AreaService areaService;

  @GetMapping("/provinces")
  @ApiOperation(value = "查询所有省列表")
  public ApiResult listProvinces(){
    AreaDO record = new AreaDO();
    record.setLevel(LevelEnum.province);
    List<AreaDO> areaDOList=areaService.queryAreaCodeList(record);
    return success(areaDOList);
  }

  @GetMapping("/{provinceCode}/cities")
  @ApiOperation(value = "根据省code码查询省下面的所有市级列表")
  public ApiResult listCities(@PathVariable("provinceCode") @ApiParam(value = "省级地区码", defaultValue = "340000",required = true) String provinceCode){
    AreaDO record = new AreaDO();
    record.setLevel(LevelEnum.city);
    record.setAreaDistrictCode(provinceCode);
    List<AreaDO> areaDOList=areaService.queryAreaCodeList(record);
    return success(areaDOList);
  }

  @GetMapping("/{cityCode}/districts")
  @ApiOperation(value = "根据市code码查询市下面的所有区县列表")
  public ApiResult listDistricts(@PathVariable("cityCode") @ApiParam(value = "市级地区码", defaultValue = "340100",required = true) String cityCode){
    AreaDO record = new AreaDO();
    record.setLevel(LevelEnum.district);
    record.setAreaDistrictCode(cityCode);
    List<AreaDO> areaDOList=areaService.queryCountyList(record);
    return success(areaDOList);
  }
}
