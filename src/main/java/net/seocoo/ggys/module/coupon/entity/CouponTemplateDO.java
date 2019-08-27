package net.seocoo.ggys.module.coupon.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplatePayRangEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateStateEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateUseRangEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 优惠券模板DO实体
 *
 * @author ZengXiaoLiang
 * @date 2018/5/29 14:27
 */
public class CouponTemplateDO implements Serializable {
  private Integer id;

  private String name;

  private Integer totalCount;

  private Integer canUseCount;

  private BigDecimal faceValue;

  private Date validateStartDate;

  private Date validateEndDate;

  private Integer useRang;

  private Integer payRang;

  private BigDecimal useCondition;

  private CouponTemplateStateEnum state;

  private Integer merchantId;

  @JSONField(serialize = false)
  private String uuid;

  @JSONField(serialize = false)
  private Integer version;

  @JSONField(serialize = false)
  private YesNoEnum canDeleted;

  private String remark;

  private Integer countPerPerson;

  private List<CouponTemplatePayRangEnum> payRangEnumList;

  public void setPayRangEnumList(List<CouponTemplatePayRangEnum> payRangEnumList) {
    this.payRangEnumList = payRangEnumList;
  }

  public void setUseRangEnumList(List<CouponTemplateUseRangEnum> useRangEnumList) {
    this.useRangEnumList = useRangEnumList;
  }

  private List<CouponTemplateUseRangEnum> useRangEnumList;

  private static final long serialVersionUID = 1L;

  public CouponTemplateDO(Integer id, String name, Integer totalCount, Integer canUseCount, BigDecimal faceValue,
                          Date validateStartDate, Date validateEndDate, Integer useRang, Integer payRang,
                          BigDecimal useCondition, CouponTemplateStateEnum state, Integer merchantId, String uuid, Integer version,
                          YesNoEnum canDeleted, String remark, Integer countPerPerson) {
    this.id = id;
    this.name = name;
    this.totalCount = totalCount;
    this.canUseCount = canUseCount;
    this.faceValue = faceValue;
    this.validateStartDate = validateStartDate;
    this.validateEndDate = validateEndDate;
    this.useRang = useRang;
    this.payRang = payRang;
    this.useCondition = useCondition;
    this.state = state;
    this.merchantId = merchantId;
    this.uuid = uuid;
    this.version = version;
    this.canDeleted = canDeleted;
    this.remark = remark;
    this.countPerPerson = countPerPerson;
  }

  public CouponTemplateDO() {
    super();
  }

  public List<CouponTemplatePayRangEnum> getPayRangEnumList(){
    List<CouponTemplatePayRangEnum> payRangEnums = new ArrayList<>();
    if(this.getPayRang() == null || this.payRang.intValue() == 0){
      return payRangEnums;
    }
    for (CouponTemplatePayRangEnum payRangEnum : CouponTemplatePayRangEnum.values()) {
      if((payRangEnum.getCode() & payRang.intValue()) == payRangEnum.getCode()) {
        payRangEnums.add(payRangEnum);
      }
    }
    return payRangEnums;
  }

  public List<CouponTemplateUseRangEnum> getUseRangEnumList() {
    List<CouponTemplateUseRangEnum> useRangEnumList = new ArrayList<>();
    if(this.getUseRang() == null || this.getUseRang().intValue() == 0){
      return useRangEnumList;
    }
    for (CouponTemplateUseRangEnum useRangEnum : CouponTemplateUseRangEnum.values()) {
      if((useRangEnum.getCode() & this.useRang.intValue() ) == useRangEnum.getCode() ){
        useRangEnumList.add(useRangEnum);
      }
    }
    return useRangEnumList;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * get优惠券名称
   *
   * @return 优惠券名称
   */
  public String getName() {
    return name;
  }

  /**
   * set优惠券名称
   *
   * @param name 优惠券名称
   */
  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  /**
   * get总可领取数量
   *
   * @return 总可领取数量
   */
  public Integer getTotalCount() {
    return totalCount;
  }

  /**
   * set总可领取数量
   *
   * @param totalCount 总可领取数量
   */
  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  /**
   * get还可领取数量
   *
   * @return 还可领取数量
   */
  public Integer getCanUseCount() {
    return canUseCount;
  }

  /**
   * set还可领取数量
   *
   * @param canUseCount 还可领取数量
   */
  public void setCanUseCount(Integer canUseCount) {
    this.canUseCount = canUseCount;
  }

  /**
   * get面值
   *
   * @return 面值
   */
  public BigDecimal getFaceValue() {
    return faceValue;
  }

  /**
   * set面值
   *
   * @param faceValue
   */
  public void setFaceValue(BigDecimal faceValue) {
    this.faceValue = faceValue;
  }

  /**
   * get优惠券的有效开始时间
   *
   * @return 优惠券的有效开始时间
   */
  public Date getValidateStartDate() {
    return validateStartDate;
  }

  /**
   * set优惠券的有效开始时间
   *
   * @param validateStartDate 优惠券的有效开始时间
   */
  public void setValidateStartDate(Date validateStartDate) {
    this.validateStartDate = validateStartDate;
  }

  /**
   * get优惠券的有效结束时间
   * @return 优惠券的有效结束时间
   */
  public Date getValidateEndDate() {
    return validateEndDate;
  }

  /**
   * set优惠券的有效结束时间
   * @param validateEndDate 优惠券的有效结束时间
   */
  public void setValidateEndDate(Date validateEndDate) {
    this.validateEndDate = validateEndDate;
  }

  /**
   * 优惠券使用范围
   * @return 优惠券使用范围
   */
  public Integer getUseRang() {
    return useRang;
  }

  /**
   * 优惠券使用范围
   * @param useRang 优惠券使用范围
   */
  public void setUseRang(Integer useRang) {
    this.useRang = useRang;
  }

  /**
   * 优惠券支付范围
   * @return 优惠券支付范围
   */
  public Integer getPayRang() {
    return payRang;
  }

  /**
   * 优惠券支付范围
   * @param payRang 优惠券支付范围
   */
  public void setPayRang(Integer payRang) {
    this.payRang = payRang;
  }

  /**
   * 优惠券使用条件
   * @return 优惠券使用条件
   */
  public BigDecimal getUseCondition() {
    return useCondition;
  }

  /**
   * 优惠券使用条件
   * @param useCondition 优惠券使用条件
   */
  public void setUseCondition(BigDecimal useCondition) {
    this.useCondition = useCondition;
  }

  /**
   * 优惠券状态
   * @return 优惠券状态
   */
  public CouponTemplateStateEnum getState() {
    return state;
  }

  /**
   * 优惠券状态
   * @param state 优惠券状态
   */
  public void setState(CouponTemplateStateEnum state) {
    this.state = state;
  }

  /**
   * 商户Id
   * @return 商户Id
   */
  public Integer getMerchantId() {
    return merchantId;
  }

  /**
   * 商户Id
   * @param merchantId 商户Id
   */
  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  /**
   * uuid
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * uuid
   * @param uuid uuid
   */
  public void setUuid(String uuid) {
    this.uuid = uuid == null ? null : uuid.trim();
  }

  /**
   * 版本号
   * @return 版本号
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * 版本号
   * @param version 版本号
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   * 是否删除
   * @return 是否删除
   */
  public YesNoEnum getCanDeleted() {
    return canDeleted;
  }

  /**
   * 是否删除
   * @param canDeleted 是否删除
   */
  public void setCanDeleted(YesNoEnum canDeleted) {
    this.canDeleted = canDeleted;
  }

  /**
   * 备注
   * @return 备注
   */
  public String getRemark() {
    return remark;
  }

  /**
   * 备注
   * @param remark 备注
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * 每人限领张数
   * @return 每人限领张数
   */
  public Integer getCountPerPerson() {
    return countPerPerson;
  }

  /**
   * 每人限领张数
   * @param countPerPerson
   */
  public void setCountPerPerson(Integer countPerPerson) {
    this.countPerPerson = countPerPerson;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null) {
      return false;
    }
    if (getClass() != that.getClass()) {
      return false;
    }
    CouponTemplateDO other = (CouponTemplateDO) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
        && (this.getTotalCount() == null ? other.getTotalCount() == null : this.getTotalCount().equals(other.getTotalCount()))
        && (this.getCanUseCount() == null ? other.getCanUseCount() == null : this.getCanUseCount().equals(other.getCanUseCount()))
        && (this.getFaceValue() == null ? other.getFaceValue() == null : this.getFaceValue().equals(other.getFaceValue()))
        && (this.getValidateStartDate() == null ? other.getValidateStartDate() == null : this.getValidateStartDate().equals(other.getValidateStartDate()))
        && (this.getValidateEndDate() == null ? other.getValidateEndDate() == null : this.getValidateEndDate().equals(other.getValidateEndDate()))
        && (this.getUseRang() == null ? other.getUseRang() == null : this.getUseRang().equals(other.getUseRang()))
        && (this.getPayRang() == null ? other.getPayRang() == null : this.getPayRang().equals(other.getPayRang()))
        && (this.getUseCondition() == null ? other.getUseCondition() == null : this.getUseCondition().equals(other.getUseCondition()))
        && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
        && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
        && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
        && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
        && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()))
        && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        && (this.getCountPerPerson() == null ? other.getCountPerPerson() == null : this.getCountPerPerson().equals(other.getCountPerPerson()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
    result = prime * result + ((getTotalCount() == null) ? 0 : getTotalCount().hashCode());
    result = prime * result + ((getCanUseCount() == null) ? 0 : getCanUseCount().hashCode());
    result = prime * result + ((getFaceValue() == null) ? 0 : getFaceValue().hashCode());
    result = prime * result + ((getValidateStartDate() == null) ? 0 : getValidateStartDate().hashCode());
    result = prime * result + ((getValidateEndDate() == null) ? 0 : getValidateEndDate().hashCode());
    result = prime * result + ((getUseRang() == null) ? 0 : getUseRang().hashCode());
    result = prime * result + ((getPayRang() == null) ? 0 : getPayRang().hashCode());
    result = prime * result + ((getUseCondition() == null) ? 0 : getUseCondition().hashCode());
    result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
    result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
    result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
    result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
    result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
    result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
    result = prime * result + ((getCountPerPerson() == null) ? 0 : getCountPerPerson().hashCode());
    return result;
  }
}