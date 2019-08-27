package net.seocoo.ggys.module.member.mapper;

import net.seocoo.ggys.module.member.entity.MemberCardImageDO;

public interface MemberCardImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberCardImageDO record);

    int insertSelective(MemberCardImageDO record);

    MemberCardImageDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberCardImageDO record);

    int updateByPrimaryKey(MemberCardImageDO record);

    MemberCardImageDO selectByMerchantId(MemberCardImageDO record);
}