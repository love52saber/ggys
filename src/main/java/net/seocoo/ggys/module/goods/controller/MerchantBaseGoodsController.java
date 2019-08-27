package net.seocoo.ggys.module.goods.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.goods.form.GoodsAuditForm;
import net.seocoo.ggys.module.goods.query.MerchantBaseGoodsQuery;
import net.seocoo.ggys.module.goods.service.MerchantBaseGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xieheng
 * @Data 2018/6/6 0006 11:46
 * @Email xieheng91@163.com
 * @Desc 商品控制器
 */
@Api(value = "pc后台商品操作" ,description = "pc后台商品接口")
@RequestMapping(value = {"/pc/goods"})
@RestController
public class MerchantBaseGoodsController extends BaseController {
    @Autowired
    private MerchantBaseGoodsService merchantBaseGoodsService;


    @ApiOperation(value = "商品分页展示")
//    @CrossOrigin
    @GetMapping("/page")
    public ApiResult page(MerchantBaseGoodsQuery merchantBaseGoodsQuery) {
        Integer merchantId = this.getMerchantId4Token();
        merchantBaseGoodsQuery.setMerchantId(merchantId);
        return success(merchantBaseGoodsService.page(merchantBaseGoodsQuery));
    }

    @ApiOperation(value = "商品审核操作")
//    @CrossOrigin
    @PutMapping(value = "/audit")
    public ApiResult audit(@RequestBody GoodsAuditForm goodsAuditForm) {
        merchantBaseGoodsService.auditGoods(goodsAuditForm);
        return success();
    }

    @ApiOperation(value = "商品详情")
//    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ApiResult get(@PathVariable("id") Integer id){
        return success(merchantBaseGoodsService.get(id));
    }

}
