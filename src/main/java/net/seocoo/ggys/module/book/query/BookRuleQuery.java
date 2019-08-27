package net.seocoo.ggys.module.book.query;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 商家预约规则查询
 *
 * @author panch
 * @date 2018/5/31 10:18
 */
public class BookRuleQuery extends BaseQuery {
  private Integer merchantId;
  private YesNoEnum canDisplay;

  public YesNoEnum getCanDisPlay() {
    return canDisplay;
  }

  public void setCanDisplay(YesNoEnum canDisplay) {
    this.canDisplay = canDisplay;
  }

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
