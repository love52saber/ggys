package net.seocoo.ggys.module.coupon.constants;

import com.alibaba.fastjson.annotation.JSONType;
import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 优惠券模板使用范围
 * @author ZengXiaoLiang
 * @date 2018/5/31 15:53
 **/
@JSONType(serializeEnumAsJavaBean = true)
public enum CouponTemplateUseRangEnum {
  /**
   * 团购
   */
  GROUPON(1,"团购"),
  /**
   * 外卖
   */
  TAKE_OUT(2, "外卖");

  private int code;
  private String desc;
  private String name;

  public String getName() {
    return this.name();
  }

  private CouponTemplateUseRangEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, CouponTemplateUseRangEnum> BY_VALUE_MAP = new LinkedHashMap<>();
  static {
    for(CouponTemplateUseRangEnum couponTemplateUseRangEnum : CouponTemplateUseRangEnum.values()){
      BY_VALUE_MAP.put(couponTemplateUseRangEnum.getCode(), couponTemplateUseRangEnum);
    }
  }

  /**
   * 根据code查询对应的优惠券使用范围枚举
   * @param code
   * @return CouponTemplateUseRangEnum
   * @throws EnumNotFoundException
   */
  public static CouponTemplateUseRangEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的优惠券使用范围枚举
   * @param str 枚举的name
   * @return CouponTemplateUseRangEnum
   * @throws EnumNotFoundException
   */
  public static CouponTemplateUseRangEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return CouponTemplateUseRangEnum.valueOf(str);
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
