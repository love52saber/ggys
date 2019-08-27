package net.seocoo.ggys.module.area.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.area.entity.BusinessDistrictDO;
import net.seocoo.ggys.module.area.exception.AreaException;
import net.seocoo.ggys.module.area.mapper.BusinessDistrictMapper;
import net.seocoo.ggys.module.area.query.BusinessDistrictQuery;
import net.seocoo.ggys.module.area.service.BusinessDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PanChengHao
 * @date 2018/6/5 22:13
 */
@Service
public class BusinessDistrictServiceImpl extends BaseService implements BusinessDistrictService {
	@Autowired
	private BusinessDistrictMapper businessDistrictMapper;

	@Override
	public int insert(BusinessDistrictDO record) {
		insertSetDefaultValue(record);
		return this.businessDistrictMapper.insert(record)<1?0:1;
	}

	@Override
	public int insertSelective(BusinessDistrictDO record) {
		insertSetDefaultValue(record);
		return this.businessDistrictMapper.insertSelective(record)<1?0:1;
	}

	@Override
	public BusinessDistrictDO selectByPrimaryKey(Integer id) {
		return this.businessDistrictMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(BusinessDistrictDO record) {
		updateSetDefaultValue(record);
		return this.businessDistrictMapper.updateByPrimaryKeySelective(record)<1?0:1;
	}

	@Override
	public int updateByPrimaryKey(BusinessDistrictDO record) {
		updateSetDefaultValue(record);
		return this.businessDistrictMapper.updateByPrimaryKey(record)<1?0:1;
	}

	@Override
	public void deleteBusinessDistrict(int id) {
		BusinessDistrictDO businessDistrictDO=this.businessDistrictMapper.selectByPrimaryKey(id);
		if(businessDistrictDO == null){
			throw new AreaException("ID="+id+"的商圈不存在", RequestCode.server_error);
		}
		businessDistrictDO.setCanDeleted(YesNoEnum.Y);
		this.businessDistrictMapper.updateByPrimaryKeySelective(businessDistrictDO);
	}

	@Override
	public PageBean<BusinessDistrictDO> listByPageQuery(BusinessDistrictQuery query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize());
		List<BusinessDistrictDO> businessDistrictDOList = this.businessDistrictMapper.listByPageQuery(query);
		return new PageBean<>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), businessDistrictDOList);
	}

	@Override
	public Integer countByQuery(BusinessDistrictQuery query) {
		return this.businessDistrictMapper.countByQuery(query);
	}
}
