package net.seocoo.ggys.module.emchant.constans;

import com.alibaba.fastjson.annotation.JSONType;
import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 环信注册状态枚举
 * @author xieheng
 * @date 2018/6/14
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum RegisterStateEnum {
  /**
   * 是
   */
  SUCCESS(1, "注册成功"),
  /**
   * 否
   */
  FAIL(0, "注册失败");

  private int code;
  private String desc;
  private String name;

  private RegisterStateEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, RegisterStateEnum> BY_VALUE_MAP = new LinkedHashMap<>();

  static {
    for (RegisterStateEnum registerStateEnum : RegisterStateEnum.values()) {
      BY_VALUE_MAP.put(registerStateEnum.getCode(), registerStateEnum);
    }
  }

  /**
   * 根据code查询对应的外卖类型枚举
   *
   * @param code dode
   * @return registerStateEnum
   * @throws EnumNotFoundException
   */
  public static RegisterStateEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的外卖类型枚举
   *
   * @param str 枚举的name
   * @return registerStateEnum
   * @throws EnumNotFoundException
   */
  public static RegisterStateEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return RegisterStateEnum.valueOf(str);
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
