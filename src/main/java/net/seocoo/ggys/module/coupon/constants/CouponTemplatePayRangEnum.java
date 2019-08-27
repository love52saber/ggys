package net.seocoo.ggys.module.coupon.constants;

import com.alibaba.fastjson.annotation.JSONType;
import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 优惠券支付方法枚举
 * @author ZengXiaoLiang
 * @date 2018/5/31 15:43
 **/
@JSONType(serializeEnumAsJavaBean = true)
public enum CouponTemplatePayRangEnum {
  /**
   * 会员卡支付
   */
  MEMBER_CARD_PAY(1,"会员卡支付"),
  /**
   * 微信支付
   */
  WX_PAY(2, "微信支付"),

  /**
   * 线下支付
   */
  OFFLINE_PAY(4, "线下支付");

//  /**
//   * 支付宝支付
//   */
//  AL_PAY(8,"支付宝支付");

  private int code;
  private String desc;
  private String name;

  private CouponTemplatePayRangEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getName() {
    return this.name();
  }

  private static final Map<Integer, CouponTemplatePayRangEnum> BY_VALUE_MAP = new LinkedHashMap<>();
  static {
    for(CouponTemplatePayRangEnum couponTemplatePayRangEnum : CouponTemplatePayRangEnum.values()){
      BY_VALUE_MAP.put(couponTemplatePayRangEnum.getCode(), couponTemplatePayRangEnum);
    }
  }

  /**
   * 根据code查询对应的优惠券支付类型枚举
   * @param code
   * @return CouponTemplatePayRangEnum
   * @throws EnumNotFoundException
   */
  public static CouponTemplatePayRangEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的优惠券支付类型枚举
   * @param str 枚举的name
   * @return CouponTemplatePayRangEnum
   * @throws EnumNotFoundException
   */
  public static CouponTemplatePayRangEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return CouponTemplatePayRangEnum.valueOf(str);
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
