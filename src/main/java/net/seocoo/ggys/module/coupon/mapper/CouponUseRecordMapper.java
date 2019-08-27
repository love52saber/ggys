package net.seocoo.ggys.module.coupon.mapper;

import net.seocoo.ggys.module.coupon.constants.CouponUseRecordStateEnum;
import net.seocoo.ggys.module.coupon.entity.CouponUseRecordDO;
import net.seocoo.ggys.module.coupon.query.CouponUseRecordQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券使用基类DAO
 *
 * @author ZengXiaoLiang
 * @date 2018/5/29 15:11
 */
public interface CouponUseRecordMapper {
  /**
   * 根据主键删除对象
   * @param id 主键
   * @return 受影响的行数
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * 插入对象
   * @param record 实体对象
   * @return Id
   */
  int insert(CouponUseRecordDO record);

  /**
   * 插入对象
   * @param record 实体对象
   * @return Id
   */
  int insertSelective(CouponUseRecordDO record);

  /**
   * 根据主键查询对象
   * @param id Id
   * @return 优惠券使用记录对象
   * */
  CouponUseRecordDO selectByPrimaryKey(Integer id);

  /**
   * 更新对象
   * @param record 实体对象
   * @return 受影响的行数
   * */
  int updateByPrimaryKeySelective(CouponUseRecordDO record);

  /**
   * 更新对象
   * @param record 实体对象
   * @return 受影响的行数
   */
  int updateByPrimaryKey(CouponUseRecordDO record);

  /**
   * 根据Query查询
   * @param query 优惠券使用记录Query
   * @return 优惠券使用记录集合
   */
  List<CouponUseRecordDO> listByQuery(CouponUseRecordQuery query);

  /**
   * 根据CouponUseRecordQuery查询总数
   * @param query 优惠券使用记录Query
   * @return 总数
   */
  int countByQuery(CouponUseRecordQuery query);

  /**
   * 根据优惠券模板Id更新优惠券使用记录状态
   * @param couponTemplateId 优惠券模板Id
   * @param state 优惠券使用记录状态
   * @return 收影响的行数
   */
  int updateState(@Param("couponTemplateId") Integer couponTemplateId, @Param("state") CouponUseRecordStateEnum state);
}