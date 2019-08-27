package net.seocoo.ggys.module.merchant.query;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.constants.UserRoleEnum;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/30 0030 17:59
 * @Email xieheng91@163.com
 * @Desc 商户查询对象
 */
@ApiModel(value = "商户查询条件")
public class MerchantQuery extends BaseQuery {

    private String name;

    private Integer provinceId;

    private Integer cityId;

    private Integer countyId;

    private Integer businessAreaId;

    private Integer merchantUserId;

    private Integer manageUserId;

    private UserRoleEnum userRole;



    private Integer firstClassifyId;

    private Integer secondClassifyId;

    private List<Integer> idList;

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public Integer getFirstClassifyId() {
        return firstClassifyId;
    }

    public void setFirstClassifyId(Integer firstClassifyId) {
        this.firstClassifyId = firstClassifyId;
    }

    public Integer getSecondClassifyId() {
        return secondClassifyId;
    }

    public void setSecondClassifyId(Integer secondClassifyId) {
        this.secondClassifyId = secondClassifyId;
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public Integer getBusinessAreaId() {
        return businessAreaId;
    }

    public void setBusinessAreaId(Integer businessAreaId) {
        this.businessAreaId = businessAreaId;
    }

    public Integer getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(Integer merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public Integer getManageUserId() {
        return manageUserId;
    }

    public void setManageUserId(Integer manageUserId) {
        this.manageUserId = manageUserId;
    }
}
