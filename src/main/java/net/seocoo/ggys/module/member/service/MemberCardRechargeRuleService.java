package net.seocoo.ggys.module.member.service;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.member.entity.MemberCardRechargeRuleDO;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRuleQuery;

import java.util.List;

/**
 * @author PanChengHao
 * @date 2018/6/1 10:42
 */
public interface MemberCardRechargeRuleService {

  /**
   * 新增会员卡充值规则
   * @param memberCardRechargeRuleDO
   * @return
   */
  int saveMemberCardRechargeRule(MemberCardRechargeRuleDO memberCardRechargeRuleDO);

  /**
   * 根据id查询商家充值规则
   * @param id
   * @return 充值规则对象
   */
  MemberCardRechargeRuleDO getMemberCardRechargeRuleById(int id);

  /**
   * 根据id更新指定属性
   * @param memberCardRechargeRuleDO
   * @return
   */
  void updateSelectiveById(MemberCardRechargeRuleDO memberCardRechargeRuleDO);
  /**
   * 删除充值规则
   * @param id
   */
  void deleteById(int id);

  /**
   * 商家充值规则分页查询
   * @param query
   * @return
   */
  PageBean<MemberCardRechargeRuleDO> listByPageQuery(MemberCardRechargeRuleQuery query);

  /**
   * 查询总数
   * @param query
   * @return
   */
  Integer countByQuery(MemberCardRechargeRuleQuery query);

  /**
   * 查询我在哪些商家没有办理会员
   * @param query
   * @return 商家充值规则对象集合
   */
  List<MemberCardRechargeRuleDO> listMemberCardRechargeRuleByDistinct(MemberCardRechargeRuleQuery query);

}
