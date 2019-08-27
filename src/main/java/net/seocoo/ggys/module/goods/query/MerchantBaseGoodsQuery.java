package net.seocoo.ggys.module.goods.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.goods.constans.GoodsStateEnum;
import net.seocoo.ggys.module.goods.constans.GoodsTypeEnum;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 9:21
 * @Email xieheng91@163.com
 * @Desc 商品信息查询
 */
@ApiModel(value = "商品查询条件",description = "用户商品列表的查询,商品审核列表的查询")
public class MerchantBaseGoodsQuery extends BaseQuery {

    /**
     * 商户id
     */
    @ApiModelProperty(value = "商户id")
    private Integer merchantId;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String name;

    /**
     * 商户名称
     */
    @ApiModelProperty(value = "商户名称")
    private String merchantName;

    /**
     * 分类
     */
    @ApiModelProperty(value = "商品类型,外卖或团购")
    private GoodsTypeEnum type;

    /**
     * 商品状态
     */
    @ApiModelProperty(value = "商品审核状态")
    private GoodsStateEnum state;
    /**
     * 商户id集合
     */
    @ApiModelProperty(value = "商户id集合")
    private List<Integer> merchandIdList;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public GoodsTypeEnum getType() {
        return type;
    }

    public void setType(GoodsTypeEnum type) {
        this.type = type;
    }

    public GoodsStateEnum getState() {
        return state;
    }

    public void setState(GoodsStateEnum state) {
        this.state = state;
    }

    public List<Integer> getMerchandIdList() {
        return merchandIdList;
    }

    public void setMerchandIdList(List<Integer> merchandIdList) {
        this.merchandIdList = merchandIdList;
    }
}
