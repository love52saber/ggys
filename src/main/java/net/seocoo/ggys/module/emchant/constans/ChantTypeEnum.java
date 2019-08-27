package net.seocoo.ggys.module.emchant.constans;

import com.alibaba.fastjson.annotation.JSONType;
import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xieheng
 * @date 2018/6/14
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum ChantTypeEnum {
  /**
   * 是
   */
  USER_LINK_MERCHANT(0, "用户联系商户"),
  /**
   * 否
   */
  MERCHANT_LINK_USER(1, "商户联系用户");

  private int code;
  private String desc;
  private String name;

  private ChantTypeEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, ChantTypeEnum> BY_VALUE_MAP = new LinkedHashMap<>();

  static {
    for (ChantTypeEnum chantTypeEnum : ChantTypeEnum.values()) {
      BY_VALUE_MAP.put(chantTypeEnum.getCode(), chantTypeEnum);
    }
  }

  /**
   * 根据code查询对应的外卖类型枚举
   *
   * @param code dode
   * @return chantTypeEnum
   * @throws EnumNotFoundException
   */
  public static ChantTypeEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的外卖类型枚举
   *
   * @param str 枚举的name
   * @return chantTypeEnum
   * @throws EnumNotFoundException
   */
  public static ChantTypeEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return ChantTypeEnum.valueOf(str);
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
