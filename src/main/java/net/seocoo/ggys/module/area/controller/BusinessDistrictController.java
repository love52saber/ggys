package net.seocoo.ggys.module.area.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.area.entity.BusinessDistrictDO;
import net.seocoo.ggys.module.area.form.BusinessDistrictForm;
import net.seocoo.ggys.module.area.query.BusinessDistrictQuery;
import net.seocoo.ggys.module.area.service.BusinessDistrictService;
import net.seocoo.ggys.module.member.exception.MemberCardException;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商圈控制层
 *
 * @author PanChengHao
 * @date 2018/6/5 17:19
 */
@Api(value = "商圈接口", description = "商圈接口")
@RestController
@RequestMapping(value = "/pc/businessDistrict")
//@CrossOrigin
public class BusinessDistrictController extends BaseController {
  @Autowired
  private BusinessDistrictService businessDistrictService;

  @PostMapping(value = "/add")
  @ApiOperation(value = "新增商圈")
  public ApiResult saveBusinessDistrict(@RequestBody BusinessDistrictForm businessDistrictForm, @RequestHeader String token) {
    UserInfoDO userInfoDO = this.getUserInfoFromToken(token);
    BusinessDistrictDO record = new BusinessDistrictDO();
    BeanUtils.copyProperties(businessDistrictForm, record);
    record.setCreateUserId(userInfoDO.getId());
    int row = this.businessDistrictService.insert(record);
    return row == 1 ? success() : this.error(RequestCode.server_error, "新增失败");
  }

  @GetMapping(value = "/list")
  @ApiOperation(value = "分页查询商圈列表")
  public ApiResult listByPageBean(BusinessDistrictQuery query) {
    return success(this.businessDistrictService.listByPageQuery(query));
  }

  @PostMapping(value = "/update")
  @ApiOperation(value = "更新商圈")
  public ApiResult updateBusinessDistrict(@RequestBody BusinessDistrictForm businessDistrictForm, @RequestHeader String token) {
    UserInfoDO userInfoDO = this.getUserInfoFromToken(token);
    BusinessDistrictDO businessDistrictDO = new BusinessDistrictDO();
    BeanUtils.copyProperties(businessDistrictForm, businessDistrictDO);
    businessDistrictDO.setUpdateUserId(userInfoDO.getId());
    int row = this.businessDistrictService.updateByPrimaryKeySelective(businessDistrictDO);
    return row == 1 ? success() : this.error(RequestCode.server_error, "更新失败");
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "查询商圈")
  public ApiResult getBusinessDistrict(@PathVariable("id") @ApiParam(value = "主键", defaultValue = "2", required = true) int id) {
    return success(this.businessDistrictService.selectByPrimaryKey(id));
  }

  @DeleteMapping(value = "/delete/{id}")
  @ApiOperation(value = "删除商圈")
  public ApiResult deleteBusinessDistrict(@PathVariable int id) {
    this.businessDistrictService.deleteBusinessDistrict(id);
    return success();
  }
}
