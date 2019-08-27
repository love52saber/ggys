package net.seocoo.ggys.module.coupon.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateStateEnum;
import net.seocoo.ggys.module.coupon.dto.CouponUseRecordInfoDTO;
import net.seocoo.ggys.module.coupon.entity.CouponTemplateDO;
import net.seocoo.ggys.module.coupon.query.CouponTemplateQuery;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 优惠券模板service接口
 * @author ZengXiaoLiang
 * @date 2018/5/29 15:17
 **/
public interface CouponTemplateService {

  /**
   * 新增优惠券模板
   * @param record 优惠券模板对象
   * @return Id
   */
  int saveCouponTemplate(CouponTemplateDO record);

  /**
   * 根据优惠券模板Id查询
   * @param id 主键Id
   * @return 优惠券模板对象
   */
  CouponTemplateDO getCouponTemplateById(int id);

  /**
   * 查询商家的优惠券模板列表
   * @param merchantId
   * @return
   */
  List<CouponTemplateDO> listCouponTemplateByMerchantId(int merchantId);

  /**
   * 更新优惠券模板状态
   * @param record 优惠券模板
   */
  void updateState(CouponTemplateDO record);

  /**
   * 删除优惠券模板, 假删
   * @param id 主键Id
   */
  void deleteCouponTemplate(int id);

  /**
   * 分页查询
   * @param query 查询条件
   * @return 优惠券模板集合
   */
  PageBean<CouponTemplateDO> listByPageQuery(CouponTemplateQuery query);

  /**
   * 查询总数
   * @param query
   * @return
   */
  Integer countByQuery(CouponTemplateQuery query);

  /**
   * 更新优惠券可领取数量
   * @param id 优惠券模板Id
   * @param version 版本号
   * @return 更新的行数
   */
  int updateCanUseCount(Integer id, Integer version);

  /**
   * 查询用户的商家券的使用与领取集合
   * @param query
   * @param userInfo
   * @return
   */
  PageBean<CouponUseRecordInfoDTO> listReceiveCoupon(CouponTemplateQuery query, UserInfoDO userInfo);
}
