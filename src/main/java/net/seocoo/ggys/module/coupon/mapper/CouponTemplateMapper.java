package net.seocoo.ggys.module.coupon.mapper;

import net.seocoo.ggys.module.coupon.constants.CouponTemplateStateEnum;
import net.seocoo.ggys.module.coupon.entity.CouponTemplateDO;
import net.seocoo.ggys.module.coupon.query.CouponTemplateQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券模板Mapper
 *
 * @author ZengXiaoLiang
 * @date 2018/5/30 10:14
 */
public interface CouponTemplateMapper {
  /**
   * 根据Id删除
   *
   * @param id
   * @return
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * 插入
   *
   * @param record
   * @return
   */
  int insert(CouponTemplateDO record);

  /**
   * 插入指定属性
   *
   * @param record
   * @return
   */
  int insertSelective(CouponTemplateDO record);

  /**
   * 根据Id查询
   *
   * @param id
   * @return
   */
  CouponTemplateDO selectByPrimaryKey(Integer id);

  /**
   * 更新指定的属性
   *
   * @param record
   * @return
   */
  int updateByPrimaryKeySelective(CouponTemplateDO record);

  /**
   * 更新全部字段
   *
   * @param record
   * @return
   */
  int updateByPrimaryKey(CouponTemplateDO record);

  /**
   * 根据商户Id查询优惠券模板集合
   *
   * @param merchantId 商户Id
   * @return 优惠券模板集合
   */
  List<CouponTemplateDO> listByMerchantId(Integer merchantId);

  /**
   * 修改优惠券模板状态
   *
   * @param id  优惠券模板Id
   * @param stateEnum 状态枚举
   * @return 受影响的行数
   */
  int updateCouponTemplateByState(@Param("id") Integer id, @Param("state") CouponTemplateStateEnum stateEnum);

  /**
   * 分页查询
   *
   * @param query 查询条件
   * @return 优惠券模板集合
   */
  List<CouponTemplateDO> listByPageQuery(CouponTemplateQuery query);

  /**
   * 查询总数
   *
   * @param query
   * @return
   */
  Integer countByQuery(CouponTemplateQuery query);

  /**
   * 更新优惠券可领取数量
   *
   * @param id      优惠券模板Id
   * @param version 版本号
   * @return 更新的行数
   */
  int updateCanUseCount(@Param("id") Integer id, @Param("version") Integer version);
}