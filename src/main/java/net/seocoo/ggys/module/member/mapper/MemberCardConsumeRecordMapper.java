package net.seocoo.ggys.module.member.mapper;

import net.seocoo.ggys.module.member.entity.MemberCardConsumeRecordDO;
import net.seocoo.ggys.module.member.query.MemberCardConsumeRecordQuery;

import java.util.List;

public interface MemberCardConsumeRecordMapper {
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增消费记录
     * @param record
     * @return
     */
    int insert(MemberCardConsumeRecordDO record);

    /**
     * 插入指定属性
     * @param record
     * @return
     */
    int insertSelective(MemberCardConsumeRecordDO record);

    /**
     * 根据id查询会员卡消费记录
     * @param id
     * @return 会员卡消费记录对象
     */
    MemberCardConsumeRecordDO selectByPrimaryKey(Integer id);

    /**
     * 更新指定属性
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MemberCardConsumeRecordDO record);

    /**
     * 根据id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(MemberCardConsumeRecordDO record);

    /**
     * 分页查询
     * @param query
     * @return
     */
    List<MemberCardConsumeRecordDO> listByPageQuery(MemberCardConsumeRecordQuery query);

    /**
     * 查询总数
     *
     * @param query
     * @return
     */
    Integer countByQuery(MemberCardConsumeRecordQuery query);

    /**
     * 根据userId分组查询商家信息
     * @param query
     * @return
     */
    List<MemberCardConsumeRecordDO> listByPageQueryGroupByMerchantId(MemberCardConsumeRecordQuery query);

    /**
     * 查询分组总数
     * @param query
     * @return
     */
    Integer countByPageQueryGroupByMerchantId(MemberCardConsumeRecordQuery query);
}