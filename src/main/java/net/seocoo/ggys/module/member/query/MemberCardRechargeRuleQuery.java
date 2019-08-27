package net.seocoo.ggys.module.member.query;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 上级充值规则分页查询
 * @author PanChengHao
 * @date 2018/6/1 10:54
 */
public class MemberCardRechargeRuleQuery extends BaseQuery {
  private Integer merchantId;

  private Integer userId;

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
