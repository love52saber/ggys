package net.seocoo.ggys.module.goods.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.goods.entity.MerchantBaseGoodsDO;
import net.seocoo.ggys.module.goods.entity.MerchantBaseGoodsDTO;
import net.seocoo.ggys.module.goods.form.GoodsAuditForm;
import net.seocoo.ggys.module.goods.mapper.MerchantBaseGoodsMapper;
import net.seocoo.ggys.module.goods.query.MerchantBaseGoodsQuery;
import net.seocoo.ggys.module.goods.service.MerchantBaseGoodsService;
import net.seocoo.ggys.module.groupon.service.GrouponService;
import net.seocoo.ggys.module.merchant.entity.MerchantDO;
import net.seocoo.ggys.module.merchant.query.MerchantQuery;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 9:06
 * @Email xieheng91@163.com
 * @Desc 商品基本信息service接口实现
 */
@Service
public class MerchantBaseGoodsServiceImpl extends BaseService implements MerchantBaseGoodsService {

    @Autowired
    private MerchantBaseGoodsMapper merchantBaseGoodsMapper;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private GrouponService grouponService;

    @Override
    public Boolean save(MerchantBaseGoodsDO merchantBaseGoodsDO) {
        insertSetDefaultValue(merchantBaseGoodsDO);
        return merchantBaseGoodsMapper.insertSelective(merchantBaseGoodsDO) < 1 ? false : true;
    }

    @Override
    public Boolean delete(Integer merchantBaseGoodsId) {
        return merchantBaseGoodsMapper.delete(merchantBaseGoodsId) < 1 ? false : true;
    }

    @Override
    public Boolean update(MerchantBaseGoodsDO merchantBaseGoodsDO) {
        updateSetDefaultValue(merchantBaseGoodsDO);
        return merchantBaseGoodsMapper.updateByPrimaryKeySelective(merchantBaseGoodsDO) < 1 ? false : true;
    }

    @Override
    public List<MerchantBaseGoodsDTO> list(MerchantBaseGoodsQuery query) {

        List<MerchantBaseGoodsDTO> result = new ArrayList<>();


        //商户主键id集合
        List<Integer> merchantIdList = new ArrayList<Integer>();
        //商户数据集合
        List<MerchantDO> merchantList = new ArrayList<>();
        if (!StringEx.stringIsNullOrEmpty(query.getMerchantName())) {
            MerchantQuery merchantQuery = new MerchantQuery();
            merchantQuery.setName(query.getName());
            //商户数据集合
            merchantList = merchantService.list(merchantQuery);
            for (MerchantDO merchantDO : merchantList) {
                merchantIdList.add(merchantDO.getId());
            }
            //设置商户(店铺)的id
            query.setMerchandIdList(merchantIdList);
        }

        List<MerchantBaseGoodsDO> goodsDOlist = merchantBaseGoodsMapper.list(query);

        if (merchantList != null && merchantList.size() > 0) {
            for (MerchantBaseGoodsDO goodsDO : goodsDOlist) {
                MerchantBaseGoodsDTO goodsDTO = new MerchantBaseGoodsDTO();
                BeanUtils.copyProperties(goodsDO, goodsDTO);
                for (MerchantDO merchantDO : merchantList) {
                    if (merchantDO.getId().equals(goodsDO.getMerchantId())) {
                        goodsDTO.setMerchantName(merchantDO.getName());
                    }
                }
                result.add(goodsDTO);
            }
        } else {
            for (MerchantBaseGoodsDO goodsDO : goodsDOlist) {
                MerchantBaseGoodsDTO goodsDTO = new MerchantBaseGoodsDTO();
                BeanUtils.copyProperties(goodsDO, goodsDTO);

                MerchantQuery merchantQuery = new MerchantQuery();
                merchantQuery.setId(goodsDO.getMerchantId());
                MerchantDO merchantDO = merchantService.get(merchantQuery);
                goodsDTO.setMerchantName(merchantDO.getName());

                result.add(goodsDTO);
            }
        }
        return result;

    }

    @Override
    public PageBean<MerchantBaseGoodsDTO> page(MerchantBaseGoodsQuery query) {
        List<MerchantBaseGoodsDTO> result = new ArrayList<>();


        //商户主键id集合
        List<Integer> merchantIdList = new ArrayList<Integer>();
        //商户数据集合
        List<MerchantDO> merchantList = new ArrayList<>();
        if (!StringEx.stringIsNullOrEmpty(query.getMerchantName())) {
            MerchantQuery merchantQuery = new MerchantQuery();
            merchantQuery.setName(query.getName());
            //商户数据集合
            merchantList = merchantService.list(merchantQuery);
            for (MerchantDO merchantDO : merchantList) {
                merchantIdList.add(merchantDO.getId());
            }
            //设置商户(店铺)的id
            query.setMerchandIdList(merchantIdList);
        }

        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MerchantBaseGoodsDO> goodsDOlist = merchantBaseGoodsMapper.list(query);

        if (merchantList != null && merchantList.size() > 0) {
            for (MerchantBaseGoodsDO goodsDO : goodsDOlist) {
                MerchantBaseGoodsDTO goodsDTO = new MerchantBaseGoodsDTO();
                BeanUtils.copyProperties(goodsDO, goodsDTO);
                for (MerchantDO merchantDO : merchantList) {
                    if (merchantDO.getId().equals(goodsDO.getMerchantId())) {
                        goodsDTO.setMerchantName(merchantDO.getName());
                    }
                }
                result.add(goodsDTO);
            }
        } else {
            for (MerchantBaseGoodsDO goodsDO : goodsDOlist) {
                MerchantBaseGoodsDTO goodsDTO = new MerchantBaseGoodsDTO();
                BeanUtils.copyProperties(goodsDO, goodsDTO);

                MerchantQuery goodsQuery = new MerchantQuery();
                goodsQuery.setId(goodsDO.getMerchantId());
                MerchantDO merchantDO = merchantService.get(goodsQuery);
                goodsDTO.setMerchantName(merchantDO.getName());

                result.add(goodsDTO);
            }
        }
        return new PageBean<MerchantBaseGoodsDTO>(result, query.getPageNum(), query.getPageSize(), merchantBaseGoodsMapper.count(query));
    }

    @Override
    public MerchantBaseGoodsDO get(BaseQuery query) {
        return merchantBaseGoodsMapper.selectByPrimaryKey(query.getId());
    }

    @Override
    public Boolean auditGoods(GoodsAuditForm goodsAuditForm) {
        MerchantBaseGoodsDO merchantBaseGoodsDO = new MerchantBaseGoodsDO();
        BeanUtils.copyProperties(goodsAuditForm, merchantBaseGoodsDO);
        return update(merchantBaseGoodsDO);
    }

    @Override
    public MerchantBaseGoodsDTO get(Integer id) {
        MerchantBaseGoodsDTO baseGoodsDTO = new MerchantBaseGoodsDTO();
        MerchantBaseGoodsDO merchantBaseGoodsDO = merchantBaseGoodsMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(merchantBaseGoodsDO, baseGoodsDTO);

        //设置商户名
        MerchantQuery goodsQuery = new MerchantQuery();
        goodsQuery.setId(merchantBaseGoodsDO.getMerchantId());
        MerchantDO merchantDO = merchantService.get(goodsQuery);
        baseGoodsDTO.setMerchantName(merchantDO.getName());

        return baseGoodsDTO;
    }

    @Override
    public Integer count(MerchantBaseGoodsQuery merchantBaseGoodsQuery) {
        return merchantBaseGoodsMapper.count(merchantBaseGoodsQuery);
    }

    @Override
    public BigDecimal getMinimumPriceByMerchantId(Integer merchantId) {
        BigDecimal minimumPrice = merchantBaseGoodsMapper.selectMinPrice(merchantId);
        return minimumPrice == null ? BigDecimal.ZERO : minimumPrice;
    }
}
