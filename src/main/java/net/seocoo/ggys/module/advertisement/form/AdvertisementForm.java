package net.seocoo.ggys.module.advertisement.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.advertisement.constans.PutInTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "广告表单",description = "广告表单")
public class AdvertisementForm implements Serializable {

    private String name;

    @ApiModelProperty(value = "图片地址")
    private String imgUrl;
    @ApiModelProperty(value = "广告分类")
    private PutInTypeEnum putInType;

    private String putInZone;
    @ApiModelProperty(value = "投放开始时间")
    private Date putInStartDate;

    @ApiModelProperty(value = "投放结束时间")
    private Date putInEndDate;

    @ApiModelProperty(value = "线上Y ,线下N, 状态")
    private YesNoEnum state;

    public PutInTypeEnum getPutInType() {
        return putInType;
    }

    public void setPutInType(PutInTypeEnum putInType) {
        this.putInType = putInType;
    }

    public AdvertisementForm() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getPutInZone() {
        return putInZone;
    }

    public void setPutInZone(String putInZone) {
        this.putInZone = putInZone == null ? null : putInZone.trim();
    }

    public Date getPutInStartDate() {
        return putInStartDate;
    }

    public void setPutInStartDate(Date putInStartDate) {
        this.putInStartDate = putInStartDate;
    }

    public Date getPutInEndDate() {
        return putInEndDate;
    }

    public void setPutInEndDate(Date putInEndDate) {
        this.putInEndDate = putInEndDate;
    }

    public YesNoEnum getState() {
        return state;
    }

    public void setState(YesNoEnum state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}