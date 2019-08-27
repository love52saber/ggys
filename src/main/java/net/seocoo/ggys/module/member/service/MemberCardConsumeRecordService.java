package net.seocoo.ggys.module.member.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.member.entity.MemberCardConsumeRecordDO;
import net.seocoo.ggys.module.member.entity.MemberCardInfoDO;
import net.seocoo.ggys.module.member.query.MemberCardConsumeRecordQuery;

import java.util.List;

/**
 * @author PanChengHao
 * @date 2018/6/1 15:04
 */
public interface MemberCardConsumeRecordService {
  /**
   * 新增会员卡消费记录
   * @param memberCardConsumeRecordDO
   * @return
   */
  int saveMemberCardConsumeRecord(MemberCardConsumeRecordDO memberCardConsumeRecordDO);

  /**
   * 根据id查询会员卡消费记录
   * @param id
   * @return 会员卡消费记录对象
   */
  MemberCardConsumeRecordDO getMemberCardConsumeRecordById(int id);

  /**
   * 根据id更新会员卡消费记录
   * @param memberCardConsumeRecordDO
   * @return
   */
  int updateById(MemberCardConsumeRecordDO memberCardConsumeRecordDO);

  /**
   * 根据id更新指定属性
   * @param memberCardConsumeRecordDO
   * @return
   */
  int updateSelectiveById(MemberCardConsumeRecordDO memberCardConsumeRecordDO);
  /**
   * 删除会员卡信息
   * @param id
   */
  void deleteById(int id);

  /**
   * 会员卡信息分页查询
   * @param query
   * @return
   */
  PageBean<MemberCardConsumeRecordDO> listByPageQuery(MemberCardConsumeRecordQuery query);

  /**
   * 查询总数
   * @param query
   * @return
   */
  Integer countByQuery(MemberCardConsumeRecordQuery query);

  /**
   * 根据userId分组查询商家信息
   * @param query
   * @return
   */
  PageBean<MemberCardConsumeRecordDO> listByPageQueryGroupByMerchantId(MemberCardConsumeRecordQuery query);

  /**
   * 查询分组总数
   * @param query
   * @return
   */
  Integer countByPageQueryGroupByMerchantId(MemberCardConsumeRecordQuery query);
}
