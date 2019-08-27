package net.seocoo.ggys.module.book.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.module.book.constants.BookDetailStateEnum;

/**
 * 更新预约详情表单类
 * @author PanChengHao
 * @date 2018/6/7 11:39
 */
@ApiModel(value="更新预约详情更新表单")
public class FreeBookDetailUpdateForm {

  @ApiModelProperty(value="主键 1")
  private Integer id;

  @ApiModelProperty(value="取消预约理由 取消预约时用")
  private String cancelReason;

  @ApiModelProperty(value="拒绝理由 审核预约时用")
  private String rejectReason;

  @ApiModelProperty(value="预约状态 更新使用")
  private BookDetailStateEnum bookState;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCancelReason() {
    return cancelReason;
  }

  public void setCancelReason(String cancelReason) {
    this.cancelReason = cancelReason;
  }

  public String getRejectReason() {
    return rejectReason;
  }

  public void setRejectReason(String rejectReason) {
    this.rejectReason = rejectReason;
  }

  public BookDetailStateEnum getBookState() {
    return bookState;
  }

  public void setBookState(BookDetailStateEnum bookState) {
    this.bookState = bookState;
  }
}
