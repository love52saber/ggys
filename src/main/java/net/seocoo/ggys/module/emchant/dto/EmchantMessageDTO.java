package net.seocoo.ggys.module.emchant.dto;

import net.seocoo.ggys.module.emchant.constans.MessageTypeEnum;

import java.util.Date;

/**
 * @Author xieheng
 * @Data 2018/6/19 0019 11:21
 * @Email xieheng91@163.com
 * @Desc 聊天消息
 */
public class EmchantMessageDTO {

    private String fromUser;

    private String toUser;

    private MessageTypeEnum type;

    private String txtMsg;

    private String imgMsg;


    private Date createDate;


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public MessageTypeEnum getType() {
        return type;
    }

    public void setType(MessageTypeEnum type) {
        this.type = type;
    }

    public String getTxtMsg() {
        return txtMsg;
    }

    public void setTxtMsg(String txtMsg) {
        this.txtMsg = txtMsg;
    }

    public String getImgMsg() {
        return imgMsg;
    }

    public void setImgMsg(String imgMsg) {
        this.imgMsg = imgMsg;
    }
}
