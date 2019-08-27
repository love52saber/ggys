package net.seocoo.ggys.module.member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.member.entity.MemberCardImageDO;
import net.seocoo.ggys.module.member.exception.MemberCardException;
import net.seocoo.ggys.module.member.form.MemberCardImageForm;
import net.seocoo.ggys.module.member.service.MemberCardImageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author PanChengHao
 * @date 2018/6/15 18:00
 */
@Api(value = "会员卡图片与说明接口", description = "会员卡图片与说明接口")
@RestController
@RequestMapping(value = "/h5/memberCardImage")
//@CrossOrigin
public class MemberCardImageController extends BaseController {
  @Autowired
  private MemberCardImageService memberCardImageService;

  @PostMapping(value = "/addOrUpdate")
  @ApiOperation(value = "新增或更新会员卡图片与说明 H5后台用")
  public ApiResult saveMemberCardImage(@RequestBody MemberCardImageForm memberCardImageForm) {
    MemberCardImageDO memberCardImageDO = new MemberCardImageDO();
    BeanUtils.copyProperties(memberCardImageForm, memberCardImageDO);
    Integer merchantId=memberCardImageForm.getMerchantId();
    if(merchantId==null){
      merchantId=getMerchantId4Token();
      if(merchantId==null){
        throw new MemberCardException("登录账号不是商家，无法进行此操作", RequestCode.Operate_Tip);
      }
    }
    memberCardImageDO.setMerchantId(merchantId);
    this.memberCardImageService.saveMemberCardImage(memberCardImageDO);
    return success();
  }

  @GetMapping(value = "/getByMerchantId/{merchantId}")
  @ApiOperation(value = "根据merchantId获取会员卡图片与说明，h5前台用")
  public ApiResult getMemberCardImageByMerchantId(@PathVariable(value = "merchantId") @ApiParam(value = "商户id", defaultValue = "2", required = true) Integer merchantId) {
    return success(this.memberCardImageService.getMemberCardImageByMerchantId(merchantId));
  }

  @GetMapping(value = "/get")
  @ApiOperation(value = "获取会员卡图片与说明，h5后台用")
  public ApiResult getMemberCardImage() {
    return success(memberCardImageService.getMemberCardImageByMerchantId(getMerchantId4Token()));
  }
}
