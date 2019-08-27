package net.seocoo.ggys.module.member.service;

import net.seocoo.ggys.module.member.entity.MemberCardImageDO;

/**
 * @author PanChengHao
 * @date 2018/6/15 16:02
 */
public interface MemberCardImageService {

  /**
   * 新增会员卡图片和说明
   * @param memberCardImageDO
   */
  void saveMemberCardImage(MemberCardImageDO memberCardImageDO);

  /**
   * 根据id获取会员图片和说明
   * @param id
   * @return
   */
  MemberCardImageDO getMemberCardImageById(Integer id);

  /**
   * 根据商家id获取会员卡图片和说明
   * @param merchantId
   * @return
   */
  MemberCardImageDO getMemberCardImageByMerchantId(Integer merchantId);

  /**
   * 更新会员卡图片和说明
   * @param memberCardImageDO
   */
  void updateMemberCardImage(MemberCardImageDO memberCardImageDO);
}
