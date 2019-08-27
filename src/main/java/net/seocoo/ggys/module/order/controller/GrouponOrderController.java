package net.seocoo.ggys.module.order.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;
import net.seocoo.ggys.module.order.dto.OrderListDTO;
import net.seocoo.ggys.module.order.form.GrouponOrderForm;
import net.seocoo.ggys.module.order.query.MerchantOrderQuery;
import net.seocoo.ggys.module.order.service.GrouponOrderService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/7 16:24
 **/

//@CrossOrigin
@RestController
@RequestMapping(value = {"/order/groupon"})
@Api(value = "团购订单controller")
public class GrouponOrderController extends BaseController {

  @Autowired
  private GrouponOrderService grouponOrderService;


  @ApiOperation(value = "旺铺帮h5后台团购订单提交")
  @PostMapping("/h5")
  public ApiResult saveGrouponOrder(@RequestBody GrouponOrderForm grouponOrderForm) {
    UserInfoDO userInfo = this.getUserInfoFromToken(this.getToken());
    this.grouponOrderService.save(grouponOrderForm, userInfo);
    return success();
  }

  @ApiOperation(value = "团购订单列表")
  @GetMapping(value = {"/h5/page","/pc/page"})
  public ApiResult page(MerchantOrderQuery orderQuery){
      Integer merchantId = this.getMerchantId4Token();
      orderQuery.setMerchantId(merchantId);
      orderQuery.setOrderType(OrderTypeEnum.GROUPON);
      return  success(grouponOrderService.page(orderQuery));
  }

  @ApiOperation(value = "后台团购订单更改状态")
  @PutMapping(value = {"/h5/state","/pc/state"})
  public ApiResult updateState(@RequestBody GrouponOrderForm grouponOrderForm){
    grouponOrderService.updateOrderState(grouponOrderForm);
    return success();
  }

  @ApiOperation(value = "团购订单详情")
  @GetMapping(value = {"/h5/{id}","/pc/{id}"})
  public ApiResult get(@PathVariable("id") Integer baseOrderId){
    return success(grouponOrderService.getDtoByBaseOrderId(baseOrderId));
  }

}
