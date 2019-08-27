package net.seocoo.ggys.module.merchant.query;

import net.seocoo.ggys.core.base.BaseQuery;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 15:51
 * @Email xieheng91@163.com
 * @Desc 商户和分类中间表查询对象
 */
public class MerchantSecondClassifyQuery extends BaseQuery {
    private Integer id;

    private String uuid;


    private Integer firstClassifyId;

    private Integer secondClassifyId;

    private Integer merchantId;

    private List<Integer> secondClassifyIdList;

    public List<Integer> getSecondClassifyIdList() {
        return secondClassifyIdList;
    }


    public Integer getFirstClassifyId() {
        return firstClassifyId;
    }

    public void setFirstClassifyId(Integer firstClassifyId) {
        this.firstClassifyId = firstClassifyId;
    }

    public void setSecondClassifyIdList(List<Integer> secondClassifyIdList) {
        this.secondClassifyIdList = secondClassifyIdList;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSecondClassifyId() {
        return secondClassifyId;
    }

    public void setSecondClassifyId(Integer secondClassifyId) {
        this.secondClassifyId = secondClassifyId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }
}
