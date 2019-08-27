package net.seocoo.ggys.module.book.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.book.entity.FreeBookRuleDO;
import net.seocoo.ggys.module.book.exception.BookException;
import net.seocoo.ggys.module.book.mapper.FreeBookRuleMapper;
import net.seocoo.ggys.module.book.query.BookRuleQuery;
import net.seocoo.ggys.module.book.service.BookRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author panch
 * @date 2018/5/30 16:19
 */
@Service
public class BookRuleServiceImpl extends BaseService implements BookRuleService {

  @Autowired
  private FreeBookRuleMapper freeBookRuleMapper;

  @Override
  public int saveBookRule(FreeBookRuleDO freeBookRuleDO) {
    insertSetDefaultValue(freeBookRuleDO);
    return this.freeBookRuleMapper.insert(freeBookRuleDO);
  }

  @Override
  public FreeBookRuleDO getBookRuleById(int id) {
    return this.freeBookRuleMapper.selectByPrimaryKey(id);
  }

  @Override
  public void deleteBookRule(int id) {
    FreeBookRuleDO freeBookRuleDO = this.freeBookRuleMapper.selectByPrimaryKey(id);
    if (freeBookRuleDO == null) {
      throw new BookException("Id=" + id + "的预约规则不存在", 500);
    }
    freeBookRuleDO.setCanDeleted(YesNoEnum.Y);
    this.freeBookRuleMapper.updateByPrimaryKey(freeBookRuleDO);
  }

  @Override
  public List<FreeBookRuleDO> listBookRuleByMerchantId(int merchantId) {
    return this.freeBookRuleMapper.listBookRuleByMerchantId(merchantId);
  }

  @Override
  public PageBean<FreeBookRuleDO> listByPageQuery(BookRuleQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());
    List<FreeBookRuleDO> freeBookRuleDOList = this.freeBookRuleMapper.listByPageQuery(query);
    return new PageBean<>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), freeBookRuleDOList);
  }

  @Override
  public Integer countByQuery(BookRuleQuery query) {
    return this.freeBookRuleMapper.countByQuery(query);
  }

  @Override
  public void updateBookRule(FreeBookRuleDO freeBookRuleDO) {
    FreeBookRuleDO record=this.freeBookRuleMapper.selectByPrimaryKey(freeBookRuleDO.getId());
    if(record==null){
      throw new BookException("ID="+freeBookRuleDO.getId()+"的预约规则不存在", RequestCode.server_error);
    }
    freeBookRuleDO.setUpdateDate(new Date());
    this.freeBookRuleMapper.updateByPrimaryKeySelective(freeBookRuleDO);
  }
}
