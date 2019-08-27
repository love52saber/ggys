package net.seocoo.ggys.module.evaluate.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.exception.AppException;
import net.seocoo.ggys.module.evaluate.dto.EvaluateDTO;
import net.seocoo.ggys.module.evaluate.dto.OrderEvaluateDTO;
import net.seocoo.ggys.module.evaluate.entity.OrderEvaluateDO;
import net.seocoo.ggys.module.evaluate.exception.EvaluateException;
import net.seocoo.ggys.module.evaluate.mapper.OrderEvaluateMapper;
import net.seocoo.ggys.module.evaluate.query.OrderEvaluateQuery;
import net.seocoo.ggys.module.evaluate.service.OrderEvaluateService;
import net.seocoo.ggys.module.order.constants.OrderStateEnum;
import net.seocoo.ggys.module.order.entity.MerchantBaseOrderDO;
import net.seocoo.ggys.module.order.service.MerchantBaseOrderService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单评价service实现类
 * @author PanChengHao
 * @date 2018/6/14 8:48
 */
@Service
public class OrderEvaluateServiceImpl extends BaseService implements OrderEvaluateService {

  @Autowired
  private OrderEvaluateMapper orderEvaluateMapper;

  @Autowired
  private MerchantBaseOrderService merchantBaseOrderService;

  @Autowired
  private UserInfoService userInfoService;

  /**
   * 保存订单评价
   * @param orderEvaluateDO
   */
  @Transactional(rollbackFor = AppException.class)
  @Override
  public void saveOrderEvaluate(OrderEvaluateDO orderEvaluateDO) {
    insertSetDefaultValue(orderEvaluateDO);
    MerchantBaseOrderDO merchantBaseOrderDO=merchantBaseOrderService.get(orderEvaluateDO.getOrderId());
    if(merchantBaseOrderDO !=null){
      orderEvaluateDO.setOrderNo(merchantBaseOrderDO.getOrderNo());
      orderEvaluateDO.setOrderType(merchantBaseOrderDO.getOrderType());
    }
    this.orderEvaluateMapper.insert(orderEvaluateDO);
    //更新订单状态
    merchantBaseOrderService.updateOrderState(orderEvaluateDO.getOrderId(), OrderStateEnum.EVALUATED);
  }

  @Override
  public void updateOrderEvaluateSelective(OrderEvaluateDO orderEvaluateDO) {

  }

  /**
   * 根据id获取订单评价
   * @param id
   * @return 订单评价对象
   */
  @Override
  public OrderEvaluateDTO getOrderEvaluateById(int id) {
    OrderEvaluateDO orderEvaluateDO=this.orderEvaluateMapper.selectByPrimaryKey(id);
    if(orderEvaluateDO == null){
      throw new EvaluateException("ID="+id+"的订单评价不存在", RequestCode.server_error);
    }
    MerchantBaseOrderDO merchantBaseOrderDO=merchantBaseOrderService.get(orderEvaluateDO.getOrderId());
    OrderEvaluateDTO orderEvaluateDTO =new OrderEvaluateDTO();
    if(merchantBaseOrderDO != null){
      BeanUtils.copyProperties(merchantBaseOrderDO,orderEvaluateDTO);
    }
    //查询用户昵称
    UserInfoDO userInfoDO=userInfoService.getUserInfoById(orderEvaluateDO.getUserId());
    if(userInfoDO != null){
      orderEvaluateDTO.setNickname(userInfoDO.getNickname());
    }
    orderEvaluateDTO.setEvaluateResult(orderEvaluateDO.getEvaluateResult());
    orderEvaluateDTO.setContent(orderEvaluateDO.getContent());
    return orderEvaluateDTO;
  }

  /**
   * 分页查询订单评价
   * @param query
   * @return 订单评价list
   */
  @Override
  public PageBean<EvaluateDTO> listByPageQuery(OrderEvaluateQuery query) {
    PageHelper.startPage(query.getPageNum(),query.getPageSize());
    List<OrderEvaluateDO> orderEvaluateDOList=this.orderEvaluateMapper.listByPageQuery(query);
    List<Integer> userIdList=new ArrayList<>();
    if(orderEvaluateDOList !=null && orderEvaluateDOList.size()>0){
      for(OrderEvaluateDO orderEvaluateDO:orderEvaluateDOList){
        userIdList.add(orderEvaluateDO.getUserId());
      }
    }
    List<UserInfoDO> userInfoDOList=null;
    if(userIdList.size()>0){
      userInfoDOList=userInfoService.queryUserInfoListByUserIdList(userIdList);
    }
    List<EvaluateDTO> evaluateDTOList =new ArrayList<>();
    //将用户昵称放入DTO中
    if(orderEvaluateDOList !=null && orderEvaluateDOList.size()>0 && userInfoDOList !=null && userInfoDOList.size()>0){
      for(OrderEvaluateDO orderEvaluateDO:orderEvaluateDOList){
        EvaluateDTO evaluateDTO =new EvaluateDTO();
        evaluateDTO.setEvaluateResult(orderEvaluateDO.getEvaluateResult());
        evaluateDTO.setOrderType(orderEvaluateDO.getOrderType());
        evaluateDTO.setId(orderEvaluateDO.getId());
        for(UserInfoDO userInfoDO:userInfoDOList){
          if(userInfoDO.getId().equals(orderEvaluateDO.getUserId())){
            evaluateDTO.setNickname(userInfoDO.getNickname());
            break;
          }
        }
        evaluateDTOList.add(evaluateDTO);
      }
    }
    return new PageBean<>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), evaluateDTOList);
  }

  /**
   * 总数
   * @param query
   * @return
   */
  @Override
  public Integer countByQuery(OrderEvaluateQuery query) {
    return this.orderEvaluateMapper.countByQuery(query);
  }
}
