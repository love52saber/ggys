package net.seocoo.ggys.module.merchant.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.merchant.form.LabelForm;
import net.seocoo.ggys.module.merchant.service.MerchantLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xieheng
 * @Data 2018/6/20 0020 10:04
 * @Email xieheng91@163.com
 * @Desc 商户标签
 */
@Api(value = "商户标签", description = "商户标签")
@RestController(value = "/merchant")
public class MerchantLabelController extends BaseController {

    @Autowired
    private MerchantLabelService merchantLabelService;

    @ApiOperation(value = "商户标签新增")
    @PostMapping(value = "/h5/label")
    public ApiResult add(@Validated @RequestBody LabelForm labelForm) {
        merchantLabelService.saveLimitCheck(labelForm);
        return success();
    }

    @ApiOperation(value = "商户标签删除")
    @DeleteMapping(value = "/{merchantId}/h5/label/{id}")
    public ApiResult delete(@ApiParam(value = "商户主键") @PathVariable("merchantId") Integer merchantId,
                            @ApiParam(value = "标签主键") @PathVariable("id") Integer id) {
        merchantLabelService.delete(merchantId,id);
        return success();
    }

    @ApiOperation(value = "商户对应的标签查询")
    @GetMapping(value = "/h5/{merchantId}/label")
    public ApiResult getByMerchantId(@ApiParam(value = "商户id") @PathVariable("merchantId") Integer merchantId) {
        return success(merchantLabelService.listByMerchantId(merchantId));
    }
}
