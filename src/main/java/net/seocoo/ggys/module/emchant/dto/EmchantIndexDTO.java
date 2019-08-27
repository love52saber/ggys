package net.seocoo.ggys.module.emchant.dto;

import net.seocoo.ggys.module.emchant.constans.ChantTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/19 0019 11:20
 * @Email xieheng91@163.com
 * @Desc 初始聊天窗口内容
 */
public class EmchantIndexDTO implements Serializable {

    private ChantTypeEnum chantType;

    private Integer merchantId;

    private String fromUserImgUrl;


    private String fromUserNameEmchant;

    /**
     * 名称
     */
    private String fromUserName;

    /**
     * 密码
     */
    private String fromUserPassword;


    /**
     * 头像
     */
    private String toUserImgUrl;
    /**
     * 即时通讯的注册用户名
     */
    private String toUserNameEmchant;


    private String toUserName;

    private String toUserPassword;

    public ChantTypeEnum getChantType() {
        return chantType;
    }

    public void setChantType(ChantTypeEnum chantType) {
        this.chantType = chantType;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    List<EmchantMessageDTO> messageList;

    public List<EmchantMessageDTO> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<EmchantMessageDTO> messageList) {
        this.messageList = messageList;
    }

    public String getFromUserImgUrl() {
        return fromUserImgUrl;
    }

    public void setFromUserImgUrl(String fromUserImgUrl) {
        this.fromUserImgUrl = fromUserImgUrl;
    }

    public String getFromUserNameEmchant() {
        return fromUserNameEmchant;
    }

    public void setFromUserNameEmchant(String fromUserNameEmchant) {
        this.fromUserNameEmchant = fromUserNameEmchant;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getFromUserPassword() {
        return fromUserPassword;
    }

    public void setFromUserPassword(String fromUserPassword) {
        this.fromUserPassword = fromUserPassword;
    }

    public String getToUserImgUrl() {
        return toUserImgUrl;
    }

    public void setToUserImgUrl(String toUserImgUrl) {
        this.toUserImgUrl = toUserImgUrl;
    }

    public String getToUserNameEmchant() {
        return toUserNameEmchant;
    }

    public void setToUserNameEmchant(String toUserNameEmchant) {
        this.toUserNameEmchant = toUserNameEmchant;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getToUserPassword() {
        return toUserPassword;
    }

    public void setToUserPassword(String toUserPassword) {
        this.toUserPassword = toUserPassword;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}
