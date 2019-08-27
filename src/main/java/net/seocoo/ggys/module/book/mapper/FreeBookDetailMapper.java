package net.seocoo.ggys.module.book.mapper;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.book.entity.FreeBookDetailDO;
import net.seocoo.ggys.module.book.query.BookDetailQuery;

import java.util.List;

public interface FreeBookDetailMapper {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(FreeBookDetailDO record);

    /**
     * 插入指定属性
     * @param record
     * @return
     */
    int insertSelective(FreeBookDetailDO record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    FreeBookDetailDO selectByPrimaryKey(Integer id);

    /**
     * 更新指定属性
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FreeBookDetailDO record);

    /**
     * 更新全部
     * @param record
     * @return
     */
    int updateByPrimaryKey(FreeBookDetailDO record);

    /**
     * 查询商家预约列表
     * @param merchantId
     * @return
     */
    List<FreeBookDetailDO> listBookDetailByMerchantId(int merchantId);

    /**
     * 分页查询
     * @param query
     * @return
     */
    List<FreeBookDetailDO> listByPageQuery(BookDetailQuery query);

    /**
     * 查询总数
     *
     * @param query
     * @return
     */
    Integer countByQuery(BookDetailQuery query);

    /**
     * 查询此用户在该商家是否有可用的预约
     * @param freeBookDetailDO
     * @return
     */
    FreeBookDetailDO selectCanUsedBookDetail(FreeBookDetailDO freeBookDetailDO);

}