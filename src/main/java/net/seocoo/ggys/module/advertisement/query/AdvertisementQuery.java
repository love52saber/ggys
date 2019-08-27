package net.seocoo.ggys.module.advertisement.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.advertisement.constans.PutInTypeEnum;

import java.util.Date;

/**
 * @Author xieheng
 * @Data 2018/6/13 0013 16:22
 * @Email xieheng91@163.com
 * @Desc 广告管理查询
 */
@ApiModel(value = "广告管理查询",description = "广告管理查询")
public class AdvertisementQuery extends BaseQuery {

    @ApiModelProperty(value = "广告名称")
    private String name;

    @ApiModelProperty(value = "投放类型")
    private PutInTypeEnum putInType;


    @ApiModelProperty(value = "投放开始时间")
    private Date putInStartDate;

    @ApiModelProperty(value = "投放结束时间")
    private Date putInEndDate;

    @ApiModelProperty(value = "上线或者下线状态")
    private YesNoEnum state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PutInTypeEnum getPutInType() {
        return putInType;
    }

    public void setPutInType(PutInTypeEnum putInType) {
        this.putInType = putInType;
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
}
