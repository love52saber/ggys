package net.seocoo.ggys.module.order.entity;

import java.io.Serializable;

/**
 * 订单与商品中间表实体
 *
 * @author ZengXiaoLiang
 * @date 2018/5/29 14:31
 */
public class MerchantOrderGoodsDO implements Serializable {
  private Integer id;

  private Integer orderId;

  private Integer goodsId;

  private String uuid;

  private static final long serialVersionUID = 1L;

  public MerchantOrderGoodsDO(Integer id, Integer orderId, Integer goodsId, String uuid) {
    this.id = id;
    this.orderId = orderId;
    this.goodsId = goodsId;
    this.uuid = uuid;
  }

  public MerchantOrderGoodsDO() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Integer goodsId) {
    this.goodsId = goodsId;
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
    MerchantOrderGoodsDO other = (MerchantOrderGoodsDO) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
        && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
        && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
    result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
    result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
    return result;
  }
}