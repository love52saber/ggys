package net.seocoo.ggys.module.advertisement.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.advertisement.form.AdvertisementForm;
import net.seocoo.ggys.module.advertisement.query.AdvertisementQuery;
import net.seocoo.ggys.module.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xieheng
 * @Data 2018/6/13 0013 16:34
 * @Email xieheng91@163.com
 * @Desc 广告管理
 */
@Api(value = "广告管理", description = "广告管理")
@RequestMapping(value = "/advertisement")
@RestController
public class AdvertisementController extends BaseController {
    @Autowired
    private AdvertisementService advertisementService;

    @ApiOperation(value = "pc后台广告分页列表")
    @GetMapping(value = "/pc/page")
    public ApiResult page(AdvertisementQuery advertisementQuery) {
        return success(advertisementService.pageQuery(advertisementQuery));
    }

    @ApiOperation(value = "获取广告详情")
    @GetMapping(value = "/pc/{id}")
    public ApiResult get(@PathVariable("id") Integer id) {
        return success(advertisementService.get(id));
    }

    @ApiOperation(value = "增加广告")
    @PostMapping
    public ApiResult save(@RequestBody AdvertisementForm advertisementForm) {
        advertisementService.saveByForm(advertisementForm);
        return success();
    }

    @ApiOperation(value = "修改广告")
    @PutMapping
    public ApiResult update(@RequestBody AdvertisementForm advertisementForm) {
        advertisementService.updateByFrom(advertisementForm);
        return success();
    }

    @ApiOperation(value = "果果云社h5广告展示")
    @GetMapping(value = "/h5/index")
    public ApiResult index(AdvertisementQuery advertisementQuery) {
        return success(advertisementService.listQuery(advertisementQuery));
    }


}
