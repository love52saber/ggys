package net.seocoo.ggys.module.goods.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.module.goods.constans.GoodsStateEnum;

import java.io.Serializable;

/**
 * @Author xieheng
 * @Data 2018/6/7 0007 11:02
 * @Email xieheng91@163.com
 * @Desc 商品审核表单
 */
@ApiModel(value = "商品审核表单")
public class GoodsAuditForm implements Serializable {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "审核状态")
    private GoodsStateEnum state;

    @ApiModelProperty(value = "审核结果")
    private String auditResult;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GoodsStateEnum getState() {
        return state;
    }

    public void setState(GoodsStateEnum state) {
        this.state = state;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }
}
