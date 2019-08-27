package net.seocoo.ggys.module.coupon.constants;

import com.alibaba.fastjson.annotation.JSONType;
import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 优惠券使用记录状态
 * @author ZengXiaoLiang
 * @date 2018/6/4 14:56
 **/
@JSONType(serializeEnumAsJavaBean = true)
public enum CouponUseRecordStateEnum {
  /**
   * 未使用
   */
  NOT_USE(1,"未使用"),
  /**
   * 已使用
   */
  USED(2, "已使用"),
  /**
   * 已失效
   */
  FAIL(3,"已失效");

  private int code;
  private String desc;
  private String name;

  private CouponUseRecordStateEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, CouponUseRecordStateEnum> BY_VALUE_MAP = new LinkedHashMap<>();
  static {
    for(CouponUseRecordStateEnum couponUseRecordStateEnum : CouponUseRecordStateEnum.values()){
      BY_VALUE_MAP.put(couponUseRecordStateEnum.getCode(), couponUseRecordStateEnum);
    }
  }

  /**
   * 根据code查询对应的优惠券使用记录状态枚举
   * @param code
   * @return CouponUseRecordStateEnum
   * @throws EnumNotFoundException
   */
  public static CouponUseRecordStateEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的优惠券使用记录状态枚举
   * @param str 枚举的name
   * @return CouponUseRecordStateEnum
   * @throws EnumNotFoundException
   */
  public static CouponUseRecordStateEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return CouponUseRecordStateEnum.valueOf(str);
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
