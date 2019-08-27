package net.seocoo.ggys.module.area.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.area.entity.BusinessDistrictDO;
import net.seocoo.ggys.module.area.query.BusinessDistrictQuery;

/**
 * @author PanChengHao
 * @date 2018/6/5 22:03
 */
public interface BusinessDistrictService {
	/**
	 * 插入
	 * @param record
	 * @return
	 */
	int insert(BusinessDistrictDO record);

	/**
	 * 插入指定属性
	 * @param record
	 * @return
	 */
	int insertSelective(BusinessDistrictDO record);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	BusinessDistrictDO selectByPrimaryKey(Integer id);

	/**
	 * 更新指定属性
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(BusinessDistrictDO record);

	/**
	 * 根据id更新
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(BusinessDistrictDO record);

	/**
	 * 删除商圈
	 * @param id
	 */
	void deleteBusinessDistrict(int id);

	/**
	 * 分页查询商圈列表
	 * @param query
	 * @return 商圈列表
	 */
	PageBean<BusinessDistrictDO> listByPageQuery(BusinessDistrictQuery query);

	/**
	 * 查询总数
	 * @param query
	 * @return
	 */
	Integer countByQuery(BusinessDistrictQuery query);

}
