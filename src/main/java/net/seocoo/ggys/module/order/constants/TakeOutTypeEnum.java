package net.seocoo.ggys.module.order.constants;

import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 外卖类型枚举
 * @author ZengXiaoLiang
 * @date 2018/5/28 10:00
 **/
public enum TakeOutTypeEnum {
  /**
   * 到店自取
   */
  SELF_GOT(0, "到店自取"),

  /**
   * 商家配送
   */
  DELIVERY(1, "商家配送");

  private int code;
  private String desc;
  private String name;

  public String getName() {
    return this.name();
  }

  private TakeOutTypeEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, TakeOutTypeEnum> BY_VALUE_MAP = new LinkedHashMap<>();
  static {
    for(TakeOutTypeEnum takeOutTypeEnum : TakeOutTypeEnum.values()){
      BY_VALUE_MAP.put(takeOutTypeEnum.getCode(), takeOutTypeEnum);
    }
  }

  /**
   * 根据code查询对应的外卖类型枚举
   * @param code
   * @return TakeOutTypeEnum
   * @throws EnumNotFoundException
   */
  public static TakeOutTypeEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的外卖类型枚举
   * @param str 枚举的name
   * @return TakeOutTypeEnum
   * @throws EnumNotFoundException
   */
  public static TakeOutTypeEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return TakeOutTypeEnum.valueOf(str);
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
}
