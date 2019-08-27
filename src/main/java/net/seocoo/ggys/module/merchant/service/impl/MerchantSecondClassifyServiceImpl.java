package net.seocoo.ggys.module.merchant.service.impl;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.module.merchant.entity.MerchantSecondClassifyDO;
import net.seocoo.ggys.module.merchant.mapper.MerchantSecondClassifyMapper;
import net.seocoo.ggys.module.merchant.query.MerchantSecondClassifyQuery;
import net.seocoo.ggys.module.merchant.service.MerchantSecondClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 15:36
 * @Email xieheng91@163.com
 * @Desc 商户和分类中间表管理
 */
@Service
public class MerchantSecondClassifyServiceImpl extends BaseService implements MerchantSecondClassifyService {
    @Autowired
    private MerchantSecondClassifyMapper merchantSecondClassifyMapper;


    @Override
    public Boolean save(MerchantSecondClassifyDO merchantSecondClassifyDO) {
        return merchantSecondClassifyMapper.insert(merchantSecondClassifyDO) <1? false:true;
    }

    @Override
    public Boolean delete(Integer merchantSecondClassifyId) {
        return merchantSecondClassifyMapper.delete(merchantSecondClassifyId) < 1 ? false :true;
    }

    @Override
    public Boolean deleteMerchantId(Integer merchantId) {
        return merchantSecondClassifyMapper.deleteByMerchantId(merchantId)<1?false:true;
    }

    @Override
    public Boolean update(MerchantSecondClassifyDO merchantSecondClassifyDO) {
        return merchantSecondClassifyMapper.updateByPrimaryKeySelective(merchantSecondClassifyDO)<1?false:true;
    }

    @Override
    public List<MerchantSecondClassifyDO> list(BaseQuery baseQuery) {
        return merchantSecondClassifyMapper.list(baseQuery);
    }

    @Override
    public Boolean insertBatch(List<MerchantSecondClassifyDO> list) {
        int i = merchantSecondClassifyMapper.insertBatch(list);
        return i<1?false:true;
    }

    @Override
    public List<MerchantSecondClassifyDO> listByMerchantIdFirstId(Integer merchantId, Integer firstClassifyId) {
        MerchantSecondClassifyQuery query = new MerchantSecondClassifyQuery();
        query.setMerchantId(merchantId);
        query.setFirstClassifyId(firstClassifyId);
        return this.merchantSecondClassifyMapper.list(query);
    }
}
