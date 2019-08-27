package net.seocoo.ggys.module.advertisement.constans;

import com.alibaba.fastjson.annotation.JSONType;
import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 投放分类枚举
 *
 * @author xieheng
 **/
@JSONType(serializeEnumAsJavaBean = true)
public enum PutInZoneEnum {

  ;

  private int code;
  private String desc;
  private String name;

  private PutInZoneEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, PutInZoneEnum> BY_VALUE_MAP = new LinkedHashMap<>();

  static {
    for (PutInZoneEnum putInTypeEnum : PutInZoneEnum.values()) {
      BY_VALUE_MAP.put(putInTypeEnum.getCode(), putInTypeEnum);
    }
  }

  /**
   * 根据code查询对应的外卖类型枚举
   *
   * @param code dode
   * @return PutInTypeEnum
   * @throws EnumNotFoundException
   */
  public static PutInZoneEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的外卖类型枚举
   *
   * @param str 枚举的name
   * @return PutInTypeEnum
   * @throws EnumNotFoundException
   */
  public static PutInZoneEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return PutInZoneEnum.valueOf(str);
    } catch (Exception e) {
      throw new EnumNotFoundException("枚举对应常量" + str + "不存在");
    }
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

  public String getName() {
    return this.name();
  }
}
