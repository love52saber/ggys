package net.seocoo.ggys.module.evaluate.constants;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * 订单评价结果枚举类
 * @author PanChengHao
 * @date 2018/6/13 17:44
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum OrderEvaluateResultEnum {
  TERRIBLE(0,"糟糕"),
  COMPLAINTS(1,"吐槽"),
  SATISFIED(2,"满意"),
  EXCELLENT(3,"超赞");

  private int code;
  private String desc;
  private String name;

  OrderEvaluateResultEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
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
