package net.seocoo.ggys.module.emchant.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.module.emchant.constans.ChantTypeEnum;
import net.seocoo.ggys.module.emchant.constans.ReadStateEnum;
import net.seocoo.ggys.module.emchant.entity.EmchantMessageDO;
import net.seocoo.ggys.module.emchant.form.MessageForm;
import net.seocoo.ggys.module.emchant.query.EmchantMessageQuery;
import net.seocoo.ggys.module.emchant.query.EmchantMessageUserQuery;
import net.seocoo.ggys.module.emchant.service.EmchantMessageService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xieheng
 * @Data 2018/6/19 0019 11:08
 * @Email xieheng91@163.com
 * @Desc 即时通讯
 */
//@CrossOrigin
@Api(value = "即时通讯", description = "即时通讯")
@RestController
@RequestMapping(value = "/emchant")
public class EmchantController extends BaseController {
    @Autowired
    private EmchantMessageService messageService;

    @ApiOperation(value = "h5用户消息商家聊天窗口进入获取基本信息接口")
    @GetMapping(value = "/h5/index/{ChantTypeEnum}/{fromUser}")
    public ApiResult index(@ApiParam(value = "联系类型") @PathVariable("ChantTypeEnum") ChantTypeEnum chantType,
                           @ApiParam(value = "id,根据联系类型,若用户联系商户,传merchantId;若商户联系用户,传userId") @PathVariable("fromUser") String fromUser) {

        UserInfoDO currUser = getUserInfoFromToken(this.getToken());
        return success(messageService.userTalkMerchantIndex(chantType, fromUser, currUser));
    }

    @ApiOperation(value = "保存聊天消息")
    @PostMapping(value = "/h5/message")
    public ApiResult addMessage(@RequestBody MessageForm messageForm) {
        EmchantMessageDO messageDO = new EmchantMessageDO();
        BeanUtils.copyProperties(messageForm, messageDO);
        messageService.save(messageDO);
        return success();

    }

    @ApiOperation(value = "查询当前用户未读消息总数")
    @GetMapping(value = "/h5/unread")
    public ApiResult countUnRead() {
        EmchantMessageQuery query = new EmchantMessageQuery();
        query.setState(ReadStateEnum.UN_READ);

        UserInfoDO userInfo = getUserInfoFromToken(getToken());
        String uuid = userInfo.getUuid();
        query.setToUser(uuid);

        return success(messageService.countUnRead(query));
    }


    @ApiOperation(value = "消息列表")
    @GetMapping(value = "/h5/message")
    public ApiResult listMessageUser() {
        UserInfoDO currUser = getUserInfoFromToken(this.getToken());
        EmchantMessageUserQuery query = new EmchantMessageUserQuery();
        query.setToUser(currUser.getUuid());
        return success(messageService.messageUserList(query, currUser));
    }

    @ApiOperation(value = "聊天记录分页")
    @GetMapping(value = "/h5/message/page/{fromUser}/{toUser}")
    public ApiResult pageMessage(EmchantMessageQuery messageQuery) {
        messageQuery.setOrderBy("id desc");
        return success(messageService.pageQuery(messageQuery));
    }


}
