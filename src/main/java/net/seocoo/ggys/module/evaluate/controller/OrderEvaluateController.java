package net.seocoo.ggys.module.evaluate.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.util.JodaDateUtil;
import net.seocoo.ggys.module.evaluate.entity.OrderEvaluateDO;
import net.seocoo.ggys.module.evaluate.form.OrderEvaluateForm;
import net.seocoo.ggys.module.evaluate.query.OrderEvaluateQuery;
import net.seocoo.ggys.module.evaluate.service.OrderEvaluateService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

/**
 * 订单评价控制层
 *
 * @author PanChengHao
 * @date 2018/6/13 17:36
 */
@Api(value = "订单评价接口", description = "订单评价接口")
@RestController
@RequestMapping(value = "/h5/evaluate")
//@CrossOrigin
public class OrderEvaluateController extends BaseController {

  @Autowired
  private OrderEvaluateService orderEvaluateService;

  @PostMapping(value = "/add")
  @ApiOperation(value = "新增订单评价")
  public ApiResult saveEvaluate(@RequestBody OrderEvaluateForm evaluateForm) {
    UserInfoDO userInfoDO = getUserInfoFromToken(this.getToken());
    OrderEvaluateDO orderEvaluateDO = new OrderEvaluateDO();
    BeanUtils.copyProperties(evaluateForm, orderEvaluateDO);
    orderEvaluateDO.setUserId(userInfoDO.getId());
    orderEvaluateService.saveOrderEvaluate(orderEvaluateDO);
    return success();
  }

  @GetMapping(value = "/list")
  @ApiOperation(value = "分页查询订单评价列表")
  public ApiResult listByPageQuery(OrderEvaluateQuery query) {
    if (query.getMerchantId() == null) {
      query.setMerchantId(this.getMerchantId4Token());
    }
    query.setOrderBy("create_date desc");
    return success(this.orderEvaluateService.listByPageQuery(query));
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "根据id查询订单评价")
  public ApiResult getEvaluate(@PathVariable(value = "id") @ApiParam(value = "主键", defaultValue = "2", required = true) int id) {
    return success(this.orderEvaluateService.getOrderEvaluateById(id));
  }

  @GetMapping(value = "/listRecently7Days")
  @ApiOperation(value = "查询近7天的评价")
  public ApiResult listRecently7Days(OrderEvaluateQuery query) {
    if (query.getMerchantId() == null) {
      query.setMerchantId(this.getMerchantId4Token());
    }
    Calendar c = Calendar.getInstance();
    //过去七天
    c.setTime(new Date());
    c.add(Calendar.DATE, -6);
    query.setStartDate(JodaDateUtil.getStartDate(c.getTime()));
    query.setEndDate(JodaDateUtil.getEndDate(new Date()));
    query.setOrderBy("create_date desc");
    return success(this.orderEvaluateService.listByPageQuery(query));
  }
}
