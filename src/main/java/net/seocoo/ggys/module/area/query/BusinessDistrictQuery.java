package net.seocoo.ggys.module.area.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.constants.YesNoEnum;

import java.util.Date;

/**
 * @author PanChengHao
 * @date 2018/6/6 8:45
 */
@ApiModel(value = "商圈查询")
public class BusinessDistrictQuery extends BaseQuery {

  @ApiModelProperty(value = "省份编码 340000")
  private String provinceCode;

  @ApiModelProperty(value = "城市编码 340100")
  private String cityCode;

  @ApiModelProperty(value = "区县编码 340103")
  private String countyCode;

  @ApiModelProperty(value = "商圈名称 步行街商圈")
  private String name;

  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  public String getCountyCode() {
    return countyCode;
  }

  public void setCountyCode(String countyCode) {
    this.countyCode = countyCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
