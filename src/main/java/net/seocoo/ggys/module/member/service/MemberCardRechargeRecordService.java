package net.seocoo.ggys.module.member.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.member.entity.MemberCardRechargeRecordDO;
import net.seocoo.ggys.module.member.form.MemberCardRechargeRecordForm;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRecordQuery;

import java.math.BigDecimal;

/**
 * @author PanChengHao
 * @date 2018/6/1 14:49
 */
public interface MemberCardRechargeRecordService {
  /**
   * 新增会员卡充值记录
   * @param memberCardRechargeRecordForm
   * @return
   */
  void saveMemberCardRechargeRecord(MemberCardRechargeRecordForm memberCardRechargeRecordForm);

  /**
   * 保存会员卡充值记录
   * @param memberCardIRechargeRecordDO
   */
  void saveMemberCardRechargeRecord(MemberCardRechargeRecordDO memberCardIRechargeRecordDO);

  /**
   * 根据id查询会员卡充值记录
   * @param id
   * @return 会员卡充值记录对象
   */
  MemberCardRechargeRecordDO getMemberCardRechargeRecordById(int id);

  /**
   * 根据id更新会员卡充值记录
   * @param memberCardIRechargeRecordDO
   * @return
   */
  int updateById(MemberCardRechargeRecordDO memberCardIRechargeRecordDO);

  /**
   * 根据id更新指定属性
   * @param memberCardIRechargeRecordDO
   * @return
   */
  void updateSelectiveById(MemberCardRechargeRecordDO memberCardIRechargeRecordDO);
  /**
   * 删除会员卡充值记录
   * @param id
   */
  void deleteById(int id);

  /**
   * 会员卡充值记录分页查询
   * @param query
   * @return
   */
  PageBean<MemberCardRechargeRecordDO> listByPageQuery(MemberCardRechargeRecordQuery query);

  /**
   * 查询总数
   * @param query
   * @return
   */
  Integer countByQuery(MemberCardRechargeRecordQuery query);

  /**
   * 查询商家今日新增储值
   * @param query
   * @return
   */
  BigDecimal getAddRechargeTotalMoney(MemberCardRechargeRecordQuery query);
}
