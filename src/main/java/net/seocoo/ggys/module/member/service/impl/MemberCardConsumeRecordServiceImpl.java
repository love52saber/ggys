package net.seocoo.ggys.module.member.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.member.entity.MemberCardConsumeRecordDO;
import net.seocoo.ggys.module.member.entity.MemberCardInfoDO;
import net.seocoo.ggys.module.member.exception.MemberCardException;
import net.seocoo.ggys.module.member.mapper.MemberCardConsumeRecordMapper;
import net.seocoo.ggys.module.member.query.MemberCardConsumeRecordQuery;
import net.seocoo.ggys.module.member.service.MemberCardConsumeRecordService;
import net.seocoo.ggys.module.member.service.MemberCardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 会员卡消费记录实现类
 * @author PanChengHao
 * @date 2018/6/1 15:44
 */
@Service
public class MemberCardConsumeRecordServiceImpl extends BaseService implements MemberCardConsumeRecordService {

  @Autowired
  private MemberCardConsumeRecordMapper memberCardConsumeRecordMapper;

  @Autowired
  private MemberCardInfoService memberCardInfoService;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public int saveMemberCardConsumeRecord(MemberCardConsumeRecordDO memberCardConsumeRecordDO) {
    //修改为会员卡通过userId和merchantId查询
    MemberCardInfoDO memberCardInfoDO=memberCardInfoService.selectMemberCardInfoByUserIdMerchantId(
        memberCardConsumeRecordDO.getUserId(),memberCardConsumeRecordDO.getMerchantId());
    if(memberCardInfoDO == null){
      throw new MemberCardException("你未在该商家办理会员卡",RequestCode.Operate_Tip);
    }
    //更新会员卡信息表余额字段
    BigDecimal remainingMoney=memberCardInfoDO.getRemainingMoney();
    //余额小于消费金额
    if(remainingMoney.compareTo(memberCardConsumeRecordDO.getConsumeMoney())<0){
      throw new MemberCardException("会员卡余额小于消费金额，无法使用会员卡消费", RequestCode.server_error);
    }
    memberCardInfoDO.setRemainingMoney(remainingMoney.subtract(memberCardConsumeRecordDO.getConsumeMoney()));
    memberCardInfoDO.setUpdateDate(new Date());
    memberCardInfoService.updateById(memberCardInfoDO);
    //会员卡消费记录表增加记录
    memberCardConsumeRecordDO.setCanDeleted(YesNoEnum.N);
    memberCardConsumeRecordDO.setConsumeDate(new Date());
    memberCardConsumeRecordDO.setUuid(StringEx.newUUID());
    memberCardConsumeRecordDO.setRemainingMoney(memberCardInfoDO.getRemainingMoney());
    memberCardConsumeRecordDO.setMemberCardId(memberCardInfoDO.getId());
    return this.memberCardConsumeRecordMapper.insert(memberCardConsumeRecordDO);
  }

  @Override
  public MemberCardConsumeRecordDO getMemberCardConsumeRecordById(int id) {
    return this.memberCardConsumeRecordMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateById(MemberCardConsumeRecordDO memberCardConsumeRecordDO) {
    return this.memberCardConsumeRecordMapper.updateByPrimaryKey(memberCardConsumeRecordDO);
  }

  @Override
  public int updateSelectiveById(MemberCardConsumeRecordDO memberCardConsumeRecordDO) {
    return this.memberCardConsumeRecordMapper.updateByPrimaryKeySelective(memberCardConsumeRecordDO);
  }

  @Override
  public void deleteById(int id) {
    MemberCardConsumeRecordDO memberCardConsumeRecordDO=this.memberCardConsumeRecordMapper.selectByPrimaryKey(id);
    if(memberCardConsumeRecordDO==null){
      throw new MemberCardException("ID="+id+"的会员卡消费记录不存在，删除失败",RequestCode.server_error);
    }
    memberCardConsumeRecordDO.setCanDeleted(YesNoEnum.Y);
    this.memberCardConsumeRecordMapper.updateByPrimaryKeySelective(memberCardConsumeRecordDO);
  }

  @Override
  public PageBean<MemberCardConsumeRecordDO> listByPageQuery(MemberCardConsumeRecordQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());
    List<MemberCardConsumeRecordDO> memberCardConsumeRecordDOList = this.memberCardConsumeRecordMapper.listByPageQuery(query);
    return new PageBean<>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), memberCardConsumeRecordDOList);
  }

  @Override
  public Integer countByQuery(MemberCardConsumeRecordQuery query) {
    return this.memberCardConsumeRecordMapper.countByQuery(query);
  }

  @Override
  public PageBean<MemberCardConsumeRecordDO> listByPageQueryGroupByMerchantId(MemberCardConsumeRecordQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());
    List<MemberCardConsumeRecordDO> memberCardConsumeRecordDOList=this.memberCardConsumeRecordMapper.listByPageQueryGroupByMerchantId(query);
    return new PageBean<>(query.getPageNum(), query.getPageSize(),countByPageQueryGroupByMerchantId(query),memberCardConsumeRecordDOList);
  }

  @Override
  public Integer countByPageQueryGroupByMerchantId(MemberCardConsumeRecordQuery query) {
    return this.memberCardConsumeRecordMapper.countByPageQueryGroupByMerchantId(query);
  }
}
