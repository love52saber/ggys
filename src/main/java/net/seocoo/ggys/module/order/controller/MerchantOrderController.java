package net.seocoo.ggys.module.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;
import net.seocoo.ggys.module.order.query.MerchantOrderQuery;
import net.seocoo.ggys.module.order.service.GrouponOrderService;
import net.seocoo.ggys.module.order.service.MerchantBaseOrderService;
import net.seocoo.ggys.module.order.service.MerchantOrderGoodsService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/9 15:43
 **/
//@CrossOrigin
@RestController
@RequestMapping(value = {"/order"})
@Api(value = "订单controller", description = "订单接口")
public class MerchantOrderController extends BaseController {
    @Autowired
    private MerchantBaseOrderService merchantBaseOrderService;

    @Autowired
    private GrouponOrderService grouponOrderService;

    @ApiOperation(value = "果果云社用户端分页查询订单列表")
    @GetMapping(value = {"/h5/page"})
    public ApiResult list(MerchantOrderQuery query) {
        UserInfoDO userInfo = getUserInfoFromToken(getToken());
        query.setOrderUserId(userInfo.getId());
        return success(this.merchantBaseOrderService.listByQuery(query));
    }

    @ApiOperation(value = "果果云社用户端订单详情")
    @GetMapping(value = {"/h5/{id}/{orderType}"})
    public ApiResult get(@ApiParam(value = "订单id") @PathVariable("id") Integer baseOrderId,@ApiParam(value = "订单类型") @PathVariable("orderType") OrderTypeEnum orderType) {
        if (orderType == OrderTypeEnum.GROUPON) {
            return success(grouponOrderService.getDtoByBaseOrderId(baseOrderId));
        }
        return null;
    }

    @ApiOperation(value = "旺铺帮H5首页订单信息")
    @GetMapping(value = "/h5/index")
    public ApiResult index() {
        Integer merchantId = getMerchantId4Token();
        return success(merchantBaseOrderService.index(merchantId));
    }

}
