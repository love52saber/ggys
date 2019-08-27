package net.seocoo.ggys.module.area.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商圈表单类
 * @author PanChengHao
 * @date 2018/6/6 18:09
 */
@ApiModel(value = "商圈表单")
public class BusinessDistrictForm {

  @ApiModelProperty(value = "id")
  private Integer id;

  @ApiModelProperty(value = "省份名称 安徽")
  private String provinceName;

  @ApiModelProperty(value = "城市名称")
  private String cityName;

  @ApiModelProperty(value = "区县名称")
  private String countyName;

  @ApiModelProperty(value = "商圈名称")
  private String name;

  @ApiModelProperty(value = "省份编码 340000")
  private String provinceCode;

  @ApiModelProperty(value = "城市编码 340100")
  private String cityCode;

  @ApiModelProperty(value = "区县编码")
  private String countyCode;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getCountyName() {
    return countyName;
  }

  public void setCountyName(String countyName) {
    this.countyName = countyName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

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
}
