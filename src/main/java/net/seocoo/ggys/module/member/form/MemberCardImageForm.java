package net.seocoo.ggys.module.member.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
 * @author PanChengHao
 * @date 2018/6/15 18:19
 */
@ApiModel(value = "会员卡图片与说明表单")
public class MemberCardImageForm {

  @ApiModelProperty(value = "id")
  private Integer id;

  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  @ApiModelProperty(value = "会员卡图片url地址")
  private String memberCardImageUrl;

  @ApiModelProperty(value = "会员卡说明")
  private String memberCardDescription;

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  public String getMemberCardImageUrl() {
    return memberCardImageUrl;
  }

  public void setMemberCardImageUrl(String memberCardImageUrl) {
    this.memberCardImageUrl = memberCardImageUrl;
  }

  public String getMemberCardDescription() {
    return memberCardDescription;
  }

  public void setMemberCardDescription(String memberCardDescription) {
    this.memberCardDescription = memberCardDescription;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
