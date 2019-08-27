package net.seocoo.ggys.module.coupon.form;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.module.coupon.constants.CouponTemplatePayRangEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateStateEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateUseRangEnum;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 优惠券模板Form
 * @author ZengXiaoLiang
 * @date 2018/6/11 14:31
 **/
@ApiModel(value = "优惠券模板Form")
public class CouponTemplateForm {

  @ApiModelProperty(value = "id,新增的时候不传")
  private Integer id;

  @Length(min=1, max= 20, message = "优惠券名称应在20个字符以内")
  @ApiModelProperty(value = "优惠券名称")
  private String name;

  @ApiModelProperty(value = "总数量")
  private Integer totalCount;

  @ApiModelProperty(value = "每人限领")
  private Integer countPerPerson;

  @ApiModelProperty(value = "面值")
  private BigDecimal faceValue;

  @NotNull(message = "有效期不能为空")
  @ApiModelProperty(value = "有效开始日期")
  private Date validateStartDate;

  @NotNull(message = "有效期不能为空")
  @ApiModelProperty(value = "有效结束日期")
  private Date validateEndDate;

  @ApiModelProperty(value = "使用范围，值为CouponTemplateUseRangEnum枚举的name")
  private List<CouponTemplateUseRangEnum> useRangList;

  @ApiModelProperty(value = "支付范围")
  private List<CouponTemplatePayRangEnum> payRangList;

  @ApiModelProperty(value = "指定范围，满30可用。不限传0")
  private BigDecimal useCondition;

  @ApiModelProperty(value = "使用说明")
  private String remark;

  @ApiModelProperty(value = "商家Id")
  private Integer merchantId;

  @ApiModelProperty(value = "状态。保存传INIT,保存并发布传PUBLISH")
  private CouponTemplateStateEnum state;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public Integer getCountPerPerson() {
    return countPerPerson;
  }

  public void setCountPerPerson(Integer countPerPerson) {
    this.countPerPerson = countPerPerson;
  }

  public BigDecimal getFaceValue() {
    return faceValue;
  }

  public void setFaceValue(BigDecimal faceValue) {
    this.faceValue = faceValue;
  }

  public Date getValidateStartDate() {
    return validateStartDate;
  }

  public void setValidateStartDate(Date validateStartDate) {
    this.validateStartDate = validateStartDate;
  }

  public Date getValidateEndDate() {
    return validateEndDate;
  }

  public void setValidateEndDate(Date validateEndDate) {
    this.validateEndDate = validateEndDate;
  }

  public List<CouponTemplateUseRangEnum> getUseRangList() {
    return useRangList;
  }

  public void setUseRangList(List<CouponTemplateUseRangEnum> useRangList) {
    this.useRangList = useRangList;
  }

  public List<CouponTemplatePayRangEnum> getPayRangList() {
    return payRangList;
  }

  public void setPayRangList(List<CouponTemplatePayRangEnum> payRangList) {
    this.payRangList = payRangList;
  }

  public BigDecimal getUseCondition() {
    return useCondition;
  }

  public void setUseCondition(BigDecimal useCondition) {
    this.useCondition = useCondition;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}
