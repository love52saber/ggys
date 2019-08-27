package net.seocoo.ggys.module.member.service.impl;

import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.module.member.entity.MemberCardImageDO;
import net.seocoo.ggys.module.member.mapper.MemberCardImageMapper;
import net.seocoo.ggys.module.member.service.MemberCardImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author PanChengHao
 * @date 2018/6/15 16:02
 */
@Service
public class MemberCardImageServiceImpl extends BaseService implements MemberCardImageService {
  @Autowired
  private MemberCardImageMapper memberCardImageMapper;

  /**
   * 新增会员卡图片和说明
   *
   * @param memberCardImageDO
   */
  @Override
  public void saveMemberCardImage(MemberCardImageDO memberCardImageDO) {
    //先判断该商家有没有记录，没有则插入数据，有则更新数据
    MemberCardImageDO record=new MemberCardImageDO();
    record.setMerchantId(memberCardImageDO.getMerchantId());
    MemberCardImageDO cardImageDO=this.memberCardImageMapper.selectByMerchantId(record);
    if(cardImageDO==null){
      insertSetDefaultValue(memberCardImageDO);
      memberCardImageMapper.insert(memberCardImageDO);
    }else {
      memberCardImageDO.setUpdateDate(new Date());
      memberCardImageDO.setId(cardImageDO.getId());
      memberCardImageMapper.updateByPrimaryKeySelective(memberCardImageDO);
    }
  }

  /**
   * 根据id获取会员图片和说明
   *
   * @param id
   * @return
   */
  @Override
  public MemberCardImageDO getMemberCardImageById(Integer id) {
    return this.memberCardImageMapper.selectByPrimaryKey(id);
  }

  /**
   * 根据商家id获取会员卡图片和说明
   *
   * @param merchantId
   * @return
   */
  @Override
  public MemberCardImageDO getMemberCardImageByMerchantId(Integer merchantId) {
    MemberCardImageDO memberCardImageDO = new MemberCardImageDO();
    memberCardImageDO.setMerchantId(merchantId);
    return this.memberCardImageMapper.selectByMerchantId(memberCardImageDO);
  }

  /**
   * 更新会员卡图片和说明
   *
   * @param memberCardImageDO
   */
  @Override
  public void updateMemberCardImage(MemberCardImageDO memberCardImageDO) {
    this.memberCardImageMapper.updateByPrimaryKeySelective(memberCardImageDO);
  }
}
