package net.seocoo.ggys.module.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 验证码
 *
 * @author wangpan
 * @date 2018/6/9
 */
public class ValidateCodeDO implements Serializable {
  private Integer id;
  /**
   * 手机号
   */
  private String phone;
  /**
   * 验证码
   */
  private String validateCode;

  private Date createTime;

  private static final long serialVersionUID = 1L;

  public ValidateCodeDO(Integer id, String phone, String validateCode, Date createTime) {
    this.id = id;
    this.phone = phone;
    this.validateCode = validateCode;
    this.createTime = createTime;
  }

  public ValidateCodeDO() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }

  public String getValidateCode() {
    return validateCode;
  }

  public void setValidateCode(String validateCode) {
    this.validateCode = validateCode == null ? null : validateCode.trim();
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
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
    ValidateCodeDO other = (ValidateCodeDO) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
        && (this.getValidateCode() == null ? other.getValidateCode() == null : this.getValidateCode().equals(other.getValidateCode()))
        && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
    result = prime * result + ((getValidateCode() == null) ? 0 : getValidateCode().hashCode());
    result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "ValidateCodeDO{" +
        "id=" + id +
        ", phone='" + phone + '\'' +
        ", validateCode='" + validateCode + '\'' +
        ", createTime=" + createTime +
        '}';
  }
}