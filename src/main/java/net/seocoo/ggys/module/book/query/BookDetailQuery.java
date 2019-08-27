package net.seocoo.ggys.module.book.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.book.constants.BookDetailStateEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * @author panch
 * @date 2018/5/31 11:10
 */

@ApiModel(value = "预约详情查询")
public class BookDetailQuery extends BaseQuery {
  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  @ApiModelProperty(value = "姓名")
  private String fullName;

  @ApiModelProperty(value = "手机号")
  private String phone;

  @ApiModelProperty(value = "预约状态")
  private BookDetailStateEnum bookDetailState;

  @ApiModelProperty(value = "前端不用传，后台自己用")
  private BookDetailStateEnum usedBookDetailState;

  @ApiModelProperty(value = "预约用户id,不用传")
  private Integer bookUserId;

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

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

  public BookDetailStateEnum getBookDetailState() {
    return bookDetailState;
  }

  public void setBookDetailState(BookDetailStateEnum bookDetailState) {
    this.bookDetailState = bookDetailState;
  }

  public BookDetailStateEnum getUsedBookDetailState() {
    return usedBookDetailState;
  }

  public void setUsedBookDetailState(BookDetailStateEnum usedBookDetailState) {
    this.usedBookDetailState = usedBookDetailState;
  }

  public Integer getBookUserId() {
    return bookUserId;
  }

  public void setBookUserId(Integer bookUserId) {
    this.bookUserId = bookUserId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
