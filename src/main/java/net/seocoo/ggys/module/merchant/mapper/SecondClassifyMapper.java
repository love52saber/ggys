package net.seocoo.ggys.module.merchant.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.merchant.entity.SecondClassifyDO;

import java.util.List;

public interface SecondClassifyMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(SecondClassifyDO record);

    int insertSelective(SecondClassifyDO record);

    SecondClassifyDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecondClassifyDO record);

    int updateByPrimaryKey(SecondClassifyDO record);


    /*自定义mapper*/
    int delete(Integer secondClassifyId);

    List<SecondClassifyDO> list(BaseQuery query);


}