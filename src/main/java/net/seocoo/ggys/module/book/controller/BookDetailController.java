package net.seocoo.ggys.module.book.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.book.entity.FreeBookDetailDO;
import net.seocoo.ggys.module.book.form.FreeBookDetailForm;
import net.seocoo.ggys.module.book.form.FreeBookDetailUpdateForm;
import net.seocoo.ggys.module.book.query.BookDetailQuery;
import net.seocoo.ggys.module.book.service.BookDetailService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 预约详情业务类
 * @author PanChengHao
 * @date 2018/5/31 20:29
 */
@Api(value="预约详情接口" ,description = "预约详情接口")
@RestController
@RequestMapping(value = "/h5/bookDetail")
public class BookDetailController extends BaseController {
  @Autowired
  private BookDetailService bookDetailService;

  @PostMapping(value = "/add")
  @ApiOperation(value="新增预约详情")
  public ApiResult saveBookDetail(@RequestBody FreeBookDetailForm freeBookDetailForm,@RequestHeader String token) {
    UserInfoDO userInfoDO=getUserInfoFromToken(token);
    FreeBookDetailDO freeBookDetailDO=new FreeBookDetailDO();
    BeanUtils.copyProperties(freeBookDetailForm,freeBookDetailDO);
    freeBookDetailDO.setBookUserId(userInfoDO.getId());
    bookDetailService.saveBookDetail(freeBookDetailDO);
    return success();
  }

  @GetMapping(value = "/list")
  @ApiOperation(value="分页查询预约详情列表")
  public ApiResult listByPageQuery(BookDetailQuery query) {
    return success(bookDetailService.listByPageQuery(query));
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value="查询预约详情")
  public ApiResult queryBookRule(@PathVariable("id") @ApiParam(value="主键" , defaultValue="3" ,required = true) int id) {
    return success(bookDetailService.getBookDetailById(id));
  }

  @GetMapping(value = "/delete")
  @ApiOperation(value="删除预约详情")
  public ApiResult deleteBookDetail(int id) {
    bookDetailService.deleteBookDetail(id);
    return success();
  }

  @PostMapping(value = "/cancel")
  @ApiOperation(value="取消预约详情")
  public ApiResult cancelBookDetail(@RequestBody FreeBookDetailUpdateForm freeBookDetailUpdateForm) {
    FreeBookDetailDO freeBookDetailDO=new FreeBookDetailDO();
    BeanUtils.copyProperties(freeBookDetailUpdateForm,freeBookDetailDO);
    bookDetailService.updateBookDetail(freeBookDetailDO);
    return success();
  }

  @PostMapping(value="/audit")
  @ApiOperation(value="审核预约")
  public ApiResult auditBookDetail(@RequestBody FreeBookDetailUpdateForm freeBookDetailUpdateForm){
    FreeBookDetailDO freeBookDetailDO=new FreeBookDetailDO();
    BeanUtils.copyProperties(freeBookDetailUpdateForm,freeBookDetailDO);
    bookDetailService.updateBookDetail(freeBookDetailDO);
    return success();
  }
}
