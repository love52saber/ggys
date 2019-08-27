package net.seocoo.ggys.module.groupon.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.exception.AppException;
import net.seocoo.ggys.module.groupon.entity.MerchantGrouponGoodsDTO;
import net.seocoo.ggys.module.groupon.form.GrouponGoodsForm;
import net.seocoo.ggys.module.groupon.query.MerchantGrouponGoodsQuery;
import net.seocoo.ggys.module.groupon.service.GrouponService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

/**
 * @Author xieheng
 * @Data 2018/6/7 0007 14:01
 * @Email xieheng91@163.com
 * @Desc 团购商品控制器
 */
@Api(value = "团购商品管理",description = "h5团购商品接口")
@RequestMapping(value = {"/h5/grouponGoods"})
@RestController
public class GrouponGoodsController extends BaseController {

    private final static Pattern p = Pattern.compile("&nbsp;");

    @Autowired
    private GrouponService grouponService;

    @ApiOperation(value = "团购商品增加")
    @PostMapping
    public ApiResult add(@Validated @RequestBody GrouponGoodsForm grouponGoodsForm, @RequestHeader String token){
        if(p.matcher(grouponGoodsForm.getRemark()).replaceAll(" ").length()>400){
           return  error(RequestCode.Form_Validate_Error,"商品描述字符不能超过400");
        }
        UserInfoDO userInfo = getUserInfoFromToken(token);
        grouponService.save(grouponGoodsForm,userInfo.getId());
        return  success();
    }

    @ApiOperation(value = "团购商品删除")
    @DeleteMapping(value = "/{id}")
    public ApiResult delete(@ApiParam(value = "商品id") @PathVariable("id") Integer id){
        grouponService.delete(id);
        return success();
    }

    @ApiOperation(value = "团购商品修改")
    @PutMapping
    public ApiResult update(@Validated @RequestBody GrouponGoodsForm grouponGoodsForm){
        grouponService.update(grouponGoodsForm);
        return  success();
    }

    @ApiOperation(value = "团购商品列表")
    @GetMapping
    public ApiResult list(MerchantGrouponGoodsQuery grouponTemplateQuery,@RequestHeader String token){
        UserInfoDO userInfo = getUserInfoFromToken(token);
        return success(grouponService.page(grouponTemplateQuery,userInfo.getId()));
    }

    @ApiOperation(value = "获取单个团购商品详情")
    @GetMapping(value = "/{id}")
    public ApiResult get(@ApiParam(value = "商品主键id") @PathVariable("id") Integer id){
        return success(grouponService.get(id));
    }

}
