package net.seocoo.ggys.module.order.service.impl;

import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.coupon.constants.CouponTemplatePayRangEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateUseRangEnum;
import net.seocoo.ggys.module.coupon.service.CouponUseRecordService;
import net.seocoo.ggys.module.goods.entity.MerchantBaseGoodsDTO;
import net.seocoo.ggys.module.goods.service.MerchantBaseGoodsService;
import net.seocoo.ggys.module.groupon.entity.MerchantGrouponGoodsDTO;
import net.seocoo.ggys.module.groupon.service.GrouponService;
import net.seocoo.ggys.module.member.entity.MemberCardConsumeRecordDO;
import net.seocoo.ggys.module.member.entity.MemberCardInfoDO;
import net.seocoo.ggys.module.member.service.MemberCardConsumeRecordService;
import net.seocoo.ggys.module.member.service.MemberCardInfoService;
import net.seocoo.ggys.module.merchant.entity.MerchantDTO;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.order.constants.OrderPayTypeEnum;
import net.seocoo.ggys.module.order.constants.OrderStateEnum;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;
import net.seocoo.ggys.module.order.dto.GrouponOrderDTO;
import net.seocoo.ggys.module.order.dto.OrderListDTO;
import net.seocoo.ggys.module.order.entity.GrouponOrderDO;
import net.seocoo.ggys.module.order.entity.MerchantBaseOrderDO;
import net.seocoo.ggys.module.order.entity.MerchantOrderGoodsDO;
import net.seocoo.ggys.module.order.exception.OrderException;
import net.seocoo.ggys.module.order.form.GrouponOrderForm;
import net.seocoo.ggys.module.order.mapper.GrouponOrderMapper;
import net.seocoo.ggys.module.order.query.MerchantOrderQuery;
import net.seocoo.ggys.module.order.service.GrouponOrderService;
import net.seocoo.ggys.module.order.service.MerchantBaseOrderService;
import net.seocoo.ggys.module.order.service.MerchantOrderGoodsService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/7 16:34
 **/
@Service
public class GrouponOrderServiceImpl implements GrouponOrderService {

    @Autowired
    private GrouponOrderMapper grouponOrderMapper;
    /**
     * 优惠券使用记录service
     */
    @Autowired
    private CouponUseRecordService couponUseRecordService;

    @Autowired
    private MerchantOrderGoodsService orderGoodsService;

    /**
     * 团购商品service
     */
    @Autowired
    private GrouponService grouponService;

    /**
     * 订单基类信息service
     */
    @Autowired
    private MerchantBaseOrderService baseOrderService;

    /**
     * 会员卡信息service
     */
    @Autowired
    private MemberCardInfoService cardInfoService;
    /**
     * 会员卡消费service
     */
    @Autowired
    private MemberCardConsumeRecordService cardConsumeRecordService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MerchantBaseGoodsService goodsService;

    @Autowired
    private  MerchantService merchantService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(GrouponOrderForm grouponOrderForm, UserInfoDO userInfo) {
        // 1.商品信息查询
        MerchantGrouponGoodsDTO grouponGoodsDTO = grouponService.get(grouponOrderForm.getGoodsId());
        if (grouponGoodsDTO == null || grouponGoodsDTO.getCurrentPrice() == null) {
            throw new OrderException("商品信息有误", RequestCode.server_error);
        }
        //商品当前价格
        BigDecimal currentPrice = grouponGoodsDTO.getCurrentPrice();
        //订单数量
        BigDecimal orderCount = BigDecimal.valueOf(grouponOrderForm.getOrderCount());
        //通过实际商品的当前价格和数量,计算此次团购订单的总金额
        BigDecimal goodsTotalPrice = currentPrice.multiply(orderCount);
        //订单实际费用
        BigDecimal orderActualFee = goodsTotalPrice;
        //订单费用
        BigDecimal orderFee = goodsTotalPrice;

        Integer couponId = grouponOrderForm.getCouponId();
        CouponTemplatePayRangEnum payRangEnum = grouponOrderForm.getUseMemberCard() ==
                YesNoEnum.Y ? CouponTemplatePayRangEnum.MEMBER_CARD_PAY : CouponTemplatePayRangEnum.WX_PAY;
        // 优惠券可用金额
        BigDecimal couponMoney = BigDecimal.ZERO;
        // 使用优惠券
        if (couponId != null) {
            if (!this.couponUseRecordService.isCanUseCoupon(couponId, CouponTemplateUseRangEnum.GROUPON, payRangEnum, orderFee)) {
                throw new OrderException("此单不能使用此优惠券", RequestCode.Operate_Tip);
            }
            couponMoney = this.couponUseRecordService.getCouponMoney(couponId);

            // 增加优惠券使用记录
            this.couponUseRecordService.updateCouponUseRecordState2Use(couponId);
        }

        //订单中使用的优惠卷面值
        BigDecimal orderCouponFee = couponMoney;
        //订单实际支付费用
        BigDecimal orderPayActualFee = goodsTotalPrice.subtract(orderCouponFee);
        if(orderPayActualFee.compareTo(BigDecimal.ZERO)<0){
            orderPayActualFee=BigDecimal.ZERO;
        }

        // 2.团购订单增加
        GrouponOrderDO grouponOrderDO = new GrouponOrderDO();
        grouponOrderDO.setUuid(StringEx.newUUID());
        grouponOrderDO.setOrderCount(Short.valueOf(grouponOrderForm.getOrderCount().toString()));
        grouponOrderDO.setLinkFullName(userInfo.getFullName());
        grouponOrderDO.setLinkPhone(userInfo.getPhone());
        grouponOrderMapper.insertSelective(grouponOrderDO);
        // 3.订单基表增加
        MerchantBaseOrderDO order = new MerchantBaseOrderDO();

        order.setOrderNo(userInfo.getId() + String.valueOf(System.currentTimeMillis()));
        OrderPayTypeEnum orderPayType = grouponOrderForm.getUseMemberCard() ==
                YesNoEnum.Y ? OrderPayTypeEnum.MEMBER_CARD : OrderPayTypeEnum.WX_PAY;
        order.setPayType(orderPayType);
        order.setFinishedUserId(userInfo.getId());
        order.setFinishedDate(new Date());
        order.setOrderUserId(userInfo.getId());
        order.setMerchantId(grouponOrderForm.getMerchantId());

        order.setOrderFee(orderFee);
        order.setOrderCouponFee(couponMoney);
        order.setOrderActualFee(orderActualFee);
        order.setOrderPayActualFee(orderPayActualFee);

        order.setMerchantId(grouponOrderForm.getMerchantId());
        order.setOrderDate(new Date());
        order.setOrderType(OrderTypeEnum.GROUPON);

        order.setPayDate(new Date());
        order.setOrderState(OrderStateEnum.CONSUMED);
        order.setGrouponOrderId(grouponOrderDO.getId());
        baseOrderService.save(order);

        //4.支付

        // 如果使用会员卡
        if (payRangEnum == CouponTemplatePayRangEnum.MEMBER_CARD_PAY) {
            //1.查询会员卡信息
            MemberCardInfoDO memberCardInfoDO = cardInfoService.selectMemberCardInfoByUserIdMerchantId(userInfo.getId(), grouponOrderForm.getMerchantId());

            if (memberCardInfoDO == null) {
                throw new OrderException("会员卡不存在", RequestCode.server_error);
            }
            //2.判断余额
            Boolean canPay = cardInfoService.canUsedMemberCardInfo(memberCardInfoDO.getId(), orderPayActualFee);
            if (!canPay) {
                throw new OrderException("会员卡额度不足", RequestCode.server_error);
            }
            //3.会员卡消费接口
            MemberCardConsumeRecordDO cardConsumeRecordDO = new MemberCardConsumeRecordDO();
            cardConsumeRecordDO.setMemberCardId(memberCardInfoDO.getId());
            cardConsumeRecordDO.setOrderId(order.getId());
            cardConsumeRecordDO.setUserId(userInfo.getId());
            cardConsumeRecordDO.setMerchantId(grouponOrderForm.getMerchantId());
            cardConsumeRecordDO.setConsumeMoney(orderPayActualFee);

            cardConsumeRecordService.saveMemberCardConsumeRecord(cardConsumeRecordDO);

        } else if (payRangEnum == CouponTemplatePayRangEnum.WX_PAY) {
            // 如果使用微信支付，调微信接口

        }


        // 订单与商品的中间表
        MerchantOrderGoodsDO merchantOrderGoodsDO = new MerchantOrderGoodsDO();
        merchantOrderGoodsDO.setOrderId(order.getId());
        merchantOrderGoodsDO.setGoodsId(grouponGoodsDTO.getId());
        merchantOrderGoodsDO.setUuid(StringEx.newUUID());
        orderGoodsService.save(merchantOrderGoodsDO);

    }

    //TODO 位置不对
    @Override
    public  GrouponOrderDTO getDtoByBaseOrderId(int baseOrderId){
        GrouponOrderDTO grouponOrderDTO = new GrouponOrderDTO();

        MerchantBaseOrderDO orderDO = baseOrderService.get(baseOrderId);
        BeanUtils.copyProperties(orderDO,grouponOrderDTO);

        grouponOrderDTO.setOrderType(OrderTypeEnum.GROUPON);
        grouponOrderDTO.setOrderTypeDesc(OrderTypeEnum.GROUPON.getDesc());

        MerchantDTO merchantDTO = merchantService.get(orderDO.getMerchantId());
        grouponOrderDTO.setMerchantName(merchantDTO.getName());
        grouponOrderDTO.setMerchantLogoUrl(merchantDTO.getLogoUrl());
        grouponOrderDTO.setOrderStateDesc(orderDO.getOrderState().getDesc());
        grouponOrderDTO.setPayTypeDesc(orderDO.getPayType().getDesc());

        UserInfoDO userInfo = null;
        // 下单人信息
        if (orderDO.getOrderUserId() != null) {
            userInfo = this.userInfoService.getUserInfoById(orderDO.getOrderUserId());
            grouponOrderDTO.setNickName(userInfo.getNickname());
        }
        //数量和预约信息
        GrouponOrderDO grouponOrder =this.getById(grouponOrderDTO.getGrouponOrderId());
        grouponOrderDTO.setCount(grouponOrder.getOrderCount());
        grouponOrderDTO.setBookEndDate(grouponOrder.getBookEndDate());
        grouponOrderDTO.setBookStartDate(grouponOrder.getBookStartDate());

        //商品名
        List<MerchantOrderGoodsDO> orderGoodsDOS = orderGoodsService.listByOrderId(grouponOrderDTO.getId());
        MerchantBaseGoodsDTO goodsDTO = goodsService.get(orderGoodsDOS.get(0).getGoodsId());
        grouponOrderDTO.setGoodsName(goodsDTO.getName());
        grouponOrderDTO.setGoodsImgUrl(goodsDTO.getFirstLargeImgUrl());
        grouponOrderDTO.setGoodsPrice(goodsDTO.getCurrentPrice());
        return  grouponOrderDTO;
    }

    @Override
    public  GrouponOrderDO getById(int id){
        return  grouponOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean<OrderListDTO> page(MerchantOrderQuery query) {
        return baseOrderService.listByQuery(query);
    }

    @Override
    public Boolean updateOrderState(GrouponOrderForm grouponOrderForm) {
        return baseOrderService.updateOrderState(grouponOrderForm.getMerchantBaseOrderId(),grouponOrderForm.getOrderState());
    }



}
