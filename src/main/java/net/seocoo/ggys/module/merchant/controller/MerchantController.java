package net.seocoo.ggys.module.merchant.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.constants.UserRoleEnum;
import net.seocoo.ggys.module.merchant.entity.MerchantDO;
import net.seocoo.ggys.module.merchant.form.MerchantForm;
import net.seocoo.ggys.module.merchant.query.MerchantQuery;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xieheng
 * @Data 2018/5/29 0029 14:45
 * @Email xieheng91@163.com
 * @Desc 商户控制器
 */
@RequestMapping(value = {"/pc/merchant", "/h5/merchant"})
@RestController
@Api(value = "商户操作", description = "商户操作接口")
//@CrossOrigin
public class MerchantController extends BaseController {

    @Autowired
    private MerchantService merchantService;


    /*@ApiOperation(value = "获取当前登录商户")
    @GetMapping(value = "/current")
    public ApiResult get() {
        UserInfoDO userInfo = getUserInfoFromToken(getToken());
        return success(merchantService.getMerchantByUserId(userInfo.getId()));
    }*/

    /**
     * 增加商户信息
     *
     * @param merchantForm
     * @return
     */
    @ApiOperation(value = "新增商户")
    @PostMapping
    public ApiResult add(@Validated @RequestBody MerchantForm merchantForm) {
        merchantService.save(merchantForm);
        return success();
    }

    /**
     * 商户信息暂时进行逻辑删除,后续完善
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除商户")
    @DeleteMapping(value = "/{id}")
    public ApiResult delete(@ApiParam(value = "商户主键id") @PathVariable("id") Integer id) {
        UserInfoDO userInfo = getUserInfoFromToken(getToken());
        if (!userInfo.getUserRole().equals(UserRoleEnum.MANAGE)) {
            return error(RequestCode.forbid_error, "无管理员权限操作");
        }
        merchantService.delete(id);
        return success();
    }

    /**
     * 修改商户信息
     *
     * @param merchantForm
     * @return
     */
    @ApiOperation(value = "修改商户信息")
    @PutMapping
    public ApiResult update(@Validated @RequestBody MerchantForm merchantForm) {
        merchantService.update(merchantForm);
        return success();
    }

    /**
     * 查询商户详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取单个商户信息")
    @GetMapping(value = "/{id}")
    public ApiResult get(@PathVariable("id") Integer id) {
        UserInfoDO currUser = getUserInfoFromToken(getToken());
        return this.success(merchantService.get(id,currUser));
    }

    /**
     * 查询商户列表
     *
     * @param merchantQuery
     * @return
     */
    @ApiOperation(value = "根据条件获取商户列表")
    @GetMapping()
    public ApiResult list(MerchantQuery merchantQuery) {
        merchantQuery.setOrderBy("id desc");
        return this.success(merchantService.list(merchantQuery));
    }

    /**
     * 分页列表
     *
     * @param merchantQuery
     * @return
     */
    @ApiOperation(value = "根据条件获取商户分页")
    @GetMapping(value = "/page")
    public ApiResult page(MerchantQuery merchantQuery) {
        UserInfoDO userInfo = getUserInfoFromToken(getToken());
        merchantQuery.setOrderBy("id desc");
        switch (userInfo.getUserRole()) {
            case MERCHANT:
                merchantQuery.setMerchantUserId(userInfo.getId());
                break;
            case CHIEF:
                merchantQuery.setManageUserId(userInfo.getId());
                break;
            case NORMAL:
                return this.error(RequestCode.forbid_error, "该用户是非商户");
        }
        return this.success(merchantService.page(merchantQuery));
    }


    @ApiOperation(value = "通过商户主键获取商户功能")
    @GetMapping(value = "/function/{id}")
    public ApiResult getFunction(@ApiParam(value = "商户主键") @PathVariable("id") Integer id) {
        return success(merchantService.getFunction(id));
    }

    @ApiOperation(value = "果果云社客户商家集合")
    @GetMapping(value = "/c/index")
    public ApiResult h5MerchantList(MerchantQuery query) {

        UserInfoDO userInfo = this.getUserInfoFromToken(this.getToken());
        //TODO 部署在微信上后，从微信获取
        // userInfo.setToken("123456789");
//        if(userInfo == null) {
//        userInfo = new UserInfoDO();
//        userInfo.setLat(31.82132);
//        userInfo.setLng(117.34324);
//        }
        if(query.getCityId() == null) {
            query.setCityId(1131);
        }
        return success(merchantService.listClientH5Index(query, userInfo));
    }
}
