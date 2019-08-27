package net.seocoo.ggys.module.merchant.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.merchant.entity.FirstClassifyDO;
import net.seocoo.ggys.module.merchant.entity.SecondClassifyDO;
import net.seocoo.ggys.module.merchant.form.FirstClassifyForm;
import net.seocoo.ggys.module.merchant.form.SecondClassifyForm;
import net.seocoo.ggys.module.merchant.query.FirstClassifyQuery;
import net.seocoo.ggys.module.merchant.query.SecondClassifyQuery;
import net.seocoo.ggys.module.merchant.service.FirstClassifyService;
import net.seocoo.ggys.module.merchant.service.SecondClassifyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 10:07
 * @Email xieheng91@163.com
 * @Desc 行业分类控制器
 */
@Api(value = "行业分类操作",description = "行业分类操作接口")
@RequestMapping(value = {"/pc/merchantClassify", "/h5/merchantClassify"})
@RestController
public class MerchantClassifyController extends BaseController {

    @Autowired
    private FirstClassifyService firstClassifyService;

    @Autowired
    private SecondClassifyService secondClassifyService;

    /**
     * 一级分类展示
     *
     * @return
     */
    @ApiOperation(value = "一级分类列表")
//    @CrossOrigin
    @GetMapping(value = "/firstClassify")
    public ApiResult list() {
        FirstClassifyQuery firstClassifyQuery = new FirstClassifyQuery();
        firstClassifyQuery.setOrderBy("sort_number");
        return this.success(firstClassifyService.list(firstClassifyQuery));
    }


    /**
     * 删除一级分类
     *
     * @param id 一级分类主键
     * @return
     */
    @ApiOperation(value = "删除一级分类")
//    @CrossOrigin
    @DeleteMapping(value = "/firstClassify/{id}")
    public ApiResult delete(@ApiParam(value = "一级分类主键") @PathVariable("id") Integer id) {
        firstClassifyService.delete(id);
        return this.success();
    }

    /**
     * 新增一级分类
     *
     * @param firstClassifyForm
     * @return
     */
    @ApiOperation(value = "新增一级分类")
//    @CrossOrigin
    @PostMapping(value = "/firstClassify")
    public ApiResult add(@Validated @RequestBody FirstClassifyForm firstClassifyForm) {

        FirstClassifyDO firstClassifyDO = new FirstClassifyDO();
        BeanUtils.copyProperties(firstClassifyForm, firstClassifyDO);
        Boolean save = firstClassifyService.save(firstClassifyDO);
        return save ? this.success() : this.error(RequestCode.server_error, "新增失败");
    }

    /**
     * 修改一级分类
     *
     * @param firstClassifyForm
     * @return
     */
    @ApiOperation(value = "修改一级分类")
//    @CrossOrigin
    @PutMapping(value = "/firstClassify")
    public ApiResult update(@RequestBody FirstClassifyForm firstClassifyForm) {
        FirstClassifyDO firstClassifyDO = new FirstClassifyDO();
        BeanUtils.copyProperties(firstClassifyForm, firstClassifyDO);
        Boolean update = firstClassifyService.update(firstClassifyDO);
        return update ? this.success() : this.error(RequestCode.server_error, "更新失败");
    }


    /**
     * 增加二级分类
     *
     * @param secondClassifyForm
     * @return
     */
    @ApiOperation(value = "增加二级分类")
//    @CrossOrigin
    @PostMapping(value = "/secondClassify")
    public ApiResult add(@Validated@RequestBody SecondClassifyForm secondClassifyForm) {
        SecondClassifyDO secondClassifyDO = new SecondClassifyDO();
        BeanUtils.copyProperties(secondClassifyForm,secondClassifyDO);
        secondClassifyService.save(secondClassifyDO);
        return success();

    }

    /**
     * 删除二级分类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除二级分类")
//    @CrossOrigin
    @DeleteMapping(value = "/secondClassify/{id}")
    public ApiResult deleteSecondClassify(@PathVariable("id") Integer id) {
        secondClassifyService.delete(id);
        return success();
    }

    /**
     * 修改二级分类
     *
     * @param     secondClassifyForm
     * @return
     */
    @ApiOperation(value = "修改二级分类")
//    @CrossOrigin
    @PutMapping("/secondClassify")
    public ApiResult update(@Validated@RequestBody SecondClassifyForm secondClassifyForm) {
        SecondClassifyDO secondClassifyDO = new SecondClassifyDO();
        BeanUtils.copyProperties(secondClassifyForm,secondClassifyDO);
        secondClassifyService.update(secondClassifyDO);
        return success();
    }

    /**
     * 二级分类展示
     *
     * @param secondClassifyQuery
     * @return
     */

    @ApiOperation(value = "二级分类展示")
//    @CrossOrigin
    @GetMapping(value = "/secondClassify")
    public ApiResult list(SecondClassifyQuery secondClassifyQuery) {
        secondClassifyQuery.setOrderBy("sort_number");
        return this.success(secondClassifyService.list(secondClassifyQuery));
    }
}
