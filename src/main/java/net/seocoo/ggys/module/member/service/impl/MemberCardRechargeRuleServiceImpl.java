package net.seocoo.ggys.module.member.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.member.entity.MemberCardRechargeRuleDO;
import net.seocoo.ggys.module.member.exception.MemberCardException;
import net.seocoo.ggys.module.member.mapper.MemberCardRechargeRuleMapper;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRuleQuery;
import net.seocoo.ggys.module.member.service.MemberCardRechargeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author PanChengHao
 * @date 2018/6/1 11:06
 */
@Service
public class MemberCardRechargeRuleServiceImpl extends BaseService implements MemberCardRechargeRuleService {

  @Autowired
  private MemberCardRechargeRuleMapper memberCardRechargeRuleMapper;

  /**
   * 保存会员卡充值规则
   * @param memberCardRechargeRuleDO
   * @return
   */
  @Override
  public int saveMemberCardRechargeRule(MemberCardRechargeRuleDO memberCardRechargeRuleDO) {
    insertSetDefaultValue(memberCardRechargeRuleDO);
    return this.memberCardRechargeRuleMapper.insert(memberCardRechargeRuleDO);
  }

  @Override
  public MemberCardRechargeRuleDO getMemberCardRechargeRuleById(int id) {
    return this.memberCardRechargeRuleMapper.selectByPrimaryKey(id);
  }

  @Override
  public PageBean<MemberCardRechargeRuleDO> listByPageQuery(MemberCardRechargeRuleQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());
    List<MemberCardRechargeRuleDO> memberCardRechargeRuleDOList = this.memberCardRechargeRuleMapper.listByPageQuery(query);
    return new PageBean<>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), memberCardRechargeRuleDOList);
  }

  @Override
  public Integer countByQuery(MemberCardRechargeRuleQuery query) {
    return this.memberCardRechargeRuleMapper.countByQuery(query);
  }

  @Override
  public void updateSelectiveById(MemberCardRechargeRuleDO memberCardRechargeRuleDO) {
    MemberCardRechargeRuleDO record=this.memberCardRechargeRuleMapper.selectByPrimaryKey(memberCardRechargeRuleDO.getId());
    if(record == null){
      throw new MemberCardException("ID="+memberCardRechargeRuleDO.getId()+"的会员卡充值规则不存在", RequestCode.server_error);
    }
    memberCardRechargeRuleDO.setUpdateDate(new Date());
    this.memberCardRechargeRuleMapper.updateByPrimaryKeySelective(memberCardRechargeRuleDO);
  }

  @Override
  public void deleteById(int id) {
    MemberCardRechargeRuleDO memberCardRechargeRuleDO=this.memberCardRechargeRuleMapper.selectByPrimaryKey(id);
    if(memberCardRechargeRuleDO == null){
      throw new MemberCardException("ID="+id+"的会员卡充值规则不存在",RequestCode.server_error);
    }
    memberCardRechargeRuleDO.setCanDeleted(YesNoEnum.Y);
    this.memberCardRechargeRuleMapper.updateByPrimaryKeySelective(memberCardRechargeRuleDO);
  }

  /**
   * 查询我在哪些商家没有办理会员
   * @param query
   * @return 商家充值规则对象集合
   */
  @Override
  public List<MemberCardRechargeRuleDO> listMemberCardRechargeRuleByDistinct(MemberCardRechargeRuleQuery query) {
    List<MemberCardRechargeRuleDO> memberCardRechargeRuleDOList=this.memberCardRechargeRuleMapper.listMemberCardRechargeRuleByDistinct(query);
    return memberCardRechargeRuleDOList;
  }

}
