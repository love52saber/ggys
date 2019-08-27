package net.seocoo.ggys.core.constants;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * 性别
 * @author PanChengHao
 * @date 2018/6/1 9:37
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum SexEnum {
    MALE(0,"男性"),
    FEMALE(1,"女性");
    private int code;
    private String desc;
    private String name;

    SexEnum(int code, String desc) {
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
