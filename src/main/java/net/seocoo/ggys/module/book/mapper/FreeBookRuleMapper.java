package net.seocoo.ggys.module.book.mapper;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.book.entity.FreeBookRuleDO;
import net.seocoo.ggys.module.book.query.BookRuleQuery;

import java.util.List;
 /**
  *@author PanChengHao
  *@date 2018/5/31 15:37
  */
  
  
public interface FreeBookRuleMapper {
    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(FreeBookRuleDO record);

    /**
     * 插入指定属性
     * @param record
     * @return
     */
    int insertSelective(FreeBookRuleDO record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    FreeBookRuleDO selectByPrimaryKey(Integer id);

    /**
     * 更新指定属性
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FreeBookRuleDO record);

    /**
     * 更新全部
     * @param record
     * @return
     */
    int updateByPrimaryKey(FreeBookRuleDO record);


    /**
     * 查询商家预约规则列表
     * @param merchantId
     * @return
     */
    List<FreeBookRuleDO> listBookRuleByMerchantId(int merchantId);

    /**
     * 分页查询
     * @param query
     * @return
     */
    List<FreeBookRuleDO> listByPageQuery(BookRuleQuery query);

    /**
     * 查询总数
     *
     * @param query
     * @return
     */
    Integer countByQuery(BookRuleQuery query);
}