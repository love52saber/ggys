package net.seocoo.ggys.module.emchant.query;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.emchant.constans.ReadStateEnum;

/**
 * @Author xieheng
 * @Data 2018/6/19 0019 17:08
 * @Email xieheng91@163.com
 * @Desc 聊天记录查询
 */
public class EmchantMessageUserQuery extends BaseQuery {


    private ReadStateEnum readState = ReadStateEnum.READ;

    private ReadStateEnum unReadState = ReadStateEnum.UN_READ;

    private String toUser;

    public ReadStateEnum getReadState() {
        return readState;
    }

    public void setReadState(ReadStateEnum readState) {
        this.readState = readState;
    }

    public ReadStateEnum getUnReadState() {
        return unReadState;
    }

    public void setUnReadState(ReadStateEnum unReadState) {
        this.unReadState = unReadState;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
}
