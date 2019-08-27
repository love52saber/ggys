package net.seocoo.ggys.module.book.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 免费预约规则表单类
 * @author PanChengHao
 * @date 2018/6/12 15:39
 */
@ApiModel(value = "免费预约规则表单")
public class FreeBookRuleForm {

  private Integer id;

  @ApiModelProperty(value = "商户Id")
  private Integer merchantId;

  @ApiModelProperty(value = "预约开始时间")
  private Date bookStartDate;

  @ApiModelProperty(value = "预约结束时间")
  private Date bookEndDate;

  @ApiModelProperty(value = "最大可预约人数")
  private Integer maxBookCount;

  @ApiModelProperty(value = "是否展示")
  private YesNoEnum canDisplay;

  @ApiModelProperty(value = "管理员id")
  private Integer manageUserId;

  private static final long serialVersionUID = 1L;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  public Date getBookStartDate() {
    return bookStartDate;
  }

  public void setBookStartDate(Date bookStartDate) {
    this.bookStartDate = bookStartDate;
  }

  public Date getBookEndDate() {
    return bookEndDate;
  }

  public void setBookEndDate(Date bookEndDate) {
    this.bookEndDate = bookEndDate;
  }

  public Integer getMaxBookCount() {
    return maxBookCount;
  }

  public void setMaxBookCount(Integer maxBookCount) {
    this.maxBookCount = maxBookCount;
  }

  public YesNoEnum getCanDisplay() {
    return canDisplay;
  }

  public void setCanDisplay(YesNoEnum canDisplay) {
    this.canDisplay = canDisplay;
  }

  public Integer getManageUserId() {
    return manageUserId;
  }

  public void setManageUserId(Integer manageUserId) {
    this.manageUserId = manageUserId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
