package net.seocoo.ggys.module.member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.util.JodaDateUtil;
import net.seocoo.ggys.module.member.form.MemberCardRechargeRecordForm;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRecordQuery;
import net.seocoo.ggys.module.member.service.MemberCardRechargeRecordService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 会员卡充值记录业务类
 * @author PanChengHao
 * @date 2018/6/3 20:27
 */
@Api(value="会员卡充值记录接口类", description = "会员卡充值记录接口")
@RestController
@RequestMapping(value="/h5/memberCardRechargeRecord")
//@CrossOrigin
public class MemberCardRechargeRecordController extends BaseController{
	@Autowired
	private MemberCardRechargeRecordService memberCardRechargeRecordService;

	@PostMapping(value="/add")
	@ApiOperation(value="新增会员卡充值记录")
	public ApiResult saveMemberCardRechargeRecord(@RequestBody MemberCardRechargeRecordForm memberCardRechargeRecordForm){
		UserInfoDO userInfoDO=this.getUserInfoFromToken(this.getToken());
		memberCardRechargeRecordForm.setUserId(userInfoDO.getId());
		this.memberCardRechargeRecordService.saveMemberCardRechargeRecord(memberCardRechargeRecordForm);
		return success("保存成功");
	}

	@GetMapping(value="/{id}")
	@ApiOperation(value="查询会员卡充值记录")
	public ApiResult queryMemberCardRechargeRecord(@PathVariable(value = "id") @ApiParam(value = "主键",defaultValue = "1",required = true) int id){
		return success(this.memberCardRechargeRecordService.getMemberCardRechargeRecordById(id));
	}

	@GetMapping(value="/list")
	@ApiOperation(value="分页查询会员卡充值记录")
	public ApiResult listByPageQuery(MemberCardRechargeRecordQuery query){
		UserInfoDO userInfoDO=this.getUserInfoFromToken(this.getToken());
		query.setUserId(userInfoDO.getId());
		query.setOrderBy("recharge_date desc");
		return success(this.memberCardRechargeRecordService.listByPageQuery(query));
	}

	@PostMapping(value="/delete")
	@ApiOperation(value="删除会员卡充值记录")
	public ApiResult deleteMemberCardRechargeRecord(int id){
		this.memberCardRechargeRecordService.deleteById(id);
		return success("删除成功");
	}

	@GetMapping(value = "/getAddRechargeTotalMoney")
	@ApiOperation(value="查询会员新增储值")
	public ApiResult getAddRechargeTotalMoney(MemberCardRechargeRecordQuery query){
		if(query.getMerchantId() == null) {
			query.setMerchantId(this.getMerchantId4Token());
		}
		query.setStartDate(JodaDateUtil.getStartDate(new Date()));
		query.setEndDate(JodaDateUtil.getEndDate(new Date()));
		return success(this.memberCardRechargeRecordService.getAddRechargeTotalMoney(query));
	}
}
