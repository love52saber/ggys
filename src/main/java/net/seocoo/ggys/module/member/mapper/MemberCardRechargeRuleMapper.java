package net.seocoo.ggys.module.member.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.member.entity.MemberCardRechargeRuleDO;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRuleQuery;

import java.util.List;

public interface MemberCardRechargeRuleMapper {

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(MemberCardRechargeRuleDO record);

    /**
     * 插入指定属性
     * @param record
     * @return
     */
    int insertSelective(MemberCardRechargeRuleDO record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    MemberCardRechargeRuleDO selectByPrimaryKey(Integer id);

    /**
     * 更新指定属性
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MemberCardRechargeRuleDO record);

    /**
     * 根据id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(MemberCardRechargeRuleDO record);

    /**
     * 分页查询
     * @param query
     * @return
     */
    List<MemberCardRechargeRuleDO> listByPageQuery(MemberCardRechargeRuleQuery query);

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
    List<MemberCardRechargeRuleDO> listMemberCardRechargeRuleByDistinct(BaseQuery query);
}