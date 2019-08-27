package net.seocoo.ggys.module.book.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.book.constants.BookDetailStateEnum;
import net.seocoo.ggys.module.book.entity.FreeBookDetailDO;
import net.seocoo.ggys.module.book.entity.FreeBookRuleDO;
import net.seocoo.ggys.module.book.exception.BookException;
import net.seocoo.ggys.module.book.mapper.FreeBookDetailMapper;
import net.seocoo.ggys.module.book.query.BookDetailQuery;
import net.seocoo.ggys.module.book.service.BookDetailService;
import net.seocoo.ggys.module.book.service.BookRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author PanChengHao
 * @date 2018/5/31 15:36
 */
@Service
public class BookDetailServiceImpl extends BaseService implements BookDetailService {

  @Autowired
  private FreeBookDetailMapper freeBookDetailMapper;

  @Autowired
  private BookRuleService bookRuleService;

  @Override
  public int saveBookDetail(FreeBookDetailDO freeBookDetailDO) {
    insertSetDefaultValue(freeBookDetailDO);
    freeBookDetailDO.setBookState(BookDetailStateEnum.UNAUDIT);
    //判断此用户在当前商家是否有可用的预约，如果有，不允许预约
    FreeBookDetailDO record = new FreeBookDetailDO();
    record.setMerchantId(freeBookDetailDO.getMerchantId());
    record.setBookUserId(freeBookDetailDO.getBookUserId());
    record.setBookState(BookDetailStateEnum.UNAUDIT);
    Boolean flag = canUsedBookDetail(freeBookDetailDO);
    if (!flag) {
      throw new BookException("你在该商家已有预约，请勿重复预约", RequestCode.server_error);
    }
    //判断当前商家此时间段预约人数是否达到商家设定的预约人数，如果达到了，不允许预约
    FreeBookRuleDO freeBookRuleDO = bookRuleService.getBookRuleById(freeBookDetailDO.getFreeBookRuleId());
    if (freeBookRuleDO == null) {
      throw new BookException("ID="+freeBookDetailDO.getFreeBookRuleId()+"的预约规则不存在,预约失败",RequestCode.Operate_Tip);
    }
    Integer maxBookCount=freeBookRuleDO.getMaxBookCount();
    //查询该商家该时间段已经预约的人数
    BookDetailQuery bookDetailQuery=new BookDetailQuery();
    bookDetailQuery.setMerchantId(freeBookDetailDO.getMerchantId());
    bookDetailQuery.setBookDetailState(BookDetailStateEnum.AUDITED);
    Integer count=countByQuery(bookDetailQuery);
    if(count>=maxBookCount){
      throw new BookException("当前时间段的预约人数已满，请重新选择预约时间",RequestCode.Operate_Tip);
    }
    return this.freeBookDetailMapper.insert(freeBookDetailDO);
  }

  @Override
  public FreeBookDetailDO getBookDetailById(int id) {
    return this.freeBookDetailMapper.selectByPrimaryKey(id);
  }

  @Override
  public void deleteBookDetail(int id) {
    FreeBookDetailDO freeBookDetailDO = this.freeBookDetailMapper.selectByPrimaryKey(id);
    if (freeBookDetailDO == null) {
      throw new BookException("ID=" + id + "的预约不存在", 500);
    }
    freeBookDetailDO.setCanDeleted(YesNoEnum.Y);
    this.freeBookDetailMapper.updateByPrimaryKey(freeBookDetailDO);
  }

  @Override
  public List<FreeBookDetailDO> listBookDetailByMerchantId(int merchantId) {
    return this.freeBookDetailMapper.listBookDetailByMerchantId(merchantId);
  }

  @Override
  public PageBean<FreeBookDetailDO> listByPageQuery(BookDetailQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());

    List<FreeBookDetailDO> freeBookDetailDOList = this.freeBookDetailMapper.listByPageQuery(query);
    return new PageBean<>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), freeBookDetailDOList);
  }

  @Override
  public Integer countByQuery(BookDetailQuery query) {
    return this.freeBookDetailMapper.countByQuery(query);
  }

  @Override
  public void updateBookDetail(FreeBookDetailDO freeBookDetailDO) {
    FreeBookDetailDO record = this.freeBookDetailMapper.selectByPrimaryKey(freeBookDetailDO.getId());
    if (record == null) {
      throw new BookException("ID=" + freeBookDetailDO.getId() + "的预约详情不存在", RequestCode.server_error);
    } else if (record.getBookState() == BookDetailStateEnum.UNAUDIT) {
      record.setUpdateDate(new Date());
      if (freeBookDetailDO.getBookState() == BookDetailStateEnum.CANCEL) {
        freeBookDetailDO.setCancelDate(new Date());
      }
      if (freeBookDetailDO.getBookState() == BookDetailStateEnum.AUDITED || freeBookDetailDO.getBookState() == BookDetailStateEnum.REJECT) {
        freeBookDetailDO.setAuditDate(new Date());
      }
      this.freeBookDetailMapper.updateByPrimaryKeySelective(freeBookDetailDO);
    } else {
      throw new BookException("当前预约状态为：" + record.getBookState() + ",操作失败", RequestCode.server_error);
    }
  }

  @Override
  public int updateSelective(FreeBookDetailDO freeBookDetailDO) {
    return this.freeBookDetailMapper.updateByPrimaryKeySelective(freeBookDetailDO) < 1 ? 0 : 1;
  }

  @Override
  public Boolean canUsedBookDetail(FreeBookDetailDO freeBookDetailDO) {
    FreeBookDetailDO record = this.freeBookDetailMapper.selectCanUsedBookDetail(freeBookDetailDO);
    Boolean flag = true;
    if (record != null) {
      flag = false;
    }
    return flag;
  }

}
