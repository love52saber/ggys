package net.seocoo.ggys.module.merchant.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.merchant.entity.FirstClassifyDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FirstClassifyMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(FirstClassifyDO record);

    int insertSelective(FirstClassifyDO record);

    FirstClassifyDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FirstClassifyDO record);

    int updateByPrimaryKey(FirstClassifyDO record);

    /*自定义mapper*/

    /**
     * 逻辑删除
     * @param frstClassifyId 主键
     * @return
     */
    int delete(Integer frstClassifyId);

    List<FirstClassifyDO> list(BaseQuery query);
}