package net.seocoo.ggys.module.book.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.book.entity.FreeBookRuleDO;
import net.seocoo.ggys.module.book.query.BookRuleQuery;

import java.util.List;

/**
 * @author panch
 * @date 2018/5/30 16:18
 */
public interface BookRuleService {

    /**
     * 新增商家预约规则
     * @param freeBookRuleDO
     * @return id
     */
    int saveBookRule(FreeBookRuleDO freeBookRuleDO);

    /**
     * 根据id查询商家预约规则
     * @param id
     * @return 商家预约规则对象
     */
    FreeBookRuleDO getBookRuleById(int id);

    /**
     * 删除预约规则，假删
     * @param id
     */
    void deleteBookRule(int id);

    /**
     * 根据merchantId查询商家预约规则列表
     * @param merchantId
     * @return
     */
    List<FreeBookRuleDO> listBookRuleByMerchantId(int merchantId);

    /**
     * 分页查询
     * @param query
     * @return
     */
    PageBean<FreeBookRuleDO> listByPageQuery(BookRuleQuery query);

    /**
     * 查询总数
     * @param query
     * @return
     */
    Integer countByQuery(BookRuleQuery query);

    /**
     * 更新预约规则
     * @param freeBookRuleDO
     */
    void updateBookRule(FreeBookRuleDO freeBookRuleDO);
}
