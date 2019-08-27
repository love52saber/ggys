package net.seocoo.ggys.module.merchant.service.impl;

import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.constants.CacheKeyPrefix;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.module.merchant.entity.FirstClassifyDO;
import net.seocoo.ggys.module.merchant.entity.SecondClassifyDO;
import net.seocoo.ggys.module.merchant.exception.FirstClassifyException;
import net.seocoo.ggys.module.merchant.mapper.FirstClassifyMapper;
import net.seocoo.ggys.module.merchant.query.SecondClassifyQuery;
import net.seocoo.ggys.module.merchant.service.FirstClassifyService;
import net.seocoo.ggys.module.merchant.service.SecondClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 10:12
 * @Email xieheng91@163.com
 * @Desc 一级分类service
 */
@Service
public class FirstClassifyServiceImpl extends BaseService implements FirstClassifyService {
    @Autowired
    private FirstClassifyMapper firstClassifyMapper;

    @Autowired
    private SecondClassifyService secondClassifyService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Boolean save(FirstClassifyDO firstClassifyDO) {
        insertSetDefaultValue(firstClassifyDO);
        Boolean result = firstClassifyMapper.insertSelective(firstClassifyDO) < 1 ? false : true;
        if (result) {
            redisUtil.setRedisList(CacheKeyPrefix.CLASSIFY_FIRST,firstClassifyDO);
        }
        return result;
    }

    @Override
    public Boolean delete(Integer firstClassifyId) {
        List<SecondClassifyDO> listSecondClassify = secondClassifyService.list(firstClassifyId);
        if (listSecondClassify != null && listSecondClassify.size() > 0) {
            throw new FirstClassifyException("firstClassifyId{" + firstClassifyId + "},一级分类仍含有二级分类数据，不能直接删除", RequestCode.server_error);
        }
        redisUtil.remove(CacheKeyPrefix.CLASSIFY_FIRST);

        Boolean result = firstClassifyMapper.delete(firstClassifyId) < 1 ? false : true;

        return result;
    }

    @Override
    public Boolean update(FirstClassifyDO firstClassifyDO) {
        redisUtil.remove(CacheKeyPrefix.CLASSIFY_FIRST);
        updateSetDefaultValue(firstClassifyDO);
        return firstClassifyMapper.updateByPrimaryKeySelective(firstClassifyDO) < 1 ? false : true;
    }

    @Override
    public List<FirstClassifyDO> list(BaseQuery query) {

        List firstClassifyRedisList = redisUtil.getRedisList(CacheKeyPrefix.CLASSIFY_FIRST);
        if (firstClassifyRedisList == null || firstClassifyRedisList.size() == 0) {
            List<FirstClassifyDO> firstClassifyList = firstClassifyMapper.list(query);
            if(firstClassifyList!=null&&firstClassifyList.size()>0){
                redisUtil.setRedisList(CacheKeyPrefix.CLASSIFY_FIRST, firstClassifyList,1L,TimeUnit.DAYS);
            }
            return firstClassifyList;
        }
        //由于redis中存储的不一定时跟排序号相关的有序性,所以进行重新排序
        Collections.sort(firstClassifyRedisList, new Comparator<FirstClassifyDO>() {
            @Override
            public int compare(FirstClassifyDO o1, FirstClassifyDO o2) {
                int sort1 = o1.getSortNumber()==null?0:o1.getSortNumber();
                int sort2 = o2.getSortNumber()==null?0:o2.getSortNumber();
                return sort1-sort2;
            }
        });
        return firstClassifyRedisList;
    }


}
