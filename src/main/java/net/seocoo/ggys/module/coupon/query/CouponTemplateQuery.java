package net.seocoo.ggys.module.coupon.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateStateEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 优惠券模板查询Query
 *
 * @author ZengXiaoLiang
 * @date 2018/5/30 14:28
 **/
@ApiModel(value = "优惠券模板Query")
public class CouponTemplateQuery extends BaseQuery {

  @ApiModelProperty(value = "名称")
  private String name;
  @ApiModelProperty(value = "优惠券模板状态枚举")
  private CouponTemplateStateEnum state;

  @ApiModelProperty(value = "商家Id")
  private Integer merchantId;

  private Integer canUseCount;

  public Integer getCanUseCount() {
    return canUseCount;
  }

  public void setCanUseCount(Integer canUseCount) {
    this.canUseCount = canUseCount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CouponTemplateStateEnum getState() {
    return state;
  }

  public void setState(CouponTemplateStateEnum state) {
    this.state = state;
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
