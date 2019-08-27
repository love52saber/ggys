package net.seocoo.ggys.module.merchant.service.impl;

import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.constants.CacheKeyPrefix;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.module.merchant.entity.MerchantSecondClassifyDO;
import net.seocoo.ggys.module.merchant.entity.SecondClassifyDO;
import net.seocoo.ggys.module.merchant.exception.SecondClassifyException;
import net.seocoo.ggys.module.merchant.mapper.SecondClassifyMapper;
import net.seocoo.ggys.module.merchant.query.MerchantSecondClassifyQuery;
import net.seocoo.ggys.module.merchant.query.SecondClassifyQuery;
import net.seocoo.ggys.module.merchant.service.MerchantSecondClassifyService;
import net.seocoo.ggys.module.merchant.service.SecondClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 14:07
 * @Email xieheng91@163.com
 * @Desc 二级分类service
 */
@Service
public class SecondClassifyServiceImpl extends BaseService implements SecondClassifyService {
    @Autowired
    private SecondClassifyMapper secondClassifyMapper;

    @Autowired
    private MerchantSecondClassifyService merchantSecondClassifyService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Boolean save(SecondClassifyDO secondClassifyDO) {
        insertSetDefaultValue(secondClassifyDO);
        boolean result = secondClassifyMapper.insertSelective(secondClassifyDO) < 1 ? false : true;
        if(result){
            redisUtil.setRedisList(CacheKeyPrefix.CLASSIFY_FIRST+CacheKeyPrefix.SEPARATOR+secondClassifyDO.getFirstClassifyId(),secondClassifyDO);
        }
        return result;
    }

    @Override
    public Boolean delete(Integer secondClassifyId) {
        MerchantSecondClassifyQuery merchantSecondClassifyQuery = new MerchantSecondClassifyQuery();
        merchantSecondClassifyQuery.setSecondClassifyId(secondClassifyId);
        List<MerchantSecondClassifyDO> merchantSecondClassifyDOList = merchantSecondClassifyService.list(merchantSecondClassifyQuery);
        if(merchantSecondClassifyDOList!=null&&merchantSecondClassifyDOList.size()>0){
            throw new SecondClassifyException("secondClassifyId{"+secondClassifyId+"}当前二级分类下有商户存在，不可直接进行删除",RequestCode.server_error);
        }

        SecondClassifyDO secondClassifyDO = secondClassifyMapper.selectByPrimaryKey(secondClassifyId);
        redisUtil.remove(CacheKeyPrefix.CLASSIFY_FIRST+CacheKeyPrefix.SEPARATOR+secondClassifyDO.getFirstClassifyId());
        return secondClassifyMapper.delete(secondClassifyId) < 1 ? false :true;
    }

    @Override
    public Boolean update(SecondClassifyDO secondClassifyDO) {
        if(secondClassifyDO.getFirstClassifyId()==null){
            SecondClassifyDO secondClassify = secondClassifyMapper.selectByPrimaryKey(secondClassifyDO.getId());
            secondClassifyDO.setFirstClassifyId(secondClassify.getFirstClassifyId());
        }
        redisUtil.remove(CacheKeyPrefix.CLASSIFY_FIRST+CacheKeyPrefix.SEPARATOR+secondClassifyDO.getFirstClassifyId());

        updateSetDefaultValue(secondClassifyDO);
        return secondClassifyMapper.updateByPrimaryKeySelective(secondClassifyDO)<1?false:true;
    }

    @Override
    public List<SecondClassifyDO> list(SecondClassifyQuery query) {
            List<SecondClassifyDO> secondClassifyList = secondClassifyMapper.list(query);
            return secondClassifyList;
    }
    @Override
    public List<SecondClassifyDO> list(Integer firstClassifyId) {
        List secondClassifyRedisList = redisUtil.getRedisList(CacheKeyPrefix.CLASSIFY_FIRST+CacheKeyPrefix.SEPARATOR+firstClassifyId);
        if (secondClassifyRedisList == null || secondClassifyRedisList.size() == 0) {
            SecondClassifyQuery secondClassifyQuery  = new SecondClassifyQuery();
            secondClassifyQuery.setFirstClassifyId(firstClassifyId);
            List<SecondClassifyDO> secondClassifyList = secondClassifyMapper.list(secondClassifyQuery);
            if(secondClassifyList!=null&&secondClassifyList.size()>0){
                redisUtil.setRedisList(CacheKeyPrefix.CLASSIFY_FIRST+CacheKeyPrefix.SEPARATOR+firstClassifyId, secondClassifyList,1L,TimeUnit.DAYS);
            }
            return secondClassifyList;
        }
        //由于redis中存储的不一定时跟排序号相关的有序性,所以进行重新排序
        Collections.sort(secondClassifyRedisList, new Comparator<SecondClassifyDO>() {
            @Override
            public int compare(SecondClassifyDO o1, SecondClassifyDO o2) {
                int sort1 = o1.getSortNumber()==null?0:o1.getSortNumber();
                int sort2 = o2.getSortNumber()==null?0:o2.getSortNumber();
                return sort1-sort2;
            }
        });
        return secondClassifyRedisList;
    }

    @Override
    public SecondClassifyDO getById(Integer id) {
        return secondClassifyMapper.selectByPrimaryKey(id);
    }
}
