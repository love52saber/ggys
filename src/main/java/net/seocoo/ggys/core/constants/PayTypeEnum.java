package net.seocoo.ggys.core.constants;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * 支付类型
 * @author PanChengHao
 * @date 2018/6/1 9:46
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum PayTypeEnum {
    WX(0,"微信支付"),
    ALIPAY(1,"支付宝支付");

    private int code;
    private String desc;
    private String name;

    PayTypeEnum(int code, String desc) {
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
