package net.seocoo.ggys.module.book.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预约详情表单类
 * @author PanChengHao
 * @date 2018/6/7 10:23
 */
@ApiModel(value="预约详情表单")
public class FreeBookDetailForm {

  @ApiModelProperty(value = "姓名 张三")
  private String fullName;

  @ApiModelProperty(value = "手机号 15152562646")
  private String phone;

  @ApiModelProperty(value = "免费预约规则id 2")
  private Integer freeBookRuleId;

  @ApiModelProperty(value = "预约备注")
  private String bookRemark;

  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  private static final long serialVersionUID = 1L;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getFreeBookRuleId() {
    return freeBookRuleId;
  }

  public void setFreeBookRuleId(Integer freeBookRuleId) {
    this.freeBookRuleId = freeBookRuleId;
  }

  public String getBookRemark() {
    return bookRemark;
  }

  public void setBookRemark(String bookRemark) {
    this.bookRemark = bookRemark;
  }

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }
}
