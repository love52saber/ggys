package net.seocoo.ggys.module.member.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.CacheKeyPrefix;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.util.Pair;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.core.util.map.MapUtil;
import net.seocoo.ggys.module.member.dto.MemberCardInfoListDTO;
import net.seocoo.ggys.module.member.dto.MemberMerchantListDTO;
import net.seocoo.ggys.module.member.entity.MemberCardConsumeRecordDO;
import net.seocoo.ggys.module.member.form.MemberCardForm;
import net.seocoo.ggys.module.member.entity.MemberCardRechargeRecordDO;
import net.seocoo.ggys.module.member.entity.MemberCardInfoDO;
import net.seocoo.ggys.module.member.entity.MemberCardRechargeRuleDO;
import net.seocoo.ggys.module.member.exception.MemberCardException;
import net.seocoo.ggys.module.member.mapper.MemberCardInfoMapper;
import net.seocoo.ggys.module.member.query.MemberCardConsumeRecordQuery;
import net.seocoo.ggys.module.member.query.MemberCardInfoQuery;
import net.seocoo.ggys.module.member.query.MemberCardRechargeRuleQuery;
import net.seocoo.ggys.module.member.service.MemberCardConsumeRecordService;
import net.seocoo.ggys.module.member.service.MemberCardInfoService;
import net.seocoo.ggys.module.member.service.MemberCardRechargeRecordService;
import net.seocoo.ggys.module.member.service.MemberCardRechargeRuleService;
import net.seocoo.ggys.module.merchant.dto.H5CMerchantBaseDTO;
import net.seocoo.ggys.module.merchant.dto.H5CMerchantDTO;
import net.seocoo.ggys.module.merchant.entity.*;
import net.seocoo.ggys.module.merchant.query.MerchantQuery;
import net.seocoo.ggys.module.merchant.service.MerchantLabelService;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author PanChengHao
 * @date 2018/6/1 10:40
 */
@Service
public class MemberCardInfoServiceImpl extends BaseService implements MemberCardInfoService {
  @Autowired
  private MemberCardInfoMapper memberCardInfoMapper;

  @Autowired
  private MemberCardRechargeRuleService memberCardRechargeRuleService;

  @Autowired
  private MemberCardRechargeRecordService memberCardRechargeRecordService;

  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private MerchantService merchantService;

  @Autowired
  private MemberCardConsumeRecordService memberCardConsumeRecordService;

  @Autowired
  private RedisUtil redisUtil;

  @Autowired
  private MerchantLabelService merchantLabelService;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void saveMemberCardInfo(MemberCardForm memberCard) {
    MemberCardInfoDO record = selectMemberCardInfoByUserIdMerchantId(memberCard.getUserId(), memberCard.getMerchantId());
    if (record != null) {
      throw new MemberCardException("您已办卡，请勿重复办卡", RequestCode.Operate_Tip);
    }
    MemberCardInfoDO memberCardInfoDO = new MemberCardInfoDO();
    BeanUtils.copyProperties(memberCard, memberCardInfoDO);
    memberCardInfoDO.setUuid(StringEx.newUUID());
    memberCardInfoDO.setMemberCardNo(StringEx.getOrderIdByTime());
    memberCardInfoDO.setCreateDate(new Date());
    memberCardInfoDO.setCanDeleted(YesNoEnum.N);
    //根据id查询充值规则id,注意：此处需要调用支付接口进行充值
    MemberCardRechargeRuleDO memberCardRechargeRuleDO = memberCardRechargeRuleService.getMemberCardRechargeRuleById(memberCard.getRechargeRuleId());
    if (memberCardRechargeRuleDO == null) {
      throw new MemberCardException("ID=" + memberCard.getRechargeRuleId() + "的充值规则不存在", 500);
    }
    BigDecimal totalMoney = memberCardRechargeRuleDO.getGiftMoney().add(memberCardRechargeRuleDO.getRechargeMoney());
    memberCardInfoDO.setRemainingMoney(totalMoney);
    memberCardInfoDO.setRechargeTotalMoney(memberCardRechargeRuleDO.getRechargeMoney());
    this.memberCardInfoMapper.insert(memberCardInfoDO);

    //向充值记录表插入记录
    MemberCardRechargeRecordDO memberCardIRechargeRecordDO = new MemberCardRechargeRecordDO();
    memberCardIRechargeRecordDO.setUuid(StringEx.newUUID());
    memberCardIRechargeRecordDO.setTransactionNo(StringEx.getOrderIdByTime());
    memberCardIRechargeRecordDO.setMerchantId(memberCard.getMerchantId());
    memberCardIRechargeRecordDO.setRemainingMoney(memberCard.getRemainingMoney());
    memberCardIRechargeRecordDO.setCreateDate(new Date());
    memberCardIRechargeRecordDO.setGiftMoney(memberCardRechargeRuleDO.getGiftMoney());
    memberCardIRechargeRecordDO.setRechargeDate(new Date());
    memberCardIRechargeRecordDO.setCanDeleted(YesNoEnum.N);
    memberCardIRechargeRecordDO.setUserId(memberCard.getUserId());
    memberCardIRechargeRecordDO.setMemberCardId(memberCardInfoDO.getId());
    memberCardIRechargeRecordDO.setRechargeMoney(memberCardRechargeRuleDO.getRechargeMoney());
    memberCardIRechargeRecordDO.setRechargeTotalMoney(totalMoney);
    memberCardIRechargeRecordDO.setRemainingMoney(totalMoney);
    memberCardIRechargeRecordDO.setPayType(memberCard.getPayType());
    this.memberCardRechargeRecordService.saveMemberCardRechargeRecord(memberCardIRechargeRecordDO);
  }

  @Override
  public MemberCardInfoDO getMemberCardInfoById(int id) {
    return this.memberCardInfoMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateById(MemberCardInfoDO memberCardInfoDO) {
    return this.memberCardInfoMapper.updateByPrimaryKey(memberCardInfoDO);
  }

  @Override
  public void updateSelectiveById(MemberCardInfoDO memberCardInfoDO) {
    MemberCardInfoDO record = this.memberCardInfoMapper.selectByPrimaryKey(memberCardInfoDO.getId());
    if (record == null) {
      throw new MemberCardException("ID=" + memberCardInfoDO.getId() + "的会员卡信息不存在", RequestCode.server_error);
    }
    memberCardInfoDO.setUpdateDate(new Date());
    this.memberCardInfoMapper.updateByPrimaryKeySelective(memberCardInfoDO);
  }

  @Override
  public void deleteById(int id) {
    MemberCardInfoDO memberCardInfoDO = this.getMemberCardInfoById(id);
    if (memberCardInfoDO == null) {
      throw new MemberCardException("ID=" + id + "的会员卡不存在", 500);
    } else {
      memberCardInfoDO.setCanDeleted(YesNoEnum.Y);
      this.memberCardInfoMapper.updateByPrimaryKey(memberCardInfoDO);
    }
  }

  @Override
  public PageBean<MemberCardInfoListDTO> listByPageQuery(MemberCardInfoQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());
    List<MemberCardInfoDO> memberCardInfoDOList = this.memberCardInfoMapper.listByPageQuery(query);
    List userIdList = new ArrayList();
    //根据userId查询userInfo表获取昵称
    if (memberCardInfoDOList != null && memberCardInfoDOList.size() > 0) {
      for (MemberCardInfoDO memberCardInfoDO : memberCardInfoDOList) {
        userIdList.add(memberCardInfoDO.getUserId());
      }
    }
    List<UserInfoDO> userInfoDOList = null;
    if (userIdList != null && userIdList.size() > 0) {
      userInfoDOList = this.userInfoService.queryUserInfoListByUserIdList(userIdList);
    }
    List<MemberCardInfoListDTO> memberCardInfoListDTOList = new ArrayList<>();
    if (memberCardInfoDOList != null && memberCardInfoDOList.size() > 0 && userInfoDOList != null && userInfoDOList.size() > 0) {
      for (MemberCardInfoDO memberCardInfoDO : memberCardInfoDOList) {
        MemberCardInfoListDTO memberCardInfoListDTO = new MemberCardInfoListDTO();
        BeanUtils.copyProperties(memberCardInfoDO, memberCardInfoListDTO);
        for (UserInfoDO userInfoDO : userInfoDOList) {
          if (userInfoDO.getId().equals(memberCardInfoDO.getUserId())) {
            memberCardInfoListDTO.setNickname(userInfoDO.getNickname());
            memberCardInfoListDTOList.add(memberCardInfoListDTO);
            break;
          }
        }
      }
    }
    return new PageBean<>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), memberCardInfoListDTOList);
  }

  @Override
  public Integer countByQuery(MemberCardInfoQuery query) {
    return this.memberCardInfoMapper.countByQuery(query);
  }

  @Override
  public MemberCardInfoDO selectByMemberCardNo(String memberCardNo) {
    return this.memberCardInfoMapper.selectByMemberCardNo(memberCardNo);
  }

  /**
   * 根据userId和merchantId查询会员卡信息
   *
   * @param userId merchantId
   * @return 会员卡信息
   */
  @Override
  public MemberCardInfoDO selectMemberCardInfoByUserIdMerchantId(Integer userId, Integer merchantId) {
    MemberCardInfoDO memberCardInfoDO = new MemberCardInfoDO();
    memberCardInfoDO.setMerchantId(merchantId);
    memberCardInfoDO.setUserId(userId);
    List<MemberCardInfoDO> memberCardInfoDOList = this.memberCardInfoMapper.selectMemberCardInfoByUserIdMerchantId(memberCardInfoDO);
    MemberCardInfoDO record = null;
    if (memberCardInfoDOList != null && memberCardInfoDOList.size() > 0) {
      record = memberCardInfoDOList.get(0);
    }
    return record;
  }

  /**
   * 根据userId,merchantId查询会员卡余额
   *
   * @param userId     merchantId
   * @param merchantId
   * @return 会员卡余额
   */
  @Override
  public BigDecimal selectMemberCardRemainingMoney(Integer userId, Integer merchantId) {
    MemberCardInfoDO memberCardInfoDO = new MemberCardInfoDO();
    memberCardInfoDO.setUserId(userId);
    memberCardInfoDO.setMerchantId(merchantId);
    MemberCardInfoDO record = this.memberCardInfoMapper.selectMemberCardRemainingMoney(memberCardInfoDO);
    if (record != null) {
      return record.getRemainingMoney();
    }
    return null;
  }

  /**
   * 查询会员卡消费是否可用
   *
   * @param id           会员卡id
   * @param consumeMoney
   * @return true可用  false不可用
   */
  @Override
  public Boolean canUsedMemberCardInfo(Integer id, BigDecimal consumeMoney) {
    MemberCardInfoDO memberCardInfoDO = this.memberCardInfoMapper.selectByPrimaryKey(id);
    Boolean flag = false;
    if (memberCardInfoDO != null) {
      BigDecimal remainingMoney = memberCardInfoDO.getRemainingMoney();
      int a = remainingMoney.compareTo(consumeMoney);
      if (a == 0 || a == 1) {
        flag = true;
      }
    }
    return flag;
  }

  /**
   * 获取我已办卡的商家列表并按距离排序
   *
   * @param userInfoDO
   * @return 会员卡集合
   */
  @Override
  public H5CMerchantBaseDTO selectListMemberCardInfoByUserId(UserInfoDO userInfoDO, BaseQuery query) {
    Long startTime0 = System.currentTimeMillis();
    MemberCardInfoDO memberCardInfoDO = new MemberCardInfoDO();
    memberCardInfoDO.setUserId(userInfoDO.getId());
    List<MemberCardInfoDO> memberCardInfoDOList = memberCardInfoMapper.selectMemberCardInfoByUserIdMerchantId(memberCardInfoDO);
    List<Integer> merchantIdList = new ArrayList<>();
    if (memberCardInfoDOList != null && memberCardInfoDOList.size() > 0) {
      for (MemberCardInfoDO m : memberCardInfoDOList) {
        merchantIdList.add(m.getMerchantId());
      }
    }
    //根据merchantId集合查询商家列表
    List<MerchantDO> merchantDOList = null;
    if (merchantIdList != null && merchantIdList.size() > 0) {
      MerchantQuery query1 = new MerchantQuery();
      query1.setIdList(merchantIdList);
      merchantDOList = this.merchantService.list(query1);
    }
    //放入redis缓存中
    // 分页从redis查询
    long start = (query.getPageNum() - 1) * query.getPageSize();
    long end = query.getPageNum() * query.getPageSize() - 1;
    String key = CacheKeyPrefix.MEMBER_MERCHANT_DISTANCE_NEAREST + CacheKeyPrefix.USER_INFO_ID + userInfoDO.getId();
    Set<Pair<Integer, Double>> memberMerchantSet = null;
    if (!redisUtil.exists(key)) {
      if (merchantDOList != null && merchantDOList.size() > 0) {
        for (MerchantDO merchantDO : merchantDOList) {
          Double distance = MapUtil
              .GetDistance(userInfoDO.getLat(), userInfoDO.getLng(), merchantDO.getLat(), merchantDO.getLon());
          redisUtil.addRedisZSet(key, new Pair<>(merchantDO.getId(), distance), distance);
        }
      }
    } else {
      //判断，如果数据改变，先把缓存清空，再重新放入缓存
      memberMerchantSet = redisUtil.getZSetRang(key, start, end);
      if (memberMerchantSet != null && merchantDOList != null && memberMerchantSet.size() != merchantDOList.size()) {
        redisUtil.remove(key);
        for (MerchantDO merchantDO : merchantDOList) {
          Double distance = MapUtil
              .GetDistance(userInfoDO.getLat(), userInfoDO.getLng(), merchantDO.getLat(), merchantDO.getLon());
          redisUtil.addRedisZSet(key, new Pair<>(merchantDO.getId(), distance), distance);
        }
      }
    }
    memberMerchantSet = redisUtil.getZSetRang(key, start, end);
    H5CMerchantBaseDTO h5CMerchantBaseDTO = new H5CMerchantBaseDTO();
    h5CMerchantBaseDTO.setCount(redisUtil.getZSetSize(key));
    h5CMerchantBaseDTO.setPageNum(query.getPageNum());
    h5CMerchantBaseDTO.setPageSize(query.getPageSize());

    List<MemberMerchantListDTO> nearestMemberMerchant = new ArrayList<>(memberMerchantSet.size());
    List<String> merchantLabelNameList = null;
    MemberMerchantListDTO memberMerchantListDTO = null;

    for (Pair<Integer, Double> pair : memberMerchantSet) {
      memberMerchantListDTO = new MemberMerchantListDTO();
      memberMerchantListDTO.setDistance(pair.getRight());
      memberMerchantListDTO.setMerchantId(pair.getLeft());

      //向DTO对象塞入会员卡编号、余额值
      for (MemberCardInfoDO memberCardInfoDO1 : memberCardInfoDOList) {
        if (pair.getLeft().equals(memberCardInfoDO1.getMerchantId())) {
          memberMerchantListDTO.setMemberCardNo(memberCardInfoDO1.getMemberCardNo());
          memberMerchantListDTO.setRemainingMoney(memberCardInfoDO1.getRemainingMoney());
          break;
        }
      }
      // 查询商家标签集合
      merchantLabelNameList = merchantLabelService.listNameByMerchantId(pair.getLeft());
      memberMerchantListDTO.setMerchantLabel(merchantLabelNameList);
      // 商家信息
      MerchantQuery merchantQuery = new MerchantQuery();
      merchantQuery.setId(pair.getLeft());
      MerchantDO merchantDO = this.merchantService.get(merchantQuery);
      memberMerchantListDTO.setLogoUrl(merchantDO.getLogoUrl());
      memberMerchantListDTO.setMerchantName(merchantDO.getName());
      nearestMemberMerchant.add(memberMerchantListDTO);
    }
    h5CMerchantBaseDTO.setList(nearestMemberMerchant);
    logger.info("totalUsedTimes:" + (System.currentTimeMillis() - startTime0) + "ms");
    return h5CMerchantBaseDTO;
  }

  @Override
  public PageBean<MemberCardInfoListDTO> selectListRecentlyConsumeMemberCardInfo(MemberCardConsumeRecordQuery query) {
    PageBean<MemberCardConsumeRecordDO> pageBean = memberCardConsumeRecordService.listByPageQueryGroupByMerchantId(query);
    List<MemberCardConsumeRecordDO> memberCardConsumeRecordDOList = null;
    if (pageBean != null) {
      memberCardConsumeRecordDOList = pageBean.getList();
    }
    List<Integer> merchantIdList = new ArrayList<>();
    if (memberCardConsumeRecordDOList != null && memberCardConsumeRecordDOList.size() > 0) {
      for (MemberCardConsumeRecordDO memberCardConsumeRecordDO : memberCardConsumeRecordDOList) {
        merchantIdList.add(memberCardConsumeRecordDO.getMerchantId());
      }
    }
    //根据merchantId集合查询商家列表
    List<MerchantDO> merchantDOList = null;
    if (merchantIdList != null && merchantIdList.size() > 0) {
      MerchantQuery merchantQuery = new MerchantQuery();
      merchantQuery.setIdList(merchantIdList);
      merchantDOList = this.merchantService.list(merchantQuery);
    }
    //查询我在对应商家的会员卡
    MemberCardInfoQuery memberCardInfoQuery = new MemberCardInfoQuery();
    memberCardInfoQuery.setUserId(query.getUserId());
    memberCardInfoQuery.setMerchantIdList(merchantIdList);
    List<MemberCardInfoDO> memberCardInfoDOList = memberCardInfoMapper.listByPageQuery(memberCardInfoQuery);
    //根据merchantId匹配，将商家简称和logo存到会员卡信息里
    List<MemberCardInfoListDTO> memberCardInfoListDTOList1 = new ArrayList<>();
    if (merchantDOList != null && merchantDOList.size() > 0 && memberCardInfoDOList != null && memberCardInfoDOList.size() > 0) {
      for (MemberCardInfoDO memberCardInfoDO1 : memberCardInfoDOList) {
        MemberCardInfoListDTO memberCardInfoListDTO = new MemberCardInfoListDTO();
        BeanUtils.copyProperties(memberCardInfoDO1, memberCardInfoListDTO);
        for (MerchantDO merchant : merchantDOList) {
          if (merchant.getId().equals(memberCardInfoDO1.getMerchantId())) {
            memberCardInfoListDTO.setLogoUrl(merchant.getLogoUrl());
            memberCardInfoListDTO.setMerchantName(merchant.getName());
            break;
          }
        }
        memberCardInfoListDTOList1.add(memberCardInfoListDTO);
      }
    }
    return new PageBean(pageBean.getPageNum(), pageBean.getPageSize(), pageBean.getCount(), memberCardInfoListDTOList1);
  }

  /**
   * 查询有会员的商家并且我没有办理会员卡
   *
   * @param userInfoDO
   * @return 商家集合
   */
  @Override
  public H5CMerchantBaseDTO selectMemberMerchantList(UserInfoDO userInfoDO, MemberCardRechargeRuleQuery query) {
    Long startTime0 = System.currentTimeMillis();
    query.setUserId(userInfoDO.getId());
    List<MemberCardRechargeRuleDO> memberCardRechargeRuleDOList = this
        .memberCardRechargeRuleService.listMemberCardRechargeRuleByDistinct(query);
    List<Integer> merchantIdList = new ArrayList<>();
    if (memberCardRechargeRuleDOList != null && memberCardRechargeRuleDOList.size() > 0) {
      for (MemberCardRechargeRuleDO memberCardRechargeRuleDO : memberCardRechargeRuleDOList) {
        merchantIdList.add(memberCardRechargeRuleDO.getMerchantId());
      }
    }
    List<MerchantDO> merchantDOList = null;
    if (merchantIdList != null && merchantIdList.size() > 0) {
      MerchantQuery merchantQuery = new MerchantQuery();
      merchantQuery.setIdList(merchantIdList);
      merchantDOList = this.merchantService.list(merchantQuery);
    }
    //放入redis缓存中
    // 分页从redis查询
    long start = (query.getPageNum() - 1) * query.getPageSize();
    long end = query.getPageNum() * query.getPageSize() - 1;
    Set<Pair<Integer, Double>> memberMerchantSet = null;
    String key = CacheKeyPrefix.MEMBER_MERCHANT + CacheKeyPrefix.USER_INFO_ID + userInfoDO.getId();
    if (!redisUtil.exists(key)) {
      setMerchantDOList(key, merchantDOList, userInfoDO);
    } else {
      memberMerchantSet = redisUtil.getZSetRang(key, start, end);
      if (merchantDOList != null && memberMerchantSet != null && memberMerchantSet.size() != merchantDOList.size()) {
        redisUtil.remove(key);
        setMerchantDOList(key, merchantDOList, userInfoDO);
      }
    }
    H5CMerchantBaseDTO h5CMerchantBaseDTO = new H5CMerchantBaseDTO();
    h5CMerchantBaseDTO.setCount(redisUtil.getZSetSize(key));
    h5CMerchantBaseDTO.setPageNum(query.getPageNum());
    h5CMerchantBaseDTO.setPageSize(query.getPageSize());

    List<H5CMerchantDTO> h5CMerchantList = new ArrayList<>(memberMerchantSet.size());
    List<String> merchantLabelNameList = null;
    H5CMerchantDTO h5CMerchantDTO = null;

    for (Pair<Integer, Double> pair : memberMerchantSet) {
      h5CMerchantDTO = new H5CMerchantDTO();
      h5CMerchantDTO.setDistance(pair.getRight());
      h5CMerchantDTO.setId(pair.getLeft());

      // 查询商家标签集合
      merchantLabelNameList = merchantLabelService.listNameByMerchantId(pair.getLeft());
      h5CMerchantDTO.setMerchantLabel(merchantLabelNameList);
      // 商家信息
      MerchantQuery merchantQuery = new MerchantQuery();
      merchantQuery.setId(pair.getLeft());
      MerchantDO merchantDO = this.merchantService.get(merchantQuery);
      h5CMerchantDTO.setLogoUrl(merchantDO.getLogoUrl());
      h5CMerchantDTO.setName(merchantDO.getName());
      h5CMerchantList.add(h5CMerchantDTO);
    }
    h5CMerchantBaseDTO.setList(h5CMerchantList);
    logger.info("totalUsedTimes:" + (System.currentTimeMillis() - startTime0) + "ms");
    return h5CMerchantBaseDTO;
  }

  /**
   * 给商家DTO塞值，防止报重复代码
   *
   * @param key
   * @param merchantDOList
   * @param userInfoDO
   */
  public void setMerchantDOList(String key, List<MerchantDO> merchantDOList, UserInfoDO userInfoDO) {
    if (merchantDOList != null && merchantDOList.size() > 0) {
      for (MerchantDO merchantDO : merchantDOList) {
        Double distance = MapUtil.GetDistance(userInfoDO.getLat(), userInfoDO.getLng(), merchantDO.getLat(), merchantDO.getLon());
        redisUtil.addRedisZSet(key, new Pair<>(merchantDO.getId(), distance), distance);
      }
    }
  }
}
