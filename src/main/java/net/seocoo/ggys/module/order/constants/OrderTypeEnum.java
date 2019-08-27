package net.seocoo.ggys.module.order.constants;

import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 订单类型枚举
 * @author ZengXiaoLiang
 * @date 2018/6/7 19:46
 **/
public enum OrderTypeEnum {
  /**
   * 团购
   */
  GROUPON(0, "团购"),

  /**
   * 外卖
   */
  TAKE_OUT(1, "外卖");

  private int code;
  private String desc;
  private String name;

  public String getName() {
    return this.name();
  }

  private OrderTypeEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, OrderTypeEnum> BY_VALUE_MAP = new LinkedHashMap<>();
  static {
    for(OrderTypeEnum orderTypeEnum : OrderTypeEnum.values()){
      BY_VALUE_MAP.put(orderTypeEnum.getCode(), orderTypeEnum);
    }
  }

  /**
   * 根据code查询对应的订单类型枚举
   * @param code
   * @return OrderTypeEnum
   * @throws EnumNotFoundException
   */
  public static OrderTypeEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的订单类型枚举
   * @param str 枚举的name
   * @return OrderTypeEnum
   * @throws EnumNotFoundException
   */
  public static OrderTypeEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return OrderTypeEnum.valueOf(str);
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
