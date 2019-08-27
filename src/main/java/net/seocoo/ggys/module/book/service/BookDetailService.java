package net.seocoo.ggys.module.book.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.book.entity.FreeBookDetailDO;
import net.seocoo.ggys.module.book.query.BookDetailQuery;
import java.util.List;

/**
 * @author panch
 * @date 2018/5/31 11:21
 */
public interface BookDetailService {

    /**
     * 新增预约详情
     * @param freeBookDetailDO
     * @return id
     */
    int saveBookDetail(FreeBookDetailDO freeBookDetailDO);

    /**
     * 根据id查询预约详情
     * @param id
     * @return 预约详情对象
     */
    FreeBookDetailDO getBookDetailById(int id);

    /**
     * 删除预约详情
     * @param id
     */
    void deleteBookDetail(int id);

    /**
     * 根据商家id查询预约详情集合
     * @param merchantId
     * @return 预约详情集合
     */
    List<FreeBookDetailDO> listBookDetailByMerchantId(int merchantId);

    /**
     * 分页查询
     * @param query
     * @return
     */
    PageBean<FreeBookDetailDO> listByPageQuery(BookDetailQuery query);

    /**
     * 查询总数
     * @param query
     * @return
     */
    Integer countByQuery(BookDetailQuery query);

    /**
     * 根据id更新状态
     * @param freeBookDetailDO
     * @return
     */
    void updateBookDetail(FreeBookDetailDO freeBookDetailDO);

    /**
     * 根据id更新指定属性
     * @param freeBookDetailDO
     * @return
     */
    int updateSelective(FreeBookDetailDO freeBookDetailDO);

    /**
     * 当前用户在该商家是否有可用的预约
     * @param freeBookDetailDO
     * @return true有 false 没有
     */
    Boolean canUsedBookDetail(FreeBookDetailDO freeBookDetailDO);
}
