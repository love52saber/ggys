package net.seocoo.ggys.module.book.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.book.entity.FreeBookRuleDO;
import net.seocoo.ggys.module.book.form.FreeBookRuleForm;
import net.seocoo.ggys.module.book.query.BookRuleQuery;
import net.seocoo.ggys.module.book.service.BookRuleService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 预约规则业务类
 * @author PanChengHao
 * @date 2018/5/31 10:00
 */
@Api(value = "免费预约规则接口类" ,description = "免费预约规则接口")
@RestController
@RequestMapping(value = "/h5/bookRule")
//@CrossOrigin
public class BookRuleController extends BaseController {
  @Autowired
  private BookRuleService bookRuleService;

  @PostMapping(value = "/add")
  @ApiOperation(value = "新增免费预约规则")
  public ApiResult saveBookRule(@RequestBody FreeBookRuleForm freeBookRuleForm, @RequestHeader String token) {
    UserInfoDO userInfoDO=getUserInfoFromToken(token);
    FreeBookRuleDO freeBookRuleDO=new FreeBookRuleDO();
    BeanUtils.copyProperties(freeBookRuleForm,freeBookRuleDO);
    freeBookRuleDO.setCreateUserId(userInfoDO.getId());
    bookRuleService.saveBookRule(freeBookRuleDO);
    return success("保存成功");
  }

  @GetMapping(value = "/list")
  @ApiOperation(value = "分页查询预约规则列表")
  public ApiResult listByPageQuery(BookRuleQuery query) {
    return success(bookRuleService.listByPageQuery(query));
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "根据id查询预约规则")
  public ApiResult queryBookRule(@PathVariable("id") @ApiParam(value = "主键",defaultValue = "6",required = true) int id) {
    return success(bookRuleService.getBookRuleById(id));
  }

  @PostMapping(value = "/delete")
  @ApiOperation(value="删除预约规则")
  public ApiResult deleteBookRule(int id) {
    bookRuleService.deleteBookRule(id);
    return success("删除成功");
  }

  @PostMapping(value="/update")
  @ApiOperation(value="更新预约规则")
  public ApiResult updateBookRule(@RequestBody FreeBookRuleForm freeBookRuleForm,@RequestHeader String token){
    UserInfoDO userInfoDO=getUserInfoFromToken(token);
    FreeBookRuleDO freeBookRuleDO=new FreeBookRuleDO();
    BeanUtils.copyProperties(freeBookRuleForm,freeBookRuleDO);
    freeBookRuleDO.setUpdateUserId(userInfoDO.getId());
    this.bookRuleService.updateBookRule(freeBookRuleDO);
    return success();
  }
}
