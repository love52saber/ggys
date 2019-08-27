package net.seocoo.ggys.module.order.constants;

import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 订单支付类型枚举
 * @author ZengXiaoLiang
 * @date 2018/6/7 21:08
 **/
public enum OrderPayTypeEnum {
  /**
   * 会员卡
   */
  MEMBER_CARD(0, "会员卡"),

  /**
   * 微信
   */
  WX_PAY(1, "微信"),

  /**
   * 线下
   */
  OFFLINE(2, "线下");

  private int code;
  private String desc;
  private String name;

  public String getName() {
    return this.name();
  }

  private OrderPayTypeEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, OrderPayTypeEnum> BY_VALUE_MAP = new LinkedHashMap<>();
  static {
    for(OrderPayTypeEnum orderPayTypeEnum : OrderPayTypeEnum.values()){
      BY_VALUE_MAP.put(orderPayTypeEnum.getCode(), orderPayTypeEnum);
    }
  }

  /**
   * 根据code查询对应的订单支付类型枚举
   * @param code
   * @return OrderPayTypeEnum
   * @throws EnumNotFoundException
   */
  public static OrderPayTypeEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的订单支付类型枚举
   * @param str 枚举的name
   * @return OrderPayTypeEnum
   * @throws EnumNotFoundException
   */
  public static OrderPayTypeEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return OrderPayTypeEnum.valueOf(str);
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
