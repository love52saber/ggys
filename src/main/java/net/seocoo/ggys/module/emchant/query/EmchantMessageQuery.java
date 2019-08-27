package net.seocoo.ggys.module.emchant.query;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.emchant.constans.ReadStateEnum;

/**
 * @Author xieheng
 * @Data 2018/6/19 0019 17:08
 * @Email xieheng91@163.com
 * @Desc 聊天记录查询
 */
public class EmchantMessageQuery extends BaseQuery {

    /**
     * 消息阅读状态
     */
    private ReadStateEnum state;

    private String fromUser;

    private String toUser;
    /**
     * 发送人和接受人拼接字符串
     */
    private String fromAndTo;

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

    public String getFromAndTo() {
        return fromAndTo;
    }

    public void setFromAndTo(String fromAndTo) {
        this.fromAndTo = fromAndTo;
    }


}
