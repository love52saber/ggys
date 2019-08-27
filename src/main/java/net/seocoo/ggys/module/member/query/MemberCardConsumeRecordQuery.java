package net.seocoo.ggys.module.member.query;

import net.seocoo.ggys.core.base.BaseQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * @author PanChengHao
 * @date 2018/6/1 12:39
 */
public class MemberCardConsumeRecordQuery extends BaseQuery {

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
