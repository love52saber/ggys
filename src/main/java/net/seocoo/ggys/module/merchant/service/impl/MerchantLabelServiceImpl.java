package net.seocoo.ggys.module.merchant.service.impl;

import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.constants.CacheKeyPrefix;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.module.merchant.entity.MerchantLabelDO;
import net.seocoo.ggys.module.merchant.exception.MerchantException;
import net.seocoo.ggys.module.merchant.form.LabelForm;
import net.seocoo.ggys.module.merchant.mapper.MerchantLabelMapper;
import net.seocoo.ggys.module.merchant.query.MerchantLabelQuery;
import net.seocoo.ggys.module.merchant.service.MerchantLabelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 8:45
 * @Email xieheng91@163.com
 * @Desc 商户标签service接口实现
 */
@Service
public class MerchantLabelServiceImpl extends BaseService implements MerchantLabelService {

    @Autowired
    private MerchantLabelMapper merchantLabelMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Boolean save(MerchantLabelDO merchantLabelDO) {
        insertSetDefaultValue(merchantLabelDO);
        return merchantLabelMapper.insert(merchantLabelDO) < 1 ? false : true;
    }

    @Override
    public Boolean saveLimitCheck(LabelForm labelForm) {
        if(merchantLabelMapper.countByMerchantId(labelForm.getMerchantId())>=3){
            throw new MerchantException("标签数量超过最大数量3个",RequestCode.server_error);
        }
        return save(labelForm);
    }


    @Override
    public Boolean save(LabelForm labelForm) {
        MerchantLabelDO labelDO = new MerchantLabelDO();
        BeanUtils.copyProperties(labelForm, labelDO);
        Boolean result = save(labelDO);
        if (result) {
            List list = new ArrayList();
            list.add(labelDO);
            redisUtil.setRedisList(CacheKeyPrefix.MERCHANT_LABEL + labelForm.getMerchantId(), list,1L,TimeUnit.DAYS);
        }
        return result;
    }

    @Override
    public Boolean delete(Integer merchantId, Integer id) {
        redisUtil.remove(CacheKeyPrefix.MERCHANT_LABEL + merchantId);
        return merchantLabelMapper.delete(id) < 1 ? false : true;
    }

    @Override
    public Boolean update(MerchantLabelDO merchantLabelDO) {
        if(merchantLabelDO.getMerchantId()!=null){
            redisUtil.remove(CacheKeyPrefix.MERCHANT_LABEL + merchantLabelDO.getMerchantId());
        }
        return merchantLabelMapper.updateByPrimaryKeySelective(merchantLabelDO) < 1 ? false : true;
    }

    @Override
    public List<MerchantLabelDO> list(BaseQuery baseQuery) {
        return merchantLabelMapper.list(baseQuery);
    }

    @Override
    public List<MerchantLabelDO> listByMerchantId(Integer merchantId) {
        //merchant:label:{merchantId}
        List<MerchantLabelDO> list = null;
        list = redisUtil.getRedisList(CacheKeyPrefix.MERCHANT_LABEL + merchantId);
        if (list == null || list.size() == 0) {
            MerchantLabelQuery query = new MerchantLabelQuery();
            query.setMerchantId(merchantId);
            list = this.merchantLabelMapper.list(query);
            if (list != null && list.size() > 0) {
                redisUtil.setRedisList(CacheKeyPrefix.MERCHANT_LABEL + merchantId, list, 1L, TimeUnit.DAYS);
            }
        }
        return list;
    }

    @Override
    public List<String> listNameByMerchantId(Integer merchantId) {
        List<MerchantLabelDO> labelList = listByMerchantId(merchantId);
        List<String> labelNames = new ArrayList<>();
        for (MerchantLabelDO label : labelList) {
            labelNames.add(label.getName());
        }
        return labelNames;
    }
}
