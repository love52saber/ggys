package net.seocoo.ggys.module.takeout.service.impl;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutTemplateDO;
import net.seocoo.ggys.module.takeout.mapper.MerchantTakeOutTemplateMapper;
import net.seocoo.ggys.module.takeout.query.TakeOutTemplateQuery;
import net.seocoo.ggys.module.takeout.service.TakeOutTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 14:24
 * @Email xieheng91@163.com
 * @Desc 外卖商品模板service
 */
@Service
public class TakeOutTemplateServiceImpl extends BaseService implements TakeOutTemplateService {

    @Autowired
    private MerchantTakeOutTemplateMapper takeOutTemplateMapper;


    @Override
    public Boolean save(MerchantTakeOutTemplateDO merchantTakeOutTemplateDO) {
        return takeOutTemplateMapper.insert(merchantTakeOutTemplateDO)<1?false:true;
    }

    @Override
    public Boolean delete(Integer merchantTakeOutTemplateId) {
        return takeOutTemplateMapper.delete(merchantTakeOutTemplateId)<1?false:true;
    }

    @Override
    public Boolean update(MerchantTakeOutTemplateDO merchantTakeOutTemplateDO) {
        return takeOutTemplateMapper.updateByPrimaryKeySelective(merchantTakeOutTemplateDO)<1?false:true;
    }

    @Override
    public List<MerchantTakeOutTemplateDO> list(BaseQuery baseQuery) {
        return takeOutTemplateMapper.list(baseQuery);
    }

    @Override
    public Boolean existByTakeOutTypeId(Integer merchantTakeOutTypeId) {
        //删除前判断
        TakeOutTemplateQuery takeOutTemplateQuery = new TakeOutTemplateQuery();
        takeOutTemplateQuery.setMerchantTakeOutTypeId(merchantTakeOutTypeId);
        List<MerchantTakeOutTemplateDO> takeOutTemplateDOS = this.list(takeOutTemplateQuery);
        return  takeOutTemplateDOS!=null&& takeOutTemplateDOS.size()>0 ;

    }


}
