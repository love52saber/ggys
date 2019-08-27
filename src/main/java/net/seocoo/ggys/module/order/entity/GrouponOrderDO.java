package net.seocoo.ggys.module.order.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 团购订单DO
 *
 * @author ZengXiaoLiang
 * @date 2018/5/29 14:29
 */
public class GrouponOrderDO implements Serializable {
  private Integer id;

  private Short orderCount;

  private Date bookStartDate;

  private Date bookEndDate;

  private String linkFullName;

  private String linkPhone;

  @JSONField(serialize = false)
  private String uuid;

  private static final long serialVersionUID = 1L;

  public GrouponOrderDO() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Short getOrderCount() {
    return orderCount;
  }

  public void setOrderCount(Short orderCount) {
    this.orderCount = orderCount;
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

  public String getLinkFullName() {
    return linkFullName;
  }

  public void setLinkFullName(String linkFullName) {
    this.linkFullName = linkFullName == null ? null : linkFullName.trim();
  }

  public String getLinkPhone() {
    return linkPhone;
  }

  public void setLinkPhone(String linkPhone) {
    this.linkPhone = linkPhone == null ? null : linkPhone.trim();
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid == null ? null : uuid.trim();
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
    GrouponOrderDO other = (GrouponOrderDO) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getOrderCount() == null ? other.getOrderCount() == null : this.getOrderCount().equals(other.getOrderCount()))
        && (this.getBookStartDate() == null ? other.getBookStartDate() == null : this.getBookStartDate().equals(other.getBookStartDate()))
        && (this.getBookEndDate() == null ? other.getBookEndDate() == null : this.getBookEndDate().equals(other.getBookEndDate()))
        && (this.getLinkFullName() == null ? other.getLinkFullName() == null : this.getLinkFullName().equals(other.getLinkFullName()))
        && (this.getLinkPhone() == null ? other.getLinkPhone() == null : this.getLinkPhone().equals(other.getLinkPhone()))
        && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getOrderCount() == null) ? 0 : getOrderCount().hashCode());
    result = prime * result + ((getBookStartDate() == null) ? 0 : getBookStartDate().hashCode());
    result = prime * result + ((getBookEndDate() == null) ? 0 : getBookEndDate().hashCode());
    result = prime * result + ((getLinkFullName() == null) ? 0 : getLinkFullName().hashCode());
    result = prime * result + ((getLinkPhone() == null) ? 0 : getLinkPhone().hashCode());
    result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
    return result;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}