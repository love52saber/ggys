package net.seocoo.ggys.module.coupon.dto;

import net.seocoo.ggys.module.coupon.constants.CouponTemplatePayRangEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateUseRangEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/14 10:19
 **/
public class CouponUseRecordInfoDTO {

  private Integer id;
  /**
   * 优惠券名称
   */
  private String name;
  /**
   * 面值
   */
  private BigDecimal faceValue;
  /**
   * 商家名
   */
  private String merchantName;
  /**
   * 有效结束日期
   */
  private Date validateEndDate;
  /**
   * 使用条件
   */
  private BigDecimal useCondition;
  /**
   * 支付范围
   */
  private List<CouponTemplatePayRangEnum> payRangEnumList;

  /**
   * 使用范围
   */
  private List<CouponTemplateUseRangEnum> useRangEnumList;

  /**
   * 有效开始时间
   */
  private Date validateStartDate;

  /**
   * 领取状态
   */
  private String getState;

  public String getGetState() {
    return getState;
  }

  public void setGetState(String getState) {
    this.getState = getState;
  }

  public Date getValidateStartDate() {
    return validateStartDate;
  }

  public void setValidateStartDate(Date validateStartDate) {
    this.validateStartDate = validateStartDate;
  }

  public BigDecimal getUseCondition() {
    return useCondition;
  }

  public void setUseCondition(BigDecimal useCondition) {
    this.useCondition = useCondition;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getFaceValue() {
    return faceValue;
  }

  public void setFaceValue(BigDecimal faceValue) {
    this.faceValue = faceValue;
  }

  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public Date getValidateEndDate() {
    return validateEndDate;
  }

  public void setValidateEndDate(Date validateEndDate) {
    this.validateEndDate = validateEndDate;
  }

  public List<CouponTemplatePayRangEnum> getPayRangEnumList() {
    return payRangEnumList;
  }

  public void setPayRangEnumList(List<CouponTemplatePayRangEnum> payRangEnumList) {
    this.payRangEnumList = payRangEnumList;
  }

  public List<CouponTemplateUseRangEnum> getUseRangEnumList() {
    return useRangEnumList;
  }

  public void setUseRangEnumList(List<CouponTemplateUseRangEnum> useRangEnumList) {
    this.useRangEnumList = useRangEnumList;
  }
}
