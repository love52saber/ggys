package net.seocoo.ggys.core.constants;

import com.alibaba.fastjson.annotation.JSONType;
import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wangpan
 * @date 2018/6/4 15:03
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum UserRoleEnum {
    /**
     * 普通用户角色
     */
    NORMAL(0, "普通用户"),
    /**
     * 商户角色
     */
    MERCHANT(1, "商户"),
    /**
     * 社长角色
     */
    CHIEF(2, "社长"),

    /**
     * 总管理员
     */
    MANAGE(3, "总管理员");

    private int code;
    private String desc;
    private String name;

    private UserRoleEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static final Map<Integer, UserRoleEnum> BY_VALUE_MAP = new LinkedHashMap<>();

    static {
        for (UserRoleEnum userRoleEnum : UserRoleEnum.values()) {
            BY_VALUE_MAP.put(userRoleEnum.getCode(), userRoleEnum);
        }
    }

    /**
     * 根据code查询对应的外卖类型枚举
     *
     * @param code dode
     * @return UserRoleEnum
     * @throws EnumNotFoundException
     */
    public static UserRoleEnum convertCode2Enum(int code) throws EnumNotFoundException {
        if (!BY_VALUE_MAP.containsKey(code)) {
            throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
        }
        return BY_VALUE_MAP.get(code);
    }

    /**
     * 根据枚举name查询对应的外卖类型枚举
     *
     * @param str 枚举的name
     * @return UserRoleEnum
     * @throws EnumNotFoundException
     */
    public static UserRoleEnum convertStr2Enum(String str) throws EnumNotFoundException {
        try {
            return UserRoleEnum.valueOf(str);
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
