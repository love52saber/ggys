package net.seocoo.ggys.module.takeout.service.impl;

import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutTypeDO;
import net.seocoo.ggys.module.takeout.exception.TakeOutTypeException;
import net.seocoo.ggys.module.takeout.mapper.MerchantTakeOutTypeMapper;
import net.seocoo.ggys.module.takeout.service.TakeOutTemplateService;
import net.seocoo.ggys.module.takeout.service.TakeOutTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 14:06
 * @Email xieheng91@163.com
 * @Desc 外卖商品分类service
 */
@Service
public class TakeOutTypeServiceImpl extends BaseService implements TakeOutTypeService {

    @Autowired
    private MerchantTakeOutTypeMapper merchantTakeOutTypeMapper;

    @Autowired
    private TakeOutTemplateService takeOutTemplateService;


    @Override
    public Boolean save(MerchantTakeOutTypeDO merchantTakeOutTypeDO) {
        return merchantTakeOutTypeMapper.insert(merchantTakeOutTypeDO)<1?false:true;
    }

    @Override
    public Boolean delete(Integer merchantTakeOutTypeId) {
        //删除前判断
        if (!takeOutTemplateService.existByTakeOutTypeId(merchantTakeOutTypeId)){
            return merchantTakeOutTypeMapper.delete(merchantTakeOutTypeId)<1?false:true;
        }else{
            throw new TakeOutTypeException("该分类存在商品，不能直接进行删除",RequestCode.server_error);
        }
    }

    @Override
    public Boolean update(MerchantTakeOutTypeDO merchantTakeOutTypeDO) {
        return merchantTakeOutTypeMapper.updateByPrimaryKeySelective(merchantTakeOutTypeDO)<1?false:true;
    }

    @Override
    public List<MerchantTakeOutTypeDO> list(BaseQuery baseQuery) {
        return merchantTakeOutTypeMapper.list(baseQuery);
    }
}
