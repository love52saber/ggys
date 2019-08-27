package net.seocoo.ggys.module.emchant.form;

import net.seocoo.ggys.module.emchant.constans.MessageTypeEnum;
import net.seocoo.ggys.module.emchant.constans.ReadStateEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @Author xieheng
 * @Data 2018/6/19 0019 17:21
 * @Email xieheng91@163.com
 * @Desc 及时通讯消息内容
 */
public class MessageForm implements Serializable {

    /**
     * 消息阅读状态
     */
    private ReadStateEnum state;
    /**
     * 发送人
     */
    private String fromUser;

    /**
     * 接收人
     */
    private String toUser;

    /**
     * 消息类型,TXT,IMG
     */
    private MessageTypeEnum type;

    /**
     * 文本消息内容
     */
    private String txtMsg;

    /**
     * 图片消息内容,为url
     */
    private String imgMsg;

    public ReadStateEnum getState() {
        return state;
    }

    public void setState(ReadStateEnum state) {
        this.state = state;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}
