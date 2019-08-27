package net.seocoo.ggys.module.merchant.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author xieheng
 * @Data 2018/6/20 0020 10:16
 * @Email xieheng91@163.com
 * @Desc 商户标签
 */
@ApiModel(value = "商户标签")
public class LabelForm implements Serializable {

    @ApiModelProperty(value = "标签名")
    @Length(min = 1,max = 6,message = "不能为空,最长不能超过6个字符")
    private String name;

    @NotNull(message = "不能为空")
    @ApiModelProperty(value = "商户id")
    private Integer merchantId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }
}
