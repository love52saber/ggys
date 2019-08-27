package net.seocoo.ggys.module.coupon.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.coupon.constants.CouponTemplatePayRangEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateStateEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateUseRangEnum;
import net.seocoo.ggys.module.coupon.constants.CouponUseRecordStateEnum;
import net.seocoo.ggys.module.coupon.dto.CouponUseRecordInfoDTO;
import net.seocoo.ggys.module.coupon.dto.CouponUseRecordListDTO;
import net.seocoo.ggys.module.coupon.entity.CouponTemplateDO;
import net.seocoo.ggys.module.coupon.entity.CouponUseRecordDO;
import net.seocoo.ggys.module.coupon.exception.CouponException;
import net.seocoo.ggys.module.coupon.mapper.CouponUseRecordMapper;
import net.seocoo.ggys.module.coupon.query.CouponUseRecordQuery;
import net.seocoo.ggys.module.coupon.service.CouponTemplateService;
import net.seocoo.ggys.module.coupon.service.CouponUseRecordService;
import net.seocoo.ggys.module.merchant.entity.MerchantDO;
import net.seocoo.ggys.module.merchant.entity.MerchantDTO;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 优惠券使用记录Service
 * @author ZengXiaoLiang
 * @date 2018/6/2 17:23
 **/
@Service
public class CouponUseRecordServiceImpl implements CouponUseRecordService {

  @Autowired
  private CouponUseRecordMapper couponUseRecordMapper;

  @Autowired
  private CouponTemplateService couponTemplateService;

  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private MerchantService merchantService;

  @Override
  public boolean isCanUseCoupon(Integer couponUseRecordId, CouponTemplateUseRangEnum useRangEnum, CouponTemplatePayRangEnum payRangEnum, BigDecimal orderFee) {
    CouponUseRecordDO couponUseRecord = this.couponUseRecordMapper.selectByPrimaryKey(couponUseRecordId);
    if(couponUseRecord == null) {
      return  false;
    }

    if(couponUseRecord.getState() != CouponUseRecordStateEnum.NOT_USE){
      return false;
    }

    CouponTemplateDO couponTemplate = this.couponTemplateService.getCouponTemplateById(couponUseRecord.getCouponTemplateId());
    if(couponTemplate == null){
      return false;
    }

    if(orderFee.compareTo(couponTemplate.getUseCondition())<0){
      return false;
    }

    if((couponTemplate.getUseRang() & useRangEnum.getCode()) != useRangEnum.getCode()){
      return false;
    }

    if((couponTemplate.getPayRang() & payRangEnum.getCode()) != payRangEnum.getCode()) {
      return false;
    }
    return true;
  }

  @Override
  public boolean updateCouponUseRecordState2Use(Integer couponUseRecordId) {
    CouponUseRecordDO record = new CouponUseRecordDO();
    record.setId(couponUseRecordId);
    record.setUsedDate(new Date());
    record.setState(CouponUseRecordStateEnum.USED);

    return this.couponUseRecordMapper.updateByPrimaryKeySelective(record)>0?true:false;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void saveCouponUseRecord(CouponTemplateDO record, Integer userId) {
    CouponTemplateDO couponTemplate = this.couponTemplateService.getCouponTemplateById(record.getId());
    if(couponTemplate.getState() != CouponTemplateStateEnum.PUBLISH){
      throw new CouponException("优惠券状态为"+couponTemplate.getState().getDesc()+",暂不可领取", RequestCode.server_error);
    }

    if(couponTemplate.getCanUseCount()<=0){
      throw new CouponException("优惠券已领取完,不可继续领取", RequestCode.server_error);
    }

    int count = this.countCouponUseRecordByUserId(userId, couponTemplate.getId());
    if(count >= couponTemplate.getCountPerPerson()) {
      throw new CouponException("每人限领"+couponTemplate.getCountPerPerson()+"张,您已领取"+count+"张", RequestCode.server_error);
    }

    // 更新优惠券模板
    int updateRow = this.couponTemplateService.updateCanUseCount(couponTemplate.getId(), couponTemplate.getVersion());
    if(updateRow<=0){
      throw new CouponException("优惠券领取失败", RequestCode.server_error);
    }

    // 新增优惠券领取记录
    CouponUseRecordDO couponUseRecord = new CouponUseRecordDO();
    couponUseRecord.setMerchantId(couponTemplate.getMerchantId());
    couponUseRecord.setCouponTemplateId(couponTemplate.getId());
    couponUseRecord.setUserId(userId);
    couponUseRecord.setState(CouponUseRecordStateEnum.NOT_USE);
    couponUseRecord.setGetDate(new Date());
    couponUseRecord.setUuid(StringEx.newUUID());
    this.couponUseRecordMapper.insert(couponUseRecord);
 }

  @Override
  public int countCouponUseRecordByUserId(int userId, int couponTemplateId) {
    CouponUseRecordQuery query = new CouponUseRecordQuery();
    query.setCouponTemplateId(couponTemplateId);
    query.setUserId(userId);
    return this.couponUseRecordMapper.countByQuery(query);
  }

  @Override
  public int countCouponUseRecordByMerchantId(int merchantId, int couponTemplateId) {
    CouponUseRecordQuery query = new CouponUseRecordQuery();
    query.setCouponTemplateId(couponTemplateId);
    query.setMerchantId(merchantId);
    return this.couponUseRecordMapper.countByQuery(query);
  }

  @Override
  public int updateCouponUseRecord(CouponUseRecordDO record) {
    return this.couponUseRecordMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public PageBean<CouponUseRecordListDTO> listByQuery(CouponUseRecordQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());
    query.setOrderBy("id desc");
    List<CouponUseRecordDO> couponTemplateDOList = this.couponUseRecordMapper.listByQuery(query);
    List<CouponUseRecordListDTO> dtoList = new ArrayList<>(couponTemplateDOList.size());
    CouponUseRecordListDTO dto = null;
    UserInfoDO userInfo = null;
    for (CouponUseRecordDO record : couponTemplateDOList) {
      dto = new CouponUseRecordListDTO();
      dto.setGetDate(record.getGetDate());
      dto.setState(record.getState().getDesc());
      dto.setId(record.getId());
      userInfo = this.userInfoService.getUserInfoById(record.getUserId());
      if(userInfo!=null){
        dto.setNickname(userInfo.getNickname());
      }else {
        dto.setNickname(StringUtils.EMPTY);
      }
      dtoList.add(dto);
    }
    return new PageBean<CouponUseRecordListDTO>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), dtoList);
  }

  @Override
  public PageBean<CouponUseRecordInfoDTO> listCouponUseRecordInfoDtoByQuery(CouponUseRecordQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());

    List<CouponUseRecordDO> couponTemplateDOList = this.couponUseRecordMapper.listByQuery(query);
    List<CouponUseRecordInfoDTO> dtoList = new ArrayList<>(couponTemplateDOList.size());
    CouponUseRecordInfoDTO dto = null;
    CouponTemplateDO couponTemplate = null;
    MerchantDTO merchant = null;
    for (CouponUseRecordDO couponUseRecordDO : couponTemplateDOList) {
      dto = new CouponUseRecordInfoDTO();
      couponTemplate = this.couponTemplateService.getCouponTemplateById(couponUseRecordDO.getCouponTemplateId());
      dto.setFaceValue(couponTemplate.getFaceValue());
      dto.setId(couponUseRecordDO.getId());
      dto.setName(couponTemplate.getName());
      dto.setUseCondition(couponTemplate.getUseCondition());
      dto.setValidateEndDate(couponTemplate.getValidateEndDate());
      dto.setPayRangEnumList(couponTemplate.getPayRangEnumList());
      dto.setUseRangEnumList(couponTemplate.getUseRangEnumList());

      // 商家信息
      merchant = this.merchantService.get(couponTemplate.getMerchantId());
      dto.setMerchantName(merchant.getName());
      dtoList.add(dto);
    }
    return new PageBean<CouponUseRecordInfoDTO>(query.getPageNum(), query.getPageSize(), this.countByQuery(query),dtoList);
  }

  @Override
  public List<CouponUseRecordInfoDTO> listByNotPageQuery(CouponUseRecordQuery query) {
    List<CouponUseRecordDO> couponTemplateDOList = this.couponUseRecordMapper.listByQuery(query);
    List<CouponUseRecordInfoDTO> dtoList = new ArrayList<>(couponTemplateDOList.size());
    CouponUseRecordInfoDTO dto = null;
    CouponTemplateDO couponTemplate = null;
    MerchantDTO merchant = null;
    for (CouponUseRecordDO couponUseRecordDO : couponTemplateDOList) {
      dto = new CouponUseRecordInfoDTO();
      couponTemplate = this.couponTemplateService.getCouponTemplateById(couponUseRecordDO.getCouponTemplateId());
      dto.setFaceValue(couponTemplate.getFaceValue());
      dto.setId(couponUseRecordDO.getId());
      dto.setName(couponTemplate.getName());
      dto.setUseCondition(couponTemplate.getUseCondition());
      dto.setValidateEndDate(couponTemplate.getValidateEndDate());
      dto.setPayRangEnumList(couponTemplate.getPayRangEnumList());
      dto.setUseRangEnumList(couponTemplate.getUseRangEnumList());
      dtoList.add(dto);
    }
    return dtoList;
  }

  @Override
  public int countByQuery(CouponUseRecordQuery query) {
    return this.couponUseRecordMapper.countByQuery(query);
  }

  @Override
  public void updateCouponUseRecordState2Fail(Integer couponTemplateId) {
    this.couponUseRecordMapper.updateState(couponTemplateId, CouponUseRecordStateEnum.FAIL);
  }

  @Override
  public BigDecimal getCouponMoney(Integer couponUseRecordId) {
    CouponUseRecordDO couponUseRecord = this.couponUseRecordMapper.selectByPrimaryKey(couponUseRecordId);
    if(couponUseRecord == null){
      return BigDecimal.ZERO;
    }
    CouponTemplateDO couponTemplate = this.couponTemplateService.getCouponTemplateById(couponUseRecord.getCouponTemplateId());
    if(couponTemplate == null) {
      return BigDecimal.ZERO;
    }
    return couponTemplate.getFaceValue();
  }
}
