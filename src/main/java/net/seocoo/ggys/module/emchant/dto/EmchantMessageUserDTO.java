package net.seocoo.ggys.module.emchant.dto;

import net.seocoo.ggys.module.emchant.constans.MessageTypeEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author xieheng
 * @Data 2018/6/19 0019 11:21
 * @Email xieheng91@163.com
 * @Desc 聊天消息列表
 */
public class EmchantMessageUserDTO implements Serializable {

    private String fromUserImgUrl;

    private String fromUser;

    private String fromUserName;

    private Integer readCount;

    private Integer unReadCount;

    private MessageTypeEnum type;

    private String lastTxtMsg;

    private String lastImgMsg;

    private Date lastDate;

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getFromUserImgUrl() {
        return fromUserImgUrl;
    }

    public void setFromUserImgUrl(String fromUserImgUrl) {
        this.fromUserImgUrl = fromUserImgUrl;
    }

    public MessageTypeEnum getType() {
        return type;
    }

    public void setType(MessageTypeEnum type) {
        this.type = type;
    }

    public String getLastTxtMsg() {
        return lastTxtMsg;
    }

    public void setLastTxtMsg(String lastTxtMsg) {
        this.lastTxtMsg = lastTxtMsg;
    }

    public String getLastImgMsg() {
        return lastImgMsg;
    }

    public void setLastImgMsg(String lastImgMsg) {
        this.lastImgMsg = lastImgMsg;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getUnReadCount() {
        return unReadCount;
    }

    public void setUnReadCount(Integer unReadCount) {
        this.unReadCount = unReadCount;
    }
}
