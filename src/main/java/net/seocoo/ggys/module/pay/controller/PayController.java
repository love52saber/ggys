package net.seocoo.ggys.module.pay.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.util.BapUtil;
import net.seocoo.ggys.module.pay.entity.OrderForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangpan
 * @date 2018/6/13 14:15
 */
//@CrossOrigin
@Api(value = "支付",description = "支付相关接口")
@RestController
@RequestMapping(value = "/pay")
public class PayController extends BaseController {

  /**
   * 新大陆的机构号
   */
  @Value("${new.land.organ.no}")
  String organNo;

  @Value("${systemConfig.appId}")
  private String appId;

  @Value("${domain.url}")
  private String domainUrl;

  /**
   * 接口地址
   */
  @Value("${unite.interface.url}")
  String interfaceUrl;

  @PostMapping(value = "/getWxCode/{merchantCode}")
  @ApiOperation(value = "获取微信code")
  public void getWxCode(@PathVariable(value = "merchantCode") String merchantCode, HttpServletResponse response) throws IOException {
    String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE&connect_redirect=1#wechat_redirect";
    url = url.replace("APPID", appId);

    String rurl = domainUrl+"/pay/toWechatPayForXdl/" + merchantCode;
    rurl = java.net.URLEncoder.encode(rurl, "utf-8");

    url = url.replace("REDIRECT_URI", rurl);
    // url = url.replace("SCOPE", "snsapi_userinfo");
    url = url.replace("SCOPE", "snsapi_base");
    url = url.replace("STATE", "123");
    response.sendRedirect(url);
  }

  @PostMapping(value = "/toWechatPayForXdl/{merchantCode}")
  @ApiOperation(value = "获取微信code")
  public void toWechatPayForXdl(@PathVariable(value = "merchantCode") String merchantCode,HttpServletRequest request) {

    String code = request.getParameter("code");
    logger.info("code====="+code);

  }

  @PostMapping(value = "/toPay")
  @ApiOperation(value = "下单去支付")
  public ApiResult toPay(OrderForm order) {
    String p = JSONObject.toJSONString(order);
    String requesMessage = BapUtil.generateRequestMessage(p, "xdlWechatOfficatAccountPay");
    //调用公众号支付接口前，必须调用公众号查询接口
    String back = BapUtil.httpSendJson(interfaceUrl, requesMessage);
    return success(back);
  }

}
