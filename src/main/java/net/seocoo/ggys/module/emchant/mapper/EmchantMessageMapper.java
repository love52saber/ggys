package net.seocoo.ggys.module.emchant.mapper;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.emchant.dto.EmchantMessageUserDTO;
import net.seocoo.ggys.module.emchant.entity.EmchantMessageDO;

import java.util.List;
import java.util.Map;

public interface EmchantMessageMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EmchantMessageDO record);

    int insertSelective(EmchantMessageDO record);


    EmchantMessageDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmchantMessageDO record);

    int updateByPrimaryKey(EmchantMessageDO record);

    /*自定义mapper*/

    /**
     * 逻辑删除
     *
     * @param id 主键
     * @return
     */
    int delete(Integer id);

    List<EmchantMessageDO> list();

    List<EmchantMessageDO> listQuery(BaseQuery query);

    Integer countQuery(BaseQuery query);

    Integer countUnRead(BaseQuery query);

    Integer updateRead(BaseQuery query);

    List<EmchantMessageUserDTO> listMessageUser(BaseQuery query);

    EmchantMessageDO lastMessageByFromUser(Map param);
}