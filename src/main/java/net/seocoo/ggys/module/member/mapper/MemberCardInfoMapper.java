package net.seocoo.ggys.module.member.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.member.entity.MemberCardInfoDO;
import net.seocoo.ggys.module.member.query.MemberCardInfoQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberCardInfoMapper {

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增会员信息
     * @param record
     * @return
     */
    int insert(MemberCardInfoDO record);

    /**
     * 插入指定属性
     * @param record
     * @return
     */
    int insertSelective(MemberCardInfoDO record);

    /**
     * 根据id查询会员卡信息
     * @param id
     * @return 会员卡对象
     */
    MemberCardInfoDO selectByPrimaryKey(Integer id);

    /**
     * 更新指定属性
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MemberCardInfoDO record);

    /**
     * 根据id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(MemberCardInfoDO record);

    /**
     * 分页查询
     * @param query
     * @return
     */
    List<MemberCardInfoDO> listByPageQuery(BaseQuery query);

    /**
     * 查询总数
     *
     * @param query
     * @return
     */
    Integer countByQuery(BaseQuery query);

    /**
     * 根据memberCardNo查询
     * @param memberCardNo
     * @return 会员卡信息对象
     */
    MemberCardInfoDO selectByMemberCardNo(String memberCardNo);

    /**
     * 根据userId,merchantId查询会员卡信息
     * @param memberCardInfoDO
     * @return 会员卡信息对象，如果对象不存在，返回null
     */
    List<MemberCardInfoDO> selectMemberCardInfoByUserIdMerchantId(MemberCardInfoDO memberCardInfoDO);

    /**
     * 根据userId,merchantId查询会员卡余额
     * @param memberCardInfoDO
     * @return 会员卡余额，如果对象不存在，返回null
     */
    MemberCardInfoDO selectMemberCardRemainingMoney(MemberCardInfoDO memberCardInfoDO);
}