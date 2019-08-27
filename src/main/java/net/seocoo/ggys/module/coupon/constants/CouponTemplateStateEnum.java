package net.seocoo.ggys.module.coupon.constants;

import com.alibaba.fastjson.annotation.JSONType;
import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 优惠券模板状态
 * @author ZengXiaoLiang
 * @date 2018/5/29 17:08
 **/
@JSONType(serializeEnumAsJavaBean = true)
public enum CouponTemplateStateEnum {
  /**
   * 初始
   */
  INIT(0,"初始"),
  /**
   * 进行中
   */
  PUBLISH(1, "进行中"),
  /**
   * 已终止
   */
  FINISH(2,"已终止"),
  /**
   * 已禁止
   */
  FORBID(3, "已禁止");

  private int code;
  private String desc;
  private String name;

  public String getName() {
    return this.name();
  }

  private CouponTemplateStateEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, CouponTemplateStateEnum> BY_VALUE_MAP = new LinkedHashMap<>();
  static {
    for(CouponTemplateStateEnum couponTemplateStateEnum : CouponTemplateStateEnum.values()){
      BY_VALUE_MAP.put(couponTemplateStateEnum.getCode(), couponTemplateStateEnum);
    }
  }

  /**
   * 根据code查询对应的优惠券模板状态枚举
   * @param code code
   * @return CouponTemplateStateEnum  优惠券模板状态枚举
   * @throws EnumNotFoundException
   */
  public static CouponTemplateStateEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的优惠券模板状态枚举
   * @param str 枚举的name
   * @return CouponTemplateStateEnum 优惠券模板状态枚举
   * @throws EnumNotFoundException
   */
  public static CouponTemplateStateEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return CouponTemplateStateEnum.valueOf(str);
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
