package net.seocoo.ggys.module.emchant.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.emchant.entity.EmchantRegisterDO;

import java.util.List;

public interface EmchantRegisterMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(EmchantRegisterDO record);

    int insertSelective(EmchantRegisterDO record);

    EmchantRegisterDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmchantRegisterDO record);

    int updateByPrimaryKey(EmchantRegisterDO record);


    /*自定义mapper*/

    /**
     * 逻辑删除
     *
     * @param id 主键
     * @return
     */
    int delete(Integer id);

    List<EmchantRegisterDO> list();

    List<EmchantRegisterDO> listQuery(BaseQuery query);

    Integer countQuery(BaseQuery query);
}