package net.seocoo.ggys.module.merchant.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:hengxie
 * @date:2018/6/5 0005
 * @description: 商户和行业分类关联
 */
public class MerchantSecondClassifyDO implements Serializable {
    private Integer id;

    private Integer firstClassifyId;

    /**
     * 二类分类id
     */
    private Integer secondClassifyId;

    /**
     * 商户id
     */
    private Integer merchantId;

    @JSONField(serialize = false)
    private Date createDate;

    @JSONField(serialize = false)
    private Integer createUserId;

    @JSONField(serialize = false)
    private Date updateDate;

    @JSONField(serialize = false)
    private Integer updateUserId;

    @JSONField(serialize = false)
    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;


    public MerchantSecondClassifyDO() {
        super();
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }


    public YesNoEnum getCanDeleted() {
        return canDeleted;
    }

    public void setCanDeleted(YesNoEnum canDeleted) {
        this.canDeleted = canDeleted;
    }

    public Integer getFirstClassifyId() {
        return firstClassifyId;
    }

    public void setFirstClassifyId(Integer firstClassifyId) {
        this.firstClassifyId = firstClassifyId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}