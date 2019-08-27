package net.seocoo.ggys.module.emchant.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.emchant.constans.RegisterStateEnum;

/**
 * @Author xieheng
 * @Data 2018/6/14 0014 17:13
 * @Email xieheng91@163.com
 * @Desc 环信注册账户查询
 */
@ApiModel(value = "环信注册账户查询",description = "环信注册账户查询")
public class EmchantRegisterQuery extends BaseQuery {

    @ApiModelProperty(value = "账户用户名")
    private String userName;

    @ApiModelProperty(value = "账户状态")
    private RegisterStateEnum registerState;

    public RegisterStateEnum getRegisterState() {
        return registerState;
    }

    public void setRegisterState(RegisterStateEnum registerState) {
        this.registerState = registerState;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
