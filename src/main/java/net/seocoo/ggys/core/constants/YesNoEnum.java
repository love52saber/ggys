package net.seocoo.ggys.core.constants;

import com.alibaba.fastjson.annotation.JSONType;
import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Yes No枚举
 *
 * @author ZengXiaoLiang
 * @date 2018/5/28 20:50
 **/
@JSONType(serializeEnumAsJavaBean = true)
public enum YesNoEnum {
  /**
   * 是
   */
  Y(1, "是"),
  /**
   * 否
   */
  N(0, "否");

  private int code;
  private String desc;
  private String name;

  private YesNoEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, YesNoEnum> BY_VALUE_MAP = new LinkedHashMap<>();

  static {
    for (YesNoEnum yesNoEnum : YesNoEnum.values()) {
      BY_VALUE_MAP.put(yesNoEnum.getCode(), yesNoEnum);
    }
  }

  /**
   * 根据code查询对应的外卖类型枚举
   *
   * @param code dode
   * @return YesNoEnum
   * @throws EnumNotFoundException
   */
  public static YesNoEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的外卖类型枚举
   *
   * @param str 枚举的name
   * @return YesNoEnum
   * @throws EnumNotFoundException
   */
  public static YesNoEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return YesNoEnum.valueOf(str);
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
