package net.seocoo.ggys.module.member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.member.entity.MemberCardConsumeRecordDO;
import net.seocoo.ggys.module.member.form.MemberCardConsumeRecordForm;
import net.seocoo.ggys.module.member.query.MemberCardConsumeRecordQuery;
import net.seocoo.ggys.module.member.service.MemberCardConsumeRecordService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 会员卡消费记录业务类
 * @author PanChengHao
 * @date 2018/6/4 14:22
 */
@Api(value="会员卡消费记录接口类", description = "会员卡消费记录接口")
@RestController
@RequestMapping(value="/h5/memberCardConsumeRecord")
//@CrossOrigin
public class MemberCardConsumeRecordController extends BaseController {
  @Autowired
  private MemberCardConsumeRecordService memberCardConsumeRecordService;

  @PostMapping(value="/add")
  @ApiOperation(value="新增会员卡消费记录")
  public ApiResult saveMemberCardConsumeRecord(@RequestBody MemberCardConsumeRecordForm memberCardConsumeRecordForm){
    UserInfoDO userInfoDO=this.getUserInfoFromToken(this.getToken());
    MemberCardConsumeRecordDO memberCardConsumeRecordDO=new MemberCardConsumeRecordDO();
    BeanUtils.copyProperties(memberCardConsumeRecordForm,memberCardConsumeRecordDO);
    memberCardConsumeRecordDO.setUserId(userInfoDO.getId());
    this.memberCardConsumeRecordService.saveMemberCardConsumeRecord(memberCardConsumeRecordDO);
    return success("保存成功");
  }

  @GetMapping(value="/{id}")
  @ApiOperation(value="查询会员卡消费记录")
  public ApiResult queryMemberCardConsumeRecord(@PathVariable(value = "id") @ApiParam(value = "主键",defaultValue = "3",required = true) int id){
    return success(this.memberCardConsumeRecordService.getMemberCardConsumeRecordById(id));
  }

  @GetMapping(value="/list")
  @ApiOperation(value="分页查询会员卡消费记录")
  public ApiResult listByPageBean(MemberCardConsumeRecordQuery query){
    UserInfoDO userInfoDO=this.getUserInfoFromToken(this.getToken());
    query.setUserId(userInfoDO.getId());
    query.setOrderBy("consume_date desc");
    return success(this.memberCardConsumeRecordService.listByPageQuery(query));
  }

  @PostMapping(value="/delete")
  @ApiOperation(value="删除会员卡消费记录")
  public  ApiResult deleteMemberCardConsumeRecord(int id){
    this.memberCardConsumeRecordService.deleteById(id);
    return success();
  }
}
