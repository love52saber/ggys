package net.seocoo.ggys.module.order.constants;

import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 订单状态枚举
 * @author ZengXiaoLiang
 * @date 2018/6/7 19:48
 **/
public enum OrderStateEnum {
  /**
   * 未消费
   */
  NOT_CONSUME(0, "未消费"),

  /**
   * 已消费
   */
  CONSUMED(1, "已消费"),

  /**
   * 已评价
   */
  EVALUATED(2,"已评价");

  private int code;
  private String desc;
  private String name;

  public String getName() {
    return this.name();
  }

  private OrderStateEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, OrderStateEnum> BY_VALUE_MAP = new LinkedHashMap<>();
  static {
    for(OrderStateEnum orderStateEnum : OrderStateEnum.values()){
      BY_VALUE_MAP.put(orderStateEnum.getCode(), orderStateEnum);
    }
  }

  /**
   * 根据code查询对应的订单状态枚举
   * @param code
   * @return OrderStateEnum
   * @throws EnumNotFoundException
   */
  public static OrderStateEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的订单状态枚举
   * @param str 枚举的name
   * @return OrderStateEnum
   * @throws EnumNotFoundException
   */
  public static OrderStateEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return OrderStateEnum.valueOf(str);
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
