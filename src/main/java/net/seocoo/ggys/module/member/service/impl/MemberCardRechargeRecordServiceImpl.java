package net.seocoo.ggys.module.member.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.member.entity.MemberCardRechargeRecordDO;
import net.seocoo.ggys.module.member.entity.MemberCardInfoDO;
import net.seocoo.ggys.module.member.entity.MemberCardRechargeRuleDO;
import net.seocoo.ggys.module.member.exception.MemberCardException;
import net.seocoo.ggys.module.member.form.MemberCardRechargeRecordForm;
import net.seocoo.ggys.module.member.mapper.MemberCardRechargeRecordMapper;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRecordQuery;
import net.seocoo.ggys.module.member.service.MemberCardInfoService;
import net.seocoo.ggys.module.member.service.MemberCardRechargeRecordService;
import net.seocoo.ggys.module.member.service.MemberCardRechargeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author PanChengHao
 * @date 2018/6/1 14:55
 */
@Service
public class MemberCardRechargeRecordServiceImpl extends BaseService implements MemberCardRechargeRecordService {
  @Autowired
  private MemberCardRechargeRecordMapper memberCardIRechargeRecordMapper;

  @Autowired
  private MemberCardInfoService memberCardInfoService;

  @Autowired
  private MemberCardRechargeRuleService memberCardRechargeRuleService;

  @Transactional
  @Override
  public void saveMemberCardRechargeRecord(MemberCardRechargeRecordForm memberCard) {
    MemberCardRechargeRuleDO memberCardRechargeRuleDO=memberCardRechargeRuleService.getMemberCardRechargeRuleById(memberCard.getRechargeRuleId());
    if(memberCardRechargeRuleDO==null){
      throw new MemberCardException("ID="+memberCard.getRechargeRuleId()+"的充值规则不存在",RequestCode.Operate_Tip);
    }
    BigDecimal totalMoney=memberCardRechargeRuleDO.getRechargeMoney().add(memberCardRechargeRuleDO.getGiftMoney());
    //更新会员卡余额，注意此处需要调用支付接口进行充值
    MemberCardInfoDO memberCardInfoDO=this.memberCardInfoService.selectMemberCardInfoByUserIdMerchantId(memberCard.getUserId(),memberCard.getMerchantId());
    if(memberCardInfoDO==null){
      throw new MemberCardException("ID="+memberCard.getMemberCardId()+"的会员卡信息不存在",RequestCode.Operate_Tip);
    }
    BigDecimal remainingMoney=memberCardInfoDO.getRemainingMoney();
    BigDecimal rechargeTotalMoney=memberCardInfoDO.getRechargeTotalMoney();
    memberCardInfoDO.setRemainingMoney(remainingMoney.add(totalMoney));
    memberCardInfoDO.setRechargeTotalMoney(memberCardRechargeRuleDO.getRechargeMoney().add(rechargeTotalMoney));
    memberCardInfoService.updateById(memberCardInfoDO);
    //充值记录表插入数据
    MemberCardRechargeRecordDO memberCardIRechargeRecordDO=new MemberCardRechargeRecordDO();
    memberCardIRechargeRecordDO.setUuid(StringEx.newUUID());
    memberCardIRechargeRecordDO.setUserId(memberCard.getUserId());
    memberCardIRechargeRecordDO.setCanDeleted(YesNoEnum.N);
    memberCardIRechargeRecordDO.setRechargeMoney(memberCardRechargeRuleDO.getRechargeMoney());
    memberCardIRechargeRecordDO.setGiftMoney(memberCardRechargeRuleDO.getGiftMoney());
    memberCardIRechargeRecordDO.setRechargeTotalMoney(totalMoney);
    memberCardIRechargeRecordDO.setRechargeDate(new Date());
    memberCardIRechargeRecordDO.setCreateDate(new Date());
    memberCardIRechargeRecordDO.setPayType(memberCard.getPayType());
    memberCardIRechargeRecordDO.setTransactionNo(StringEx.getOrderIdByTime());
    memberCardIRechargeRecordDO.setRemainingMoney(totalMoney.add(remainingMoney));
    memberCardIRechargeRecordDO.setMerchantId(memberCard.getMerchantId());
    memberCardIRechargeRecordDO.setMemberCardId(memberCardInfoDO.getId());
    this.memberCardIRechargeRecordMapper.insert(memberCardIRechargeRecordDO);
  }

  @Override
  public void saveMemberCardRechargeRecord(MemberCardRechargeRecordDO memberCardIRechargeRecordDO) {
    this.memberCardIRechargeRecordMapper.insert(memberCardIRechargeRecordDO);
  }

  @Override
  public MemberCardRechargeRecordDO getMemberCardRechargeRecordById(int id) {
    return this.memberCardIRechargeRecordMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateById(MemberCardRechargeRecordDO memberCardIRechargeRecordDO) {
    return this.memberCardIRechargeRecordMapper.updateByPrimaryKey(memberCardIRechargeRecordDO);
  }

  @Override
  public void updateSelectiveById(MemberCardRechargeRecordDO memberCardIRechargeRecordDO) {
    memberCardIRechargeRecordDO=this.memberCardIRechargeRecordMapper.selectByPrimaryKey(memberCardIRechargeRecordDO.getId());
    if(memberCardIRechargeRecordDO == null){
      throw new MemberCardException("ID="+memberCardIRechargeRecordDO.getId()+"的会员卡充值记录不存在", RequestCode.server_error);
    }
    this.memberCardIRechargeRecordMapper.updateByPrimaryKeySelective(memberCardIRechargeRecordDO);
  }

  @Override
  public void deleteById(int id) {
    MemberCardRechargeRecordDO memberCardIRechargeRecordDO=this.memberCardIRechargeRecordMapper.selectByPrimaryKey(id);
    if(memberCardIRechargeRecordDO==null){
      throw new MemberCardException("ID="+id+"的会员卡充值记录不存在",500);
    }else{
      memberCardIRechargeRecordDO.setCanDeleted(YesNoEnum.Y);
      this.memberCardIRechargeRecordMapper.updateByPrimaryKey(memberCardIRechargeRecordDO);
    }
  }

  @Override
  public PageBean<MemberCardRechargeRecordDO> listByPageQuery(MemberCardRechargeRecordQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());
    List<MemberCardRechargeRecordDO> memberCardIRechargeRecordDOList=this.memberCardIRechargeRecordMapper.listByPageQuery(query);
    return new PageBean<>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), memberCardIRechargeRecordDOList);
  }

  @Override
  public Integer countByQuery(MemberCardRechargeRecordQuery query) {
    return this.memberCardIRechargeRecordMapper.countByQuery(query);
  }

  @Override
  public BigDecimal getAddRechargeTotalMoney(MemberCardRechargeRecordQuery query) {
    return this.memberCardIRechargeRecordMapper.getAddRechargeTotalMoney(query);
  }
}
