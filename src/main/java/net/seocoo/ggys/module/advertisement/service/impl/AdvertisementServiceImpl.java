package net.seocoo.ggys.module.advertisement.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.advertisement.entity.AdvertisementDO;
import net.seocoo.ggys.module.advertisement.form.AdvertisementForm;
import net.seocoo.ggys.module.advertisement.mapper.AdvertisementDOMapper;
import net.seocoo.ggys.module.advertisement.query.AdvertisementQuery;
import net.seocoo.ggys.module.advertisement.service.AdvertisementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/13 0013 16:21
 * @Email xieheng91@163.com
 * @Desc 广告管理
 */
@Service
public class AdvertisementServiceImpl extends BaseService implements AdvertisementService {

    @Autowired
    private AdvertisementDOMapper advertisementDOMapper;

    @Override
    public AdvertisementDO get(Integer id) {
        return advertisementDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean save(AdvertisementDO advertisementDO) {
        insertSetDefaultValue(advertisementDO);
        return advertisementDOMapper.insertSelective(advertisementDO)<1?false:true;
    }

    @Override
    public Boolean delete(Integer id) {
        return advertisementDOMapper.delete(id)<1?false:true;
    }

    @Override
    public Boolean update(AdvertisementDO advertisementDO) {
        updateSetDefaultValue(advertisementDO);
        return advertisementDOMapper.updateByPrimaryKeySelective(advertisementDO)<1?false:true;
    }

    @Override
    public List<AdvertisementDO> listQuery(AdvertisementQuery query) {
        return advertisementDOMapper.listQuery(query);
    }

    @Override
    public PageBean<AdvertisementDO> pageQuery(AdvertisementQuery query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<AdvertisementDO> advertisementList = this.listQuery(query);
        Integer count = advertisementDOMapper.countQuery(query);
        return new PageBean<AdvertisementDO>(advertisementList,query.getPageNum(),query.getPageSize(),count) ;
    }

    @Override
    public Boolean saveByForm(AdvertisementForm form) {
        AdvertisementDO advertisementDO = new AdvertisementDO();
        BeanUtils.copyProperties(form,advertisementDO);
        insertSetDefaultValue(advertisementDO);
        return advertisementDOMapper.insertSelective(advertisementDO)<1?false:true;
    }

    @Override
    public Boolean updateByFrom(AdvertisementForm form) {
        AdvertisementDO advertisementDO = new AdvertisementDO();
        BeanUtils.copyProperties(form,advertisementDO);
        updateSetDefaultValue(advertisementDO);
        return advertisementDOMapper.updateByPrimaryKeySelective(advertisementDO)<1?false:true;
    }


}
