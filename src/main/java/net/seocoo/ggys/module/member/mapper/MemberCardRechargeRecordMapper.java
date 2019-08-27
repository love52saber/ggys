package net.seocoo.ggys.module.member.mapper;

import net.seocoo.ggys.module.member.entity.MemberCardRechargeRecordDO;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRecordQuery;

import java.math.BigDecimal;
import java.util.List;

public interface MemberCardRechargeRecordMapper {
    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增会员充值记录
     * @param record
     * @return
     */
    int insert(MemberCardRechargeRecordDO record);

    /**
     * 插入指定属性
     * @param record
     * @return
     */
    int insertSelective(MemberCardRechargeRecordDO record);

    /**
     * 根据id查询充值记录
     * @param id
     * @return 充值记录对象
     */
    MemberCardRechargeRecordDO selectByPrimaryKey(Integer id);

    /**
     * 更新指定属性
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MemberCardRechargeRecordDO record);

    /**
     * 根据id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(MemberCardRechargeRecordDO record);

    /**
     * 分页查询
     * @param query
     * @return
     */
    List<MemberCardRechargeRecordDO> listByPageQuery(MemberCardRechargeRecordQuery query);

    /**
     * 查询总数
     *
     * @param query
     * @return
     */
    Integer countByQuery(MemberCardRechargeRecordQuery query);

    /**
     * 查询商家今日新增储值
     * @param query
     * @return
     */
    BigDecimal getAddRechargeTotalMoney(MemberCardRechargeRecordQuery query);
}