package net.seocoo.ggys.module.coupon.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.coupon.constants.CouponTemplatePayRangEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateUseRangEnum;
import net.seocoo.ggys.module.coupon.dto.CouponUseRecordInfoDTO;
import net.seocoo.ggys.module.coupon.dto.CouponUseRecordListDTO;
import net.seocoo.ggys.module.coupon.entity.CouponTemplateDO;
import net.seocoo.ggys.module.coupon.entity.CouponUseRecordDO;
import net.seocoo.ggys.module.coupon.query.CouponUseRecordQuery;

import java.math.BigDecimal;
import java.util.List;

/**
 * 优惠券使用记录Service
 * @author ZengXiaoLiang
 * @date 2018/6/1 20:36
 **/
public interface CouponUseRecordService {

  /**
   * 新增优惠券使用记录
   * @param record 优惠券模板实体
   * @param userId 优惠券领取人Id
   */
  void saveCouponUseRecord(CouponTemplateDO record, Integer userId);

  /**
   * 统计商户的优惠券领取条数
   * @param merchantId 商户Id
   * @param couponTemplateId 优惠券模板Id
   * @return 领取优惠券的条数
   */
  int countCouponUseRecordByMerchantId(int merchantId, int couponTemplateId);

  /**
   * 统计用户领取的优惠券的张数
   * @param userId 领取人
   * @param couponTemplateId 优惠券模板Id
   * @return 领取的数量
   */
  int countCouponUseRecordByUserId(int userId, int couponTemplateId);

  /**
   * 更新优惠券使用记录
   * @param record 优惠券使用记录实体
   * @return 受影响的行数
   */
  int updateCouponUseRecord(CouponUseRecordDO record);

  /**
   * 分页查询
   * @param query 优惠券使用记录Query
   * @return 分页列表
   */
  PageBean<CouponUseRecordListDTO> listByQuery(CouponUseRecordQuery query);

  /**
   * 分页查询优惠券以及模板详细信息
   * @param query
   * @return
   */
  PageBean<CouponUseRecordInfoDTO> listCouponUseRecordInfoDtoByQuery(CouponUseRecordQuery query);

  /**
   * 查询总数
   * @param query 优惠券使用记录Query
   * @return 总数
   */
  int countByQuery(CouponUseRecordQuery query);

  /**
   * 修改优惠券使用记录状态为已失效
   * @param couponTemplateId 优惠券模板Id
   */
  void updateCouponUseRecordState2Fail(Integer couponTemplateId);

  /**
   * 判断优惠券是否可以使用
   * @param couponUseRecordId 优惠券使用记录Id
   * @param useRangEnum 优惠券使用范围
   * @param payRangEnum 优惠券支付范围
   * @param orderFee 订单的费用
   * @return 可以使用返回true，否则返回false
   */
  boolean isCanUseCoupon(Integer couponUseRecordId, CouponTemplateUseRangEnum useRangEnum, CouponTemplatePayRangEnum payRangEnum, BigDecimal orderFee);

  /**
   * 获得优惠券的面值
   * @param couponUseRecordId
   * @return 优惠券可使用金额
   */
  BigDecimal getCouponMoney(Integer couponUseRecordId);

  /**
   * 修改优惠券使用记录状态为已使用
   * @param couponUseRecordId 优惠券使用记录Id
   * @return 修改成功返回true饭后返回false
   */
  boolean updateCouponUseRecordState2Use(Integer couponUseRecordId);

  /**
   * 查询优惠券详情信息
   * @param query query
   * @return
   */
  List<CouponUseRecordInfoDTO> listByNotPageQuery(CouponUseRecordQuery query);
}
