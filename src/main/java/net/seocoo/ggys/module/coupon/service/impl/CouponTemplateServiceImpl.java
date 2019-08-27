package net.seocoo.ggys.module.coupon.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.CacheKeyPrefix;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.util.JodaDateUtil;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateStateEnum;
import net.seocoo.ggys.module.coupon.dto.CouponUseRecordInfoDTO;
import net.seocoo.ggys.module.coupon.entity.CouponTemplateDO;
import net.seocoo.ggys.module.coupon.exception.CouponException;
import net.seocoo.ggys.module.coupon.mapper.CouponTemplateMapper;
import net.seocoo.ggys.module.coupon.query.CouponTemplateQuery;
import net.seocoo.ggys.module.coupon.query.CouponUseRecordQuery;
import net.seocoo.ggys.module.coupon.service.CouponTemplateService;
import net.seocoo.ggys.module.coupon.service.CouponUseRecordService;
import net.seocoo.ggys.module.merchant.entity.MerchantDO;
import net.seocoo.ggys.module.merchant.entity.MerchantDTO;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 优惠券模板Service
 * @author ZengXiaoLiang
 * @date 2018/5/29 15:42
 **/
@Service
public class CouponTemplateServiceImpl extends BaseService implements CouponTemplateService {

  @Autowired
  private CouponTemplateMapper couponTemplateMapper;

  @Autowired
  private CouponUseRecordService couponUseRecordService;

  @Autowired
  private MerchantService merchantService;

  @Autowired
  private RedisUtil redisUtil;

  @Override
  public int saveCouponTemplate(CouponTemplateDO record) {
    record.setCanDeleted(YesNoEnum.N);
    record.setCanUseCount(record.getTotalCount());
    // 如果每人限领不限的话，则设置限领张数等于优惠券的总张数
    if(record.getCountPerPerson().intValue()<=0) {
      record.setCountPerPerson(record.getTotalCount());
    }
    record.setUuid(StringEx.newUUID());
    record.setVersion(0);
    record.setValidateStartDate(JodaDateUtil.getStartDate(record.getValidateStartDate()));
    record.setValidateEndDate(JodaDateUtil.getEndDate(record.getValidateEndDate()));
    return this.couponTemplateMapper.insert(record);
  }

  @Override
  public CouponTemplateDO getCouponTemplateById(int id) {
      String redisKey = CacheKeyPrefix.COUPON_TEMPLATE_ID +id;
    if(redisUtil.exists(redisKey)){
      return (CouponTemplateDO) redisUtil.get(redisKey);
    }

    CouponTemplateDO record = this.couponTemplateMapper.selectByPrimaryKey(id);
    if(record != null) {
      redisUtil.set(redisKey, record, 1L, TimeUnit.DAYS);
    }
    return record;
  }

  @Override
  public List<CouponTemplateDO> listCouponTemplateByMerchantId(int merchantId) {
    String key = CacheKeyPrefix.COUPON_TEMPLATE_MERCHANT_ID + merchantId;
    if(redisUtil.exists(key)){
      return redisUtil.getRedisList(key);
    }
    List<CouponTemplateDO> couponTemplateList =  this.couponTemplateMapper.listByMerchantId(merchantId);
    if(couponTemplateList!= null && !couponTemplateList.isEmpty()) {
      redisUtil.setRedisList(key, couponTemplateList);
    }
    return couponTemplateList;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void updateState(CouponTemplateDO record) {
    // 不能从缓存中取
    CouponTemplateDO couponTemplate = this.couponTemplateMapper.selectByPrimaryKey(record.getId());
    if(couponTemplate == null) {
      throw new CouponException("Id="+record.getId()+"的优惠券模板不存在", RequestCode.Operate_Tip);
    }

    if(couponTemplate.getState() == record.getState()) {
      throw new CouponException("优惠券状态已经是["+couponTemplate.getState().getDesc()+"],不能进行重复操作!",
          RequestCode.Operate_Tip);
    }

    if(record.getState() == CouponTemplateStateEnum.FINISH && couponTemplate.getState() == CouponTemplateStateEnum.FORBID) {
      throw new CouponException("优惠券状态是["+CouponTemplateStateEnum.FORBID.getDesc()+"],不能进行终止操作",
          RequestCode.Operate_Tip);
    }

    this.couponTemplateMapper.updateCouponTemplateByState(record.getId(), record.getState());

    // 删除缓存
    this.deleteRedisCache(couponTemplate);

    // 如果是禁用状态，要修改优惠券使用记录状态为已进行
    if(record.getState() == CouponTemplateStateEnum.FORBID) {
        this.couponUseRecordService.updateCouponUseRecordState2Fail(record.getId());
    }

  }

  @Override
  public void deleteCouponTemplate(int id) {
    CouponTemplateDO couponTemplate = this.couponTemplateMapper.selectByPrimaryKey(id);
    if(couponTemplate == null) {
      throw new CouponException("Id="+id+"的优惠券模板不存在", RequestCode.Operate_Tip);
    }
    if(couponTemplate.getState() == CouponTemplateStateEnum.INIT) {
      couponTemplate.setCanDeleted(YesNoEnum.Y);
      this.couponTemplateMapper.updateByPrimaryKey(couponTemplate);
      this.deleteRedisCache(couponTemplate);

    }else {
      throw new CouponException("优惠券模板状态为"+couponTemplate.getState().getDesc()+",禁止删除.", RequestCode.Operate_Tip);
    }
  }

  private void deleteRedisCache(CouponTemplateDO couponTemplate) {
    if(redisUtil.exists(CacheKeyPrefix.COUPON_TEMPLATE_ID + couponTemplate.getId())){
      redisUtil.remove(CacheKeyPrefix.COUPON_TEMPLATE_ID + couponTemplate.getId());
    }
    if(redisUtil.exists(CacheKeyPrefix.COUPON_TEMPLATE_MERCHANT_ID + couponTemplate.getMerchantId())) {
      redisUtil.remove(CacheKeyPrefix.COUPON_TEMPLATE_MERCHANT_ID +couponTemplate.getMerchantId());
    }
  }

  @Override
  public PageBean<CouponTemplateDO> listByPageQuery(CouponTemplateQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());
    query.setCanDeleted(YesNoEnum.N);
    List<CouponTemplateDO> couponTemplateDOList = this.couponTemplateMapper.listByPageQuery(query);
    return new PageBean<CouponTemplateDO>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), couponTemplateDOList);
  }

  @Override
  public Integer countByQuery(CouponTemplateQuery query) {
    query.setCanDeleted(YesNoEnum.N);
    return this.couponTemplateMapper.countByQuery(query);
  }

  @Override
  public int updateCanUseCount(Integer id, Integer version) {
    int count =  this.couponTemplateMapper.updateCanUseCount( id,  version);
    CouponTemplateDO couponTemplate = this.couponTemplateMapper.selectByPrimaryKey(id);
    this.deleteRedisCache(couponTemplate);
    return count;
  }

  @Override
  public PageBean<CouponUseRecordInfoDTO> listReceiveCoupon(CouponTemplateQuery query, UserInfoDO userInfo) {
    // 分页查询
    query.setCanDeleted(YesNoEnum.N);
    PageHelper.startPage(query.getPageNum(), query.getPageSize());
    List<CouponTemplateDO> couponTemplateDOList = this.couponTemplateMapper.listByPageQuery(query);
    List<CouponUseRecordInfoDTO> dtoList = new ArrayList<>(couponTemplateDOList.size());
    CouponUseRecordInfoDTO dto = null;
    MerchantDTO merchant = null;

    CouponUseRecordQuery couponUseRecordQuery = null;
    for (CouponTemplateDO couponTemplate : couponTemplateDOList) {
      dto = new CouponUseRecordInfoDTO();
//      dto.setId(couponTemplate.getId());
//      dto.setValidateEndDate(couponTemplate.getValidateEndDate());
//      dto.setValidateStartDate(couponTemplate.getValidateStartDate());
//      dto.setUseCondition(couponTemplate.getUseCondition());
//      dto.setName(couponTemplate.getName());
//      dto.setFaceValue(couponTemplate.getFaceValue());

      BeanUtils.copyProperties(couponTemplate, dto);
      merchant = this.merchantService.get(couponTemplate.getMerchantId());
      dto.setMerchantName(merchant.getName());

      couponUseRecordQuery  = new CouponUseRecordQuery();
      couponUseRecordQuery.setUserId(userInfo.getId());
      couponUseRecordQuery.setCouponTemplateId(couponTemplate.getId());
      int count = this.couponUseRecordService.countByQuery(couponUseRecordQuery);
      if(count == 0 ) {
        dto.setGetState("领取");
      }else if(count == couponTemplate.getCountPerPerson().intValue()){
        dto.setGetState("已领取");
      }else if(count < couponTemplate.getCountPerPerson().intValue()){
        dto.setGetState("再领一张");
      }
      dtoList.add(dto);
    }

    return new PageBean<CouponUseRecordInfoDTO>(query.getPageNum(), query.getPageSize(),this.countByQuery(query), dtoList);
  }
}
