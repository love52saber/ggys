package net.seocoo.ggys.module.groupon.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.goods.constans.GoodsStateEnum;
import net.seocoo.ggys.module.goods.constans.GoodsTypeEnum;
import net.seocoo.ggys.module.goods.entity.MerchantBaseGoodsDO;
import net.seocoo.ggys.module.goods.entity.MerchantBaseGoodsDTO;
import net.seocoo.ggys.module.goods.query.MerchantBaseGoodsQuery;
import net.seocoo.ggys.module.goods.service.MerchantBaseGoodsService;
import net.seocoo.ggys.module.groupon.entity.MerchantGrouponGoodsDTO;
import net.seocoo.ggys.module.groupon.form.GrouponGoodsForm;
import net.seocoo.ggys.module.groupon.query.MerchantGrouponGoodsQuery;
import net.seocoo.ggys.module.groupon.service.GrouponService;
import net.seocoo.ggys.module.merchant.entity.MerchantDTO;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/29 0029 17:57
 * @Email xieheng91@163.com
 * @Desc 团购模板service
 */
@Service
public class GrouponServiceImpl extends BaseService implements GrouponService {

    @Autowired
    private MerchantBaseGoodsService baseGoodsService;

    @Autowired
    private MerchantService merchantService;

    @Override
    @Transactional
    public Boolean save(GrouponGoodsForm grouponGoodsForm, Integer merchantUserId) {
        MerchantBaseGoodsDO baseGoodsDO = new MerchantBaseGoodsDO();
        BeanUtils.copyProperties(grouponGoodsForm, baseGoodsDO);

        Integer merchantId = merchantService.getMerchantIdByMerchantUserId(merchantUserId);

        baseGoodsDO.setMerchantId(merchantId);
        baseGoodsDO.setState(GoodsStateEnum.AUDITED);
        baseGoodsDO.setType(GoodsTypeEnum.GROUPON);
        return baseGoodsService.save(baseGoodsDO);
    }

    @Override
    public Boolean delete(Integer goodsId) {
        return baseGoodsService.delete(goodsId);
    }

    @Override
    public Boolean update(GrouponGoodsForm grouponGoodsForm) {
        MerchantBaseGoodsDO baseGoodsDO = new MerchantBaseGoodsDO();
        BeanUtils.copyProperties(grouponGoodsForm, baseGoodsDO);

        logger.info(JSONObject.toJSONString(baseGoodsDO));
        return baseGoodsService.update(baseGoodsDO);
    }

    @Override
    public List<MerchantGrouponGoodsDTO> list(MerchantGrouponGoodsQuery query, Integer merchantUserId) {

        MerchantBaseGoodsQuery baseGoodsQuery = new MerchantBaseGoodsQuery();
        baseGoodsQuery.setType(GoodsTypeEnum.GROUPON);
        baseGoodsQuery.setMerchantId(query.getMerchantId());
        baseGoodsQuery.setName(query.getName());


        // 当查询中商家id为空时,说明此时登录是商户用户后台登录;根据商户userId查询商户id;
        if (query.getMerchantId() == null) {
            Integer merchantId = merchantService.getMerchantIdByMerchantUserId(merchantUserId);
            baseGoodsQuery.setMerchantId(merchantId);
        }

        List<MerchantBaseGoodsDTO> goodslist = baseGoodsService.list(baseGoodsQuery);

        List<MerchantGrouponGoodsDTO> grouponTemplateDTOList = new ArrayList<>();
        for (MerchantBaseGoodsDTO baseGoodsDTO : goodslist) {
            MerchantGrouponGoodsDTO grouponGoodsDTO = new MerchantGrouponGoodsDTO();
            BeanUtils.copyProperties(baseGoodsDTO, grouponGoodsDTO);
            grouponTemplateDTOList.add(grouponGoodsDTO);
        }
        return grouponTemplateDTOList;
    }

    @Override
    public PageBean<MerchantGrouponGoodsDTO> page(MerchantGrouponGoodsQuery query, Integer merchantUserId) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MerchantGrouponGoodsDTO> list = list(query, merchantUserId);

        MerchantBaseGoodsQuery baseGoodsQuery = new MerchantBaseGoodsQuery();
        baseGoodsQuery.setType(GoodsTypeEnum.GROUPON);
        baseGoodsQuery.setMerchantId(query.getMerchantId());
        baseGoodsQuery.setName(query.getName());

        return new PageBean<MerchantGrouponGoodsDTO>(list, query.getPageNum(), query.getPageSize(), baseGoodsService.count(baseGoodsQuery));
    }

    @Override
    public MerchantGrouponGoodsDTO get(Integer id) {
        MerchantBaseGoodsDTO baseGoodsDTO = baseGoodsService.get(id);
        MerchantGrouponGoodsDTO grouponGoodsDTO = new MerchantGrouponGoodsDTO();
        BeanUtils.copyProperties(baseGoodsDTO, grouponGoodsDTO);
        //获取商户名
        MerchantDTO merchantDTO = merchantService.get(baseGoodsDTO.getMerchantId());
        grouponGoodsDTO.setMerchantName(merchantDTO.getName());

        return grouponGoodsDTO;

    }
}
