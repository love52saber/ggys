package net.seocoo.ggys.module.merchant.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.CacheKeyPrefix;
import net.seocoo.ggys.core.constants.UserRoleEnum;
import net.seocoo.ggys.core.util.Pair;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.core.util.map.MapUtil;
import net.seocoo.ggys.module.goods.service.MerchantBaseGoodsService;
import net.seocoo.ggys.module.merchant.constans.MerchantFunctionEnum;
import net.seocoo.ggys.module.merchant.dto.H5CMerchantBaseDTO;
import net.seocoo.ggys.module.merchant.dto.H5CMerchantDTO;
import net.seocoo.ggys.module.merchant.entity.*;
import net.seocoo.ggys.module.merchant.exception.MerchantException;
import net.seocoo.ggys.module.merchant.form.MerchantForm;
import net.seocoo.ggys.module.merchant.mapper.MerchantMapper;
import net.seocoo.ggys.module.merchant.query.MerchantQuery;
import net.seocoo.ggys.module.merchant.query.MerchantSecondClassifyQuery;
import net.seocoo.ggys.module.merchant.service.MerchantLabelService;
import net.seocoo.ggys.module.merchant.service.MerchantSecondClassifyService;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.merchant.service.SecondClassifyService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author xieheng
 * @Data 2018/5/29 0029 17:56
 * @Email xieheng91@163.com
 * @Desc 商户service
 */
@Service
public class MerchantServiceImpl extends BaseService implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private SecondClassifyService secondClassifyService;

    @Autowired
    private MerchantSecondClassifyService merchantSecondClassifyService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MerchantLabelService merchantLabelService;

    @Autowired
    private MerchantBaseGoodsService merchantBaseGoodsService;

    /**
     * 商户信息保存
     *
     * @param merchantForm 表单提交对象
     * @return
     */
    @Override
    @Transactional
    public Boolean save(MerchantForm merchantForm) {

        //1.插入关联的商户用户信息
        Integer merchantUserId = saveUserInfo(merchantForm);

        //2.插入商户信息
        MerchantDO merchantDO = new MerchantDO();
        BeanUtils.copyProperties(merchantForm, merchantDO);
        insertSetDefaultValue(merchantDO);
        //商户id
        merchantDO.setMerchantUserId(merchantUserId);
        //商户功能
        String functionJson = JSONObject.toJSONString(merchantForm.getMerchantFunctionModelList());
        merchantDO.setMerchantFunction(functionJson);

        // 获得商户的经纬度信息
        setMerchantLatLon(merchantDO);

        Boolean merchantInsert = merchantMapper.insertSelective(merchantDO) < 1 ? false : true;
        merchantForm.setId(merchantDO.getId());

        //3.分类信息不为空时,插入关联的商户分类信息
        if (merchantForm.getClassifyIdList() != null && merchantForm.getClassifyIdList().size() > 0) {
            saveClassify(merchantForm);
        }
        return merchantInsert;
    }

    /**
     * 获取商家的经纬度信息。//TODO 以后使用异步或者消息队列获得
     *
     * @param merchantDO
     */
    private void setMerchantLatLon(MerchantDO merchantDO) {
        String latLng = MapUtil.getLatLng(merchantDO.getProvinceName() + merchantDO.getCityName() + merchantDO.getCountyName() + merchantDO.getAddress(), merchantDO.getCityName());
        if (StringUtils.isEmpty(latLng)) {
            throw new MerchantException("商家地址不正确,请重新输入", RequestCode.Operate_Tip);
        }
        String[] latLngArr = latLng.split(",");
        if (latLngArr.length == 2) {
            merchantDO.setLon(Double.parseDouble(latLngArr[0]));
            merchantDO.setLat(Double.parseDouble(latLngArr[1]));
        }
    }

    private Integer saveUserInfo(MerchantForm merchantForm) {
        if (!merchantForm.getPassword().equals(merchantForm.getConfirmPassword())) {
            throw new MerchantException("确认密码和密码不一致", RequestCode.server_error);
        }
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setLoginName(merchantForm.getLoginName());
        userInfoDO.setPassword(merchantForm.getPassword());
        userInfoDO.setUserRole(UserRoleEnum.MERCHANT);
        userInfoService.saveUserInfo(userInfoDO);
        //插入用户信息后的商户用户表id
        return userInfoDO.getId();
    }

    /**
     * 插入商户的关联行业分类表
     *
     * @param merchantForm
     * @param merchantForm
     * @return
     */
    private Boolean saveClassify(MerchantForm merchantForm) {
        //增加商户和分类中间表前先清除旧的关联信息
        merchantSecondClassifyService.deleteMerchantId(merchantForm.getId());

        List<MerchantSecondClassifyDO> list = new ArrayList<MerchantSecondClassifyDO>();
        MerchantSecondClassifyDO merchantSecondClassifyDO = null;
        for (Integer classifyId : merchantForm.getClassifyIdList()) {
            SecondClassifyDO secondClass = secondClassifyService.getById(classifyId);
            merchantSecondClassifyDO = new MerchantSecondClassifyDO();
            insertSetDefaultValue(merchantSecondClassifyDO);
            merchantSecondClassifyDO.setFirstClassifyId(secondClass.getFirstClassifyId());
            merchantSecondClassifyDO.setMerchantId(merchantForm.getId());
            merchantSecondClassifyDO.setSecondClassifyId(classifyId);
            list.add(merchantSecondClassifyDO);
        }
        return merchantSecondClassifyService.insertBatch(list);
    }


    @Override
    public Boolean delete(Integer merchantId) {
        return merchantMapper.delete(merchantId) < 1 ? false : true;
    }

    @Override
    @Transactional
    public Boolean update(MerchantForm merchantForm) {
        MerchantDO merchantDO = new MerchantDO();
        BeanUtils.copyProperties(merchantForm, merchantDO);
        updateSetDefaultValue(merchantDO);

        String functionJson = null;
        if (merchantForm.getMerchantFunctionModelList() != null && merchantForm.getMerchantFunctionModelList().size() > 0) {
            functionJson = JSONObject.toJSONString(merchantForm.getMerchantFunctionModelList());
            merchantDO.setMerchantFunction(functionJson);
        }

        if (merchantForm.getClassifyIdList() != null && merchantForm.getClassifyIdList().size() > 0) {
            saveClassify(merchantForm);
        }
        setMerchantLatLon(merchantDO);
        return merchantMapper.updateByPrimaryKeySelective(merchantDO) < 1 ? false : true;
    }

    @Override
    public List<MerchantDO> list(MerchantQuery baseQuery) {


        return merchantMapper.list(baseQuery);
    }

    @Override
    public PageBean<MerchantDTO> page(MerchantQuery merchantQuery) {

        setIdListByFirstClassifyId(merchantQuery);

        setIdListBySecondClassifyId(merchantQuery);

        PageHelper.startPage(merchantQuery.getPageNum(), merchantQuery.getPageSize());
        List<MerchantDO> merchantList = merchantMapper.list(merchantQuery);

        List<MerchantDTO> merchantDTOList = new ArrayList<>();
        for (MerchantDO merchantDO : merchantList) {
            MerchantDTO merchantDTO = new MerchantDTO();
            BeanUtils.copyProperties(merchantDO, merchantDTO);
            if (merchantDO.getMerchantUserId() != null) {
                UserInfoDO merchantUser = userInfoService.getUserInfoById(merchantDO.getMerchantUserId());
                merchantDTO.setLoginName(merchantUser.getLoginName());
            }
            if (merchantDO.getManageUserId() != null) {
                UserInfoDO manageUser = userInfoService.getUserInfoById(merchantDO.getManageUserId());
                merchantDTO.setManageUserName(manageUser.getFullName());
            }

            extendMerchant(merchantDO, merchantDTO);


            merchantDTOList.add(merchantDTO);
        }
        return new PageBean<MerchantDTO>(merchantDTOList, merchantQuery.getPageNum(), merchantQuery.getPageSize(), merchantMapper.count(merchantQuery));
    }

    /**
     * 根据二级分类id设置商户id集合
     *
     * @param merchantQuery
     */
    private void setIdListBySecondClassifyId(MerchantQuery merchantQuery) {
        if (merchantQuery.getSecondClassifyId() != null) {
            MerchantSecondClassifyQuery merchantSecondClassifyQuery = new MerchantSecondClassifyQuery();
            merchantSecondClassifyQuery.setSecondClassifyId(merchantQuery.getSecondClassifyId());
            List<MerchantSecondClassifyDO> merchantSecondClassifyDOList = merchantSecondClassifyService.list(merchantSecondClassifyQuery);
            List<Integer> merchantIdList = new ArrayList<>(merchantSecondClassifyDOList.size());
            for (MerchantSecondClassifyDO merchantSecondClassifyDO : merchantSecondClassifyDOList) {
                merchantIdList.add(merchantSecondClassifyDO.getMerchantId());
            }
            merchantQuery.setIdList(merchantIdList);
        }
    }

    /**
     * 根据一级分类id设置商户id集合
     *
     * @param merchantQuery
     */
    private void setIdListByFirstClassifyId(MerchantQuery merchantQuery) {
        if (merchantQuery.getFirstClassifyId() != null) {
            MerchantSecondClassifyQuery merchantSecondClassifyQuery = new MerchantSecondClassifyQuery();
            merchantSecondClassifyQuery.setFirstClassifyId(merchantQuery.getFirstClassifyId());
            List<MerchantSecondClassifyDO> merchantSecondClassifyDOList = merchantSecondClassifyService.list(merchantSecondClassifyQuery);

            List<Integer> merchantIdList = new ArrayList<>(merchantSecondClassifyDOList.size());
            for (MerchantSecondClassifyDO merchantSecondClassifyDO : merchantSecondClassifyDOList) {
                merchantIdList.add(merchantSecondClassifyDO.getMerchantId());
            }
            merchantQuery.setIdList(merchantIdList);
        }
    }

    /**
     * 补充商户的扩展信息
     *
     * @param merchantDO
     * @param merchantDTO
     */
    private void extendMerchant(MerchantDO merchantDO, MerchantDTO merchantDTO) {
        //商户功能集合
        if (!StringEx.stringIsNullOrEmpty(merchantDO.getMerchantFunction())) {
            merchantDTO.setMerchantFunctionModelList(JSONArray.parseArray(merchantDO.getMerchantFunction(), MerchantFunctionEnum.class));
        }
        //商户分类id集合
        MerchantSecondClassifyQuery secondClassifyQuery = new MerchantSecondClassifyQuery();
        secondClassifyQuery.setMerchantId(merchantDO.getId());
        List<MerchantSecondClassifyDO> secondClassifyDOList = merchantSecondClassifyService.list(secondClassifyQuery);
        if (secondClassifyDOList != null && secondClassifyDOList.size() > 0) {
            List<Integer> classifyIdList = new ArrayList<Integer>();
            List<String> classifyNameList = new ArrayList<>();
            for (MerchantSecondClassifyDO secondClassifyDO : secondClassifyDOList) {
                classifyIdList.add(secondClassifyDO.getSecondClassifyId());
                SecondClassifyDO second = secondClassifyService.getById(secondClassifyDO.getSecondClassifyId());
                if (second != null) {
                    classifyNameList.add(second.getName());
                }
            }
            merchantDTO.setClassifyIdList(classifyIdList);
            merchantDTO.setClassifyNameList(classifyNameList);
        }
        //商户标签集合
        List<String> labels = merchantLabelService.listNameByMerchantId(merchantDO.getId());
        merchantDTO.setLabelList(labels);
    }

    @Override
    public MerchantDO get(MerchantQuery baseQuery) {
        List<MerchantDO> list = list(baseQuery);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public MerchantDTO get(Integer merchantId,UserInfoDO currUser) {
        //TODO 考虑是否使用缓存
        MerchantDO merchantDO = merchantMapper.selectByPrimaryKey(merchantId);
        MerchantDTO merchantDTO = new MerchantDTO();
        BeanUtils.copyProperties(merchantDO, merchantDTO);

        String minPrice = merchantBaseGoodsService.getMinimumPriceByMerchantId(merchantId).toPlainString();
        merchantDTO.setMinPrice(minPrice);

        if(currUser.getUserRole().equals(UserRoleEnum.NORMAL)){
            Double distance = MapUtil.GetDistance(merchantDO.getLat(), merchantDO.getLon(), currUser.getLat(), currUser.getLng());
            merchantDTO.setDistance(distance);
        }

        extendMerchant(merchantDO, merchantDTO);

        return merchantDTO;
    }

    @Override
    public MerchantDTO get(Integer merchantId) {
        //TODO 考虑是否使用缓存
        MerchantDO merchantDO = merchantMapper.selectByPrimaryKey(merchantId);
        MerchantDTO merchantDTO = new MerchantDTO();
        BeanUtils.copyProperties(merchantDO, merchantDTO);
        extendMerchant(merchantDO, merchantDTO);
        return merchantDTO;
    }

    @Override
    public Integer getMerchantIdByMerchantUserId(Integer merchantUserId) {
        MerchantDO merchantDO = this.getMerchantByMerchantUserId(merchantUserId);
        return merchantDO != null ? merchantDO.getId() : null;
    }


    @Override
    public MerchantDO getMerchantByMerchantUserId(Integer merchantUserId) {
        MerchantDO merchantDO = (MerchantDO) redisUtil.get(CacheKeyPrefix.MERCHANT_USER_ID + merchantUserId);
        if (merchantDO == null) {
            MerchantQuery merchantQuery = new MerchantQuery();
            merchantQuery.setMerchantUserId(merchantUserId);
            merchantDO = merchantMapper.get(merchantQuery);
            if (merchantDO != null) {
                redisUtil.set(CacheKeyPrefix.MERCHANT_USER_ID + merchantUserId, merchantDO, 12L, TimeUnit.HOURS);
            }
        }
        return merchantDO;
    }

    @Override
    public List<MerchantFunctionEnum> getFunction(Integer merchantId) {
        String functionJson = merchantMapper.getFunction(merchantId);
        return JSONArray.parseArray(functionJson, MerchantFunctionEnum.class);
    }

    @Override
    public List<MerchantDO> listBySecondClassifyAndCityId(MerchantQuery query) {
        if (query.getSecondClassifyId() == null || query.getCityId() == null) {
            throw new MerchantException("二级分类或城市为空", RequestCode.missingParameter_error);
        }
        setIdListBySecondClassifyId(query);

        // 查询二级分类下的市级商家集合
        List<MerchantDO> merchantList = redisUtil.getRedisList(CacheKeyPrefix.MERCHANT_CLASSIFY_SECOND_CITY + query.getSecondClassifyId() + CacheKeyPrefix.SEPARATOR + query.getCityId());
        if (merchantList.isEmpty()) {
            merchantList = this.list(query);
            if (merchantList != null && !merchantList.isEmpty()) {
                redisUtil.setRedisList(CacheKeyPrefix.MERCHANT_CLASSIFY_SECOND_CITY + query.getSecondClassifyId() + CacheKeyPrefix.SEPARATOR + query.getCityId(), merchantList, 1L, TimeUnit.DAYS);
            }
        }
        return merchantList;
    }

    @Override
    public List<MerchantDO> listByFirstClassifyAndCityId(MerchantQuery query) {
        if (query.getFirstClassifyId() == null || query.getCityId() == null) {
            throw new MerchantException("一级分类或城市为空", RequestCode.missingParameter_error);
        }
        setIdListByFirstClassifyId(query);

        // 查询一级分类下的市级商家集合
        List<MerchantDO> merchantList = redisUtil.getRedisList(CacheKeyPrefix.MERCHANT_CLASSIFY_FIRST_CITY + query.getFirstClassifyId() + CacheKeyPrefix.SEPARATOR + query.getCityId());
        if (merchantList.isEmpty()) {
            merchantList = this.list(query);
            if (merchantList != null && !merchantList.isEmpty()) {
                redisUtil.setRedisList(CacheKeyPrefix.MERCHANT_CLASSIFY_FIRST_CITY + query.getFirstClassifyId() + CacheKeyPrefix.SEPARATOR + query.getCityId(), merchantList, 1L, TimeUnit.DAYS);
            }
        }
        return merchantList;
    }


    @Override
    public H5CMerchantBaseDTO listClientH5Index(MerchantQuery query, UserInfoDO userInfo) {

        List<MerchantDO> merchantList = null;
        if (query.getFirstClassifyId() != null && query.getFirstClassifyId() > 0) {
            merchantList = this.listByFirstClassifyAndCityId(query);
        } else if (query.getSecondClassifyId() != null && query.getSecondClassifyId() > 0) {
            merchantList = this.listBySecondClassifyAndCityId(query);
        } else {
            //TODO 测试数据需要
            merchantList = redisUtil.getRedisList(CacheKeyPrefix.MERCHANT_CLASSIFY_SECOND + query.getSecondClassifyId());
            if (merchantList.isEmpty()) {
                merchantList = this.list(query);
                if (merchantList != null && !merchantList.isEmpty()) {
                    redisUtil.setRedisList(CacheKeyPrefix.MERCHANT_CLASSIFY_SECOND + query.getSecondClassifyId(), merchantList, 1L, TimeUnit.DAYS);
                }
            }
        }

        String key = userInfo.getToken() + "_" + userInfo.getLng() + "_" + userInfo.getLat();
        if (query.getFirstClassifyId() != null) {
            key += "_firstId_" + query.getFirstClassifyId();
        }
        if (query.getSecondClassifyId() != null) {
            key += "_secondId_" + query.getSecondClassifyId();
        }
        if (!redisUtil.exists(key)) {
            for (MerchantDO merchantDO : merchantList) {
                Double distance = MapUtil.GetDistance(merchantDO.getLat(), merchantDO.getLon(), userInfo.getLat(), userInfo.getLng());
                redisUtil.addRedisZSet(key, new Pair<Integer, Double>(merchantDO.getId(), distance), distance);
            }

        }
        // 分页从redis查询
        long start = (query.getPageNum() - 1) * query.getPageSize();
        long end = query.getPageNum() * query.getPageSize() - 1;
        Set<Pair<Integer, Double>> merchentSet = redisUtil.getZSetRang(key, start, end);

        H5CMerchantBaseDTO h5CMerchantBaseDTO = new H5CMerchantBaseDTO();
        h5CMerchantBaseDTO.setCount(redisUtil.getZSetSize(key));
        h5CMerchantBaseDTO.setPageNum(query.getPageNum());
        h5CMerchantBaseDTO.setPageSize(query.getPageSize());

        List<H5CMerchantDTO> h5CMerchantList = new ArrayList<>(merchentSet.size());
        List<MerchantLabelDO> merchantLabelList = null;
        List<String> merchantLabelNameList = null;
        H5CMerchantDTO h5CMerchantDTO = null;

        for (Pair<Integer, Double> pair : merchentSet) {
            h5CMerchantDTO = new H5CMerchantDTO();
            h5CMerchantDTO.setDistance(pair.getRight());
            h5CMerchantDTO.setId(pair.getLeft());

            // 商家标签集合
            merchantLabelList = this.merchantLabelService.listByMerchantId(pair.getLeft());
            if (merchantLabelList != null && !merchantLabelList.isEmpty()) {
                merchantLabelNameList = new ArrayList<>(merchantLabelList.size());
                for (MerchantLabelDO merchantLabelDO : merchantLabelList) {
                    merchantLabelNameList.add(merchantLabelDO.getName());
                }
                h5CMerchantDTO.setMerchantLabel(merchantLabelNameList);
            }

            // 商家信息
            MerchantDTO merchantDTO = this.get(pair.getLeft());
            h5CMerchantDTO.setLogoUrl(merchantDTO.getLogoUrl());
            h5CMerchantDTO.setName(merchantDTO.getName());

            //商户用户信息,设置环信用户账号
            UserInfoDO merchantUser = userInfoService.getUserInfoById(merchantDTO.getMerchantUserId());
            if (merchantUser != null) {
                h5CMerchantDTO.setUserNameEmchant(merchantUser.getUuid());
            }

            // 商家二级分类
            if (query.getSecondClassifyId() != null && query.getSecondClassifyId().intValue() > 0) {
                SecondClassifyDO secondClassifyDO = this.secondClassifyService.getById(query.getSecondClassifyId());
                if (secondClassifyDO != null) {
                    h5CMerchantDTO.setSecondName(secondClassifyDO.getName());
                }
            } else if (query.getFirstClassifyId() != null && query.getFirstClassifyId().intValue() > 0) {
                //
                List<MerchantSecondClassifyDO> merchantSecondClassifyDOList = this.merchantSecondClassifyService.listByMerchantIdFirstId(pair.getLeft(), query.getFirstClassifyId());
                if (merchantSecondClassifyDOList != null && !merchantSecondClassifyDOList.isEmpty()) {
                    SecondClassifyDO secondClassifyDO = this.secondClassifyService.getById(merchantSecondClassifyDOList.get(0).getSecondClassifyId());
                    if (secondClassifyDO != null) {
                        h5CMerchantDTO.setSecondName(secondClassifyDO.getName());
                    }
                }
            }

            // 商家的最低价格
            h5CMerchantDTO.setMinPrice(merchantBaseGoodsService.getMinimumPriceByMerchantId(pair.getLeft()).toPlainString());

            h5CMerchantList.add(h5CMerchantDTO);
        }
        h5CMerchantBaseDTO.setList(h5CMerchantList);
        return h5CMerchantBaseDTO;
    }

    @Override
    public MerchantDTO getMerchantByUserId(Integer userId) {
        Integer merchantId = getMerchantIdByMerchantUserId(userId);
        return get(merchantId);
    }

}
