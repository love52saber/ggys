package net.seocoo.ggys.module.takeout.service.impl;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutRuleDO;
import net.seocoo.ggys.module.takeout.mapper.MerchantTakeOutRuleMapper;
import net.seocoo.ggys.module.takeout.service.TakeOutRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/29 0029 17:54
 * @Email xieheng91@163.com
 * @Desc 外卖规则service
 */
@Service
public class TaskOutServiceRuleServiceImpl extends BaseService implements TakeOutRuleService {


    @Autowired
    private MerchantTakeOutRuleMapper merchantTakeOutRuleMapper;

    @Override
    public Boolean save(MerchantTakeOutRuleDO merchantTakeOutRuleDO) {
        return merchantTakeOutRuleMapper.insert(merchantTakeOutRuleDO)<1?false:true;
    }

    @Override
    public Boolean delete(Integer merchantTakeOutRuleId) {
        return merchantTakeOutRuleMapper.delete(merchantTakeOutRuleId)<1?false:true;
    }

    @Override
    public Boolean update(MerchantTakeOutRuleDO merchantTakeOutRuleDO) {
        return merchantTakeOutRuleMapper.updateByPrimaryKeySelective(merchantTakeOutRuleDO)<1?false:true;
    }

    @Override
    public List<MerchantTakeOutRuleDO> list(BaseQuery baseQuery) {
        return merchantTakeOutRuleMapper.list(baseQuery);
    }
}
