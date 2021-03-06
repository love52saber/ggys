package net.seocoo.ggys.module.goods.constans;

import com.alibaba.fastjson.annotation.JSONType;
import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
*@author:hengxie
*@date:2018/6/5 0005
*@description: 商品类型
*/
@JSONType(serializeEnumAsJavaBean = true)
public enum GoodsTypeEnum {

  /**
   * 外卖
   */
  TAKE_OUT (0,"外卖"),
  /**
   * 团购
   */
  GROUPON(1, "团购");

  private int code;
  private String desc;

  private String name;
  private GoodsTypeEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private static final Map<Integer, GoodsTypeEnum> BY_VALUE_MAP = new LinkedHashMap<>();
  static {
    for(GoodsTypeEnum goodsTypeEnum : GoodsTypeEnum.values()){
      BY_VALUE_MAP.put(goodsTypeEnum.getCode(), goodsTypeEnum);
    }
  }

  /**
   * 根据code查询对应的外卖类型枚举
   * @param code
   * @return goodsTypeEnum
   * @throws EnumNotFoundException
   */
  public static GoodsTypeEnum convertCode2Enum(int code) throws EnumNotFoundException {
    if (!BY_VALUE_MAP.containsKey(code)) {
      throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
    }
    return BY_VALUE_MAP.get(code);
  }

  /**
   * 根据枚举name查询对应的外卖类型枚举
   * @param str 枚举的name
   * @return goodsTypeEnum
   * @throws EnumNotFoundException
   */
  public static GoodsTypeEnum convertStr2Enum(String str) throws EnumNotFoundException {
    try {
      return GoodsTypeEnum.valueOf(str);
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
