package net.seocoo.ggys.module.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author xieheng
 * @Data 2018/6/12 0012 17:03
 * @Email xieheng91@163.com
 * @Desc H5旺铺帮首页订单信息
 */
public class IndexDTO implements Serializable {
    /**
     * 订单数量
     */
    private Integer orderCount;

    /**
     * 当前营业额
     */
    private BigDecimal currentTurnover;


    public IndexDTO(Integer orderCount, BigDecimal currentTurnover) {
        this.orderCount = orderCount;
        this.currentTurnover = currentTurnover;
    }

    public BigDecimal getCurrentTurnover() {
        return currentTurnover;
    }

    public void setCurrentTurnover(BigDecimal currentTurnover) {
        this.currentTurnover = currentTurnover;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }
}
