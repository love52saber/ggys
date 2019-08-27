package net.seocoo.ggys.module.book.constants;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * 预约状态
 * @author PanChengHao
 * @date 2018/5/31 20:38
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum BookDetailStateEnum {
    UNAUDIT(0,"未审核"),
    AUDITED(1,"审核通过"),
    REJECT(2,"拒绝"),
    CANCEL(3,"取消");

    private int code;
    private String desc;
    private String name;

    BookDetailStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getName() {
        return this.name();
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
