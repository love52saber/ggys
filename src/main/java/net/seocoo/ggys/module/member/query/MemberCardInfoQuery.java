package net.seocoo.ggys.module.member.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * 会员卡信息查询类
 * @author PanChengHao
 * @date 2018/6/1 11:57
 */
@ApiModel(value = "会员卡信息查询")
public class MemberCardInfoQuery extends BaseQuery {
  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  @ApiModelProperty(value = "搜索的关键词")
  private String keyWords;

  @ApiModelProperty(value = "用户id，不需要传")
  private Integer userId;

  @ApiModelProperty(value = "商户id集合，不需要传")
  private List<Integer> merchantIdList;

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  public String getKeyWords() {
    return keyWords;
  }

  public void setKeyWords(String keyWords) {
    this.keyWords = keyWords;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public List<Integer> getMerchantIdList() {
    return merchantIdList;
  }

  public void setMerchantIdList(List<Integer> merchantIdList) {
    this.merchantIdList = merchantIdList;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
