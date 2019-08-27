package net.seocoo.ggys.module.member.service;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.member.dto.MemberCardInfoListDTO;
import net.seocoo.ggys.module.member.dto.MemberMerchantListDTO;
import net.seocoo.ggys.module.member.form.MemberCardForm;
import net.seocoo.ggys.module.member.entity.MemberCardInfoDO;
import net.seocoo.ggys.module.member.query.MemberCardConsumeRecordQuery;
import net.seocoo.ggys.module.member.query.MemberCardInfoQuery;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRuleQuery;
import net.seocoo.ggys.module.merchant.dto.H5CMerchantBaseDTO;
import net.seocoo.ggys.module.user.entity.UserInfoDO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author PanChengHao
 * @date 2018/6/1 10:39
 */
public interface MemberCardInfoService {

  /**
   * 新增会员卡信息
   * @param memberCard
   * @return
   */
  void saveMemberCardInfo(MemberCardForm memberCard);

  /**
   * 根据id查询会员信息
   * @param id
   * @return 会员信息对象
   */
  MemberCardInfoDO getMemberCardInfoById(int id);

  /**
   * 根据id更新会员卡信息
   * @param memberCardInfoDO
   * @return
   */
  int updateById(MemberCardInfoDO memberCardInfoDO);

  /**
   * 更新指定属性
   * @param memberCardInfoDO
   * @return
   */
  void updateSelectiveById(MemberCardInfoDO memberCardInfoDO);
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
  PageBean<MemberCardInfoListDTO> listByPageQuery(MemberCardInfoQuery query);

  /**
   * 查询总数
   * @param query
   * @return
   */
  Integer countByQuery(MemberCardInfoQuery query);

  /**
   * 根据memberCardNo查询
   * @param memberCardNo
   * @return 会员卡信息对象
   */
  MemberCardInfoDO selectByMemberCardNo(String memberCardNo);

  /**
   * 根据userId,merchantId查询会员卡信息
   * @param userId, merchantId
   * @return 会员卡信息对象
   */
  MemberCardInfoDO selectMemberCardInfoByUserIdMerchantId(Integer userId, Integer merchantId);

  /**
   * 根据userId,merchantId查询会员卡余额
   * @param userId merchantId
   * @return 会员卡余额，如果对象不存在，返回null
   */
  BigDecimal selectMemberCardRemainingMoney(Integer userId, Integer merchantId);

  /**
   * 查询会员卡消费是否可用
   * @param id
   * @param consumeMoney
   * @return true可用  false不可用
   */
  Boolean canUsedMemberCardInfo(Integer id,BigDecimal consumeMoney);

  /**
   * 根据userId查询会员卡列表
   * @param userInfoDO query
   * @return 会员卡信息集合
   */
  H5CMerchantBaseDTO selectListMemberCardInfoByUserId(UserInfoDO userInfoDO, BaseQuery query);

  /**
   * 查询该用户最近会员卡消费的商家
   * @param query
   * @return
   */
  PageBean<MemberCardInfoListDTO> selectListRecentlyConsumeMemberCardInfo(MemberCardConsumeRecordQuery query);

  /**
   * 查询有会员的商家并且我没有办理会员卡
   * @param userInfoDO
   * @return 商家集合
   */
  H5CMerchantBaseDTO selectMemberMerchantList(UserInfoDO userInfoDO,MemberCardRechargeRuleQuery query);
}
