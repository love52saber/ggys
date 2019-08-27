package net.seocoo.ggys.module.merchant.constans;

import net.seocoo.ggys.core.exception.EnumNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author xieheng
 * @Data 2018/6/7 0007 16:32
 * @Email xieheng91@163.com
 * @Desc 商户功能模块
 */
public enum MerchantFunctionEnum {
    /**
     * 预约
     */
    BOOK(1,"预约"),
    /**
     * 团购
     */
    GROUPON(2, "团购"),
    /**
     * 外卖
     */
    TAKE_OUT (4,"外卖"),



    MEMBER(8,"会员系统"),



    MARKETING(16,"营销");

    private int code;
    private String desc;

    private String name;
    private MerchantFunctionEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static final Map<Integer, MerchantFunctionEnum> BY_VALUE_MAP = new LinkedHashMap<>();
    static {
        for(MerchantFunctionEnum merchantFunctionEnum : MerchantFunctionEnum.values()){
            BY_VALUE_MAP.put(merchantFunctionEnum.getCode(), merchantFunctionEnum);
        }
    }

    /**
     * 根据code查询对应的外卖类型枚举
     * @param code
     * @return merchantFunctionEnum
     * @throws EnumNotFoundException
     */
    public static MerchantFunctionEnum convertCode2Enum(int code) throws EnumNotFoundException {
        if (!BY_VALUE_MAP.containsKey(code)) {
            throw new EnumNotFoundException("枚举对应的code" + code + "不存在");
        }
        return BY_VALUE_MAP.get(code);
    }

    /**
     * 根据枚举name查询对应的外卖类型枚举
     * @param str 枚举的name
     * @return merchantFunctionEnum
     * @throws EnumNotFoundException
     */
    public static MerchantFunctionEnum convertStr2Enum(String str) throws EnumNotFoundException {
        try {
            return MerchantFunctionEnum.valueOf(str);
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
