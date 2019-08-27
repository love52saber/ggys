package net.seocoo.ggys.module.order.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.goods.entity.MerchantBaseGoodsDTO;
import net.seocoo.ggys.module.goods.service.MerchantBaseGoodsService;
import net.seocoo.ggys.module.merchant.entity.MerchantDTO;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.order.constants.OrderStateEnum;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;
import net.seocoo.ggys.module.order.dto.IndexDTO;
import net.seocoo.ggys.module.order.dto.OrderListDTO;
import net.seocoo.ggys.module.order.entity.GrouponOrderDO;
import net.seocoo.ggys.module.order.entity.MerchantBaseOrderDO;
import net.seocoo.ggys.module.order.entity.MerchantOrderGoodsDO;
import net.seocoo.ggys.module.order.mapper.MerchantBaseOrderMapper;
import net.seocoo.ggys.module.order.query.MerchantOrderQuery;
import net.seocoo.ggys.module.order.service.GrouponOrderService;
import net.seocoo.ggys.module.order.service.MerchantBaseOrderService;
import net.seocoo.ggys.module.order.service.MerchantOrderGoodsService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/8 16:25
 **/
@Service
public class MerchantBaseOrderServiceImpl extends BaseService implements MerchantBaseOrderService {

    @Autowired
    private MerchantBaseOrderMapper merchantBaseOrderMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private GrouponOrderService grouponOrderService;

    @Autowired
    private MerchantOrderGoodsService merchantOrderGoodsService;

    @Autowired
    private MerchantBaseGoodsService goodsService;

    @Autowired
    private MerchantService merchantService;

    @Override
    public PageBean<OrderListDTO> listByQuery(MerchantOrderQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MerchantBaseOrderDO> orderList = this.merchantBaseOrderMapper.listByQuery(query);
        Integer count = merchantBaseOrderMapper.count(query);
        List<OrderListDTO> orderDtoList = new ArrayList<>(orderList.size());
        OrderListDTO orderDto = null;
        UserInfoDO userInfo = null;
        for (MerchantBaseOrderDO record : orderList) {
            orderDto = new OrderListDTO();

            MerchantDTO merchantDTO = merchantService.get(record.getMerchantId());
            orderDto.setMerchantName(merchantDTO.getName());
            orderDto.setOrderFee(record.getOrderPayActualFee().toPlainString());
            orderDto.setOrderId(record.getId());
            orderDto.setOrderNo(record.getOrderNo());
            orderDto.setOrderState(record.getOrderState());
            orderDto.setOrderStateDesc(record.getOrderState().getDesc());

            // 下单人信息
            if (record.getOrderUserId() != null) {
                userInfo = this.userInfoService.getUserInfoById(record.getOrderUserId());
                orderDto.setNickName(userInfo.getNickname());
                orderDto.setUserHeadImageUrl(userInfo.getHeadImageUrl());
            }

            // 查询团购/外卖订单子类信息
            if (record.getOrderType() == OrderTypeEnum.GROUPON) {
                GrouponOrderDO grouponOrder = this.grouponOrderService.getById(record.getGrouponOrderId());
                orderDto.setCount(grouponOrder.getOrderCount());
                orderDto.setBookEndDate(grouponOrder.getBookEndDate());
                orderDto.setBookStartDate(grouponOrder.getBookStartDate());
                orderDto.setOrderTypeDesc(OrderTypeEnum.GROUPON.getDesc());
                orderDto.setOrderType(OrderTypeEnum.GROUPON);
            } else if (record.getOrderType() == OrderTypeEnum.TAKE_OUT) {

            }

            // 中间表查询商品信息
            List<MerchantOrderGoodsDO> orderGoodList = this.merchantOrderGoodsService.listByOrderId(record.getId());
            for (MerchantOrderGoodsDO orderGoodsDO : orderGoodList) {
                MerchantBaseGoodsDTO goodsDTO = goodsService.get(orderGoodsDO.getGoodsId());
                orderDto.setGoodsName(goodsDTO.getName());
                orderDto.setGoodsSmallImgUrl(goodsDTO.getSmallImgUrl());
            }
            orderDtoList.add(orderDto);
        }
        return new PageBean<OrderListDTO>(orderDtoList, query.getPageNum(), query.getPageSize(), count);
    }

    @Override
    public Boolean save(MerchantBaseOrderDO merchantBaseOrderDO) {
        insertSetDefaultValue(merchantBaseOrderDO);
        return merchantBaseOrderMapper.insertSelective(merchantBaseOrderDO) < 1 ? false : true;
    }

    @Override
    public Boolean updateOrderState(Integer id, OrderStateEnum orderStateEnum) {
        MerchantBaseOrderDO orderDO = new MerchantBaseOrderDO();
        orderDO.setId(id);
        orderDO.setOrderState(orderStateEnum);
        return merchantBaseOrderMapper.updateByPrimaryKeySelective(orderDO) < 1 ? false : true;
    }

    @Override
    public IndexDTO index(Integer merchantId) {
        MerchantOrderQuery query = new MerchantOrderQuery();
        query.setMerchantId(merchantId);
        //订单数量
        Integer orderCount = merchantBaseOrderMapper.count(query);
        //当前营业额
        BigDecimal currentTurnover = BigDecimal.ZERO;
        List<MerchantBaseOrderDO> merchantBaseOrderDOS = merchantBaseOrderMapper.listByQuery(query);
        for (MerchantBaseOrderDO orderDO : merchantBaseOrderDOS) {
            currentTurnover = currentTurnover.add(orderDO.getOrderPayActualFee() == null ? BigDecimal.ZERO : orderDO.getOrderPayActualFee());
        }
        return new IndexDTO(orderCount, currentTurnover);
    }

    @Override
    public MerchantBaseOrderDO get(Integer id) {
        return merchantBaseOrderMapper.selectByPrimaryKey(id);
    }
}
