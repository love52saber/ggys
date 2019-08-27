package net.seocoo.ggys.module.member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.member.entity.MemberCardRechargeRuleDO;
import net.seocoo.ggys.module.member.form.MemberCardRechargeRuleForm;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRuleQuery;
import net.seocoo.ggys.module.member.service.MemberCardRechargeRuleService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 会员卡充值规则业务类
 * @author PanChengHao
 * @date 2018/6/3 13:42
 */
@Api(value = "会员卡充值规则接口类", description = "会员卡充值规则接口")
@RestController
@RequestMapping(value = "/h5/memberCardRechargeRule")
//@CrossOrigin
public class MemberCardRechargeRuleController extends BaseController {
  @Autowired
  private MemberCardRechargeRuleService memberCardRechargeRuleService;

  @PostMapping(value = "/add")
  @ApiOperation(value = "新增会员卡充值规则")
  public ApiResult saveMemberCardRechargeRule(@RequestBody @Validated MemberCardRechargeRuleForm memberCardRechargeRuleForm) {
    MemberCardRechargeRuleDO memberCardRechargeRuleDO = new MemberCardRechargeRuleDO();
    BeanUtils.copyProperties(memberCardRechargeRuleForm, memberCardRechargeRuleDO);
    UserInfoDO userInfoDO=getUserInfoFromToken(this.getToken());
    memberCardRechargeRuleDO.setCreateUserId(userInfoDO.getId());
    if(memberCardRechargeRuleDO.getMerchantId() == null) {
      memberCardRechargeRuleDO.setMerchantId(this.getMerchantId4Token());
    }
    this.memberCardRechargeRuleService.saveMemberCardRechargeRule(memberCardRechargeRuleDO);
    return success();
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "查询会员卡充值规则")
  public ApiResult getMemberCardRechargeRule(@PathVariable(value = "id") @ApiParam(value = "主键", defaultValue = "6", required = true) int id) {
    return success(this.memberCardRechargeRuleService.getMemberCardRechargeRuleById(id));
  }

  @GetMapping(value = "/list")
  @ApiOperation(value = "分页查询会员卡充值规则")
  public ApiResult listByPageQuery(MemberCardRechargeRuleQuery query) {
    if(query.getMerchantId() == null) {
      query.setMerchantId(this.getMerchantId4Token());
    }
    query.setOrderBy("sort_number");
    return success(this.memberCardRechargeRuleService.listByPageQuery(query));
  }

  @PostMapping(value = "/update")
  @ApiOperation(value = "更新会员卡充值规则")
  public ApiResult updateMemberCardRechargeRule(@RequestBody MemberCardRechargeRuleForm memberCardRechargeRuleForm,@RequestHeader String token) {
    MemberCardRechargeRuleDO memberCardRechargeRuleDO=new MemberCardRechargeRuleDO();
    BeanUtils.copyProperties(memberCardRechargeRuleForm,memberCardRechargeRuleDO);
    UserInfoDO userInfoDO=this.getUserInfoFromToken(token);
    memberCardRechargeRuleDO.setUpdateUserId(userInfoDO.getId());
    this.memberCardRechargeRuleService.updateSelectiveById(memberCardRechargeRuleDO);
    return success();
  }

  @DeleteMapping(value = "/{id}")
  @ApiOperation(value = "删除会员卡充值规则")
//  @CrossOrigin
  public ApiResult deleteMemberCardRechargeRule(@PathVariable Integer id) {
    this.memberCardRechargeRuleService.deleteById(id);
    return success("删除成功");
  }
}
