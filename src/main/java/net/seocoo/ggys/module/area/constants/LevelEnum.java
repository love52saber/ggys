package net.seocoo.ggys.module.area.constants;

/**
 * 省市区枚举
 * @author PanChengHao
 * @date 2018/6/6 10:31
 */
public enum LevelEnum {
  province(0,"省"),
  city(1,"市"),
  district(2,"区县"),
  street(3,"街道"),
  country(4,"国家");
  private int code;
  private String desc;
  private String name;

  LevelEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
  public String getName() {
    return this.name();
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
