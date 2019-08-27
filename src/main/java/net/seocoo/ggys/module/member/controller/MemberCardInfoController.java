package net.seocoo.ggys.module.member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.util.JodaDateUtil;
import net.seocoo.ggys.module.member.dto.MemberCardInfoListDTO;
import net.seocoo.ggys.module.member.form.MemberCardForm;
import net.seocoo.ggys.module.member.entity.MemberCardInfoDO;
import net.seocoo.ggys.module.member.query.MemberCardConsumeRecordQuery;
import net.seocoo.ggys.module.member.query.MemberCardInfoQuery;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRuleQuery;
import net.seocoo.ggys.module.member.service.MemberCardInfoService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员卡信息业务类
 * @author PanChengHao
 * @date 2018/6/1 9:56
 */
@Api(value = "会员卡信息接口类", description = "会员卡信息接口")
@RestController
@RequestMapping(value = "/h5/memberCardInfo")
//@CrossOrigin
public class MemberCardInfoController extends BaseController {
  @Autowired
  private MemberCardInfoService memberCardInfoService;

  @PostMapping(value = "/add")
  @ApiOperation(value = "新增会员卡信息")
  public ApiResult saveMemberCardInfo(@RequestBody  @Validated MemberCardForm memberCard) {
    UserInfoDO userInfoDO = this.getUserInfoFromToken(this.getToken());
    memberCard.setUserId(userInfoDO.getId());
    memberCardInfoService.saveMemberCardInfo(memberCard);
    return success();
  }

  @GetMapping(value = "/list")
  @ApiOperation(value = "分页查询会员卡信息")
  public ApiResult listByPageQuery(MemberCardInfoQuery query) {
    if(query.getMerchantId() == null) {
      query.setMerchantId(this.getMerchantId4Token());
    }
    query.setOrderBy("create_date desc");
    PageBean<MemberCardInfoListDTO> pageBean = this.memberCardInfoService.listByPageQuery(query);
    return success(pageBean);
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "查询会员卡信息")
  public ApiResult queryMemberCardInfo(@PathVariable("id") @ApiParam(value = "主键", defaultValue = "8", required = true) int id) {
    return success(memberCardInfoService.getMemberCardInfoById(id));
  }

  @PostMapping(value = "/update")
  @ApiOperation(value = "更新会员卡信息")
  public ApiResult updateMemberCardInfoSelective(@RequestBody MemberCardInfoDO memberCardInfoDO) {
    UserInfoDO userInfoDO = this.getUserInfoFromToken(this.getToken());
    memberCardInfoDO.setUserId(userInfoDO.getId());
    memberCardInfoService.updateSelectiveById(memberCardInfoDO);
    return success();
  }

  @PostMapping(value = "/delete")
  @ApiOperation(value = "删除会员卡信息")
  public ApiResult deleteMemberCardInfo(int id) {
    memberCardInfoService.deleteById(id);
    return success("删除成功");
  }

  @GetMapping(value = "/count")
  @ApiOperation(value = "获取商家会员卡数量")
  public ApiResult countMemberCardInfo(MemberCardInfoQuery query) {
    if(query.getMerchantId() == null) {
      query.setMerchantId(this.getMerchantId4Token());
    }
    query.setStartDate(JodaDateUtil.getStartDate(new Date()));
    query.setEndDate(new Date());
    return success(memberCardInfoService.countByQuery(query));
  }

  @GetMapping(value = "/getMemberCardInfo")
  @ApiOperation(value="根据userId,merchantId获取会员卡信息")
  public ApiResult getMemberCardInfoByUserIdMerchantId(Integer merchantId){
    UserInfoDO userInfoDO = this.getUserInfoFromToken(this.getToken());
    return success(this.memberCardInfoService.selectMemberCardInfoByUserIdMerchantId(userInfoDO.getId(),merchantId));
  }

  @GetMapping(value = "/canUsed")
  @ApiOperation(value="查询会员卡消费是否可用")
  public ApiResult canUsedMemberCardInfo(Integer id,BigDecimal consumeMoney){
    return success(this.memberCardInfoService.canUsedMemberCardInfo(id,consumeMoney));
  }

  @GetMapping(value = "/listMemberCardInfo")
  @ApiOperation(value = "获取我已办卡的商家列表并按距离排序,对应距离最近")
  public ApiResult listMemberCardInfo(BaseQuery query){
    UserInfoDO userInfoDO=getUserInfoFromToken(this.getToken());
    //测试用
    /*userInfoDO.setLat(31.863397);
    userInfoDO.setLng(117.286156);*/
    return success(this.memberCardInfoService.selectListMemberCardInfoByUserId(userInfoDO,query));
  }

  @GetMapping(value = "/listRecentlyConsumeMemberCardInfo")
  @ApiOperation(value = "获取最近会员卡消费列表，对应最近消费")
  public ApiResult listRecentlyConsumeMemberCardInfo(MemberCardConsumeRecordQuery query){
    UserInfoDO userInfoDO=getUserInfoFromToken(this.getToken());
    query.setUserId(userInfoDO.getId());
    return success(this.memberCardInfoService.selectListRecentlyConsumeMemberCardInfo(query));
  }

  @GetMapping(value = "/listMemberMerchant")
  @ApiOperation(value = "获取我没有办会员卡的商家列表，对应办理新卡")
  public ApiResult listMerchantByRechargeRule(MemberCardRechargeRuleQuery query){
    UserInfoDO userInfoDO=getUserInfoFromToken(this.getToken());
    //测试用
    /*userInfoDO.setLat(31.863397);
    userInfoDO.setLng(117.286156);*/
    return success(this.memberCardInfoService.selectMemberMerchantList(userInfoDO,query));
  }
}
