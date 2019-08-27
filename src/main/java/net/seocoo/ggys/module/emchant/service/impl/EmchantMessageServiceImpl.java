package net.seocoo.ggys.module.emchant.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.emchat.constans.EmchantConstans;
import net.seocoo.ggys.module.emchant.constans.ChantTypeEnum;
import net.seocoo.ggys.module.emchant.constans.ReadStateEnum;
import net.seocoo.ggys.module.emchant.dto.EmchantIndexDTO;
import net.seocoo.ggys.module.emchant.dto.EmchantMessageDTO;
import net.seocoo.ggys.module.emchant.dto.EmchantMessageUserDTO;
import net.seocoo.ggys.module.emchant.entity.EmchantMessageDO;
import net.seocoo.ggys.module.emchant.mapper.EmchantMessageMapper;
import net.seocoo.ggys.module.emchant.query.EmchantMessageQuery;
import net.seocoo.ggys.module.emchant.query.EmchantMessageUserQuery;
import net.seocoo.ggys.module.emchant.service.EmchantMessageService;
import net.seocoo.ggys.module.merchant.entity.MerchantDTO;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author xieheng
 * @Data 2018/6/19 0019 17:08
 * @Email xieheng91@163.com
 * @Desc TODO
 */
@Service
public class EmchantMessageServiceImpl extends BaseService implements EmchantMessageService {

    @Autowired
    private EmchantMessageMapper messageMapper;

    @Autowired
    private MerchantService merchantService;


    @Autowired
    private UserInfoService userInfoService;


    @Override
    public EmchantMessageDO get(Integer id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean save(EmchantMessageDO emchantMessageDO) {
        insertSetDefaultValue(emchantMessageDO);
        //因为前端环信获取的用户名英文都是小写,所以此处转换成统一大写
        emchantMessageDO.setFromUser(emchantMessageDO.getFromUser().toUpperCase());
        emchantMessageDO.setToUser(emchantMessageDO.getToUser().toUpperCase());
        return messageMapper.insertSelective(emchantMessageDO) < 1 ? false : true;
    }

    @Override
    public Boolean delete(Integer id) {
        return messageMapper.delete(id) < 1 ? false : true;
    }

    @Override
    public Boolean update(EmchantMessageDO emchantMessageDO) {
        updateSetDefaultValue(emchantMessageDO);
        return messageMapper.updateByPrimaryKeySelective(emchantMessageDO) < 1 ? false : true;
    }

    @Override
    public List<EmchantMessageDO> listQuery(EmchantMessageQuery query) {
        return messageMapper.listQuery(query);
    }

    @Override
    public PageBean<EmchantMessageDO> pageQuery(EmchantMessageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<EmchantMessageDO> emchantMessageDOS = this.listQuery(query);
        Integer count = messageMapper.countQuery(query);
        return new PageBean<EmchantMessageDO>(emchantMessageDOS, query.getPageNum(), query.getPageSize(), count);
    }

    @Override
    public EmchantIndexDTO userTalkMerchantIndex(ChantTypeEnum chantType, String fromUserUUID, UserInfoDO currUser) {
        EmchantIndexDTO indexDTO = new EmchantIndexDTO();

        indexDTO.setChantType(chantType);

        indexDTO.setFromUserImgUrl(currUser.getHeadImageUrl());
        indexDTO.setFromUserName(currUser.getLoginName());
        indexDTO.setFromUserNameEmchant(currUser.getUuid());
        indexDTO.setFromUserPassword(EmchantConstans.DEFAULT_PASSWORD);


        UserInfoDO fromUser = null;
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUuid(fromUserUUID);
        userInfoDO.setCanDeleted(YesNoEnum.N);
        List<UserInfoDO> userInfoDOList = userInfoService.queryUserInfoList(userInfoDO);
        fromUser = userInfoDOList.get(0);

        indexDTO.setToUserImgUrl(fromUser.getHeadImageUrl());
        indexDTO.setToUserName(fromUser.getLoginName());
        indexDTO.setToUserNameEmchant(fromUser.getUuid());
        indexDTO.setToUserPassword(EmchantConstans.DEFAULT_PASSWORD);

        if (chantType.equals(ChantTypeEnum.USER_LINK_MERCHANT)) {
            MerchantDTO merchant = merchantService.getMerchantByUserId(fromUser.getId());
            Integer merchantId = merchant.getId();
            indexDTO.setMerchantId(merchantId);
            indexDTO.setToUserImgUrl(merchant.getLogoUrl());
        } else if (chantType.equals(ChantTypeEnum.MERCHANT_LINK_USER)) {
            MerchantDTO merchant = merchantService.getMerchantByUserId(currUser.getId());
            indexDTO.setFromUserImgUrl(merchant.getLogoUrl());
        }

        EmchantMessageQuery query = new EmchantMessageQuery();

        query.setOrderBy("id desc");
        query.setFromUser(currUser.getUuid());
        query.setToUser(fromUser.getUuid());

        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<EmchantMessageDO> messageDOList = listQuery(query);

        List<EmchantMessageDTO> messageDTOList = new ArrayList<>();
        EmchantMessageDTO messageDTO = null;
        for (EmchantMessageDO messageDO : messageDOList) {
            messageDTO = new EmchantMessageDTO();
            BeanUtils.copyProperties(messageDO, messageDTO);
            messageDTOList.add(messageDTO);
        }
        indexDTO.setMessageList(messageDTOList);

        //将消息设置为已读
        updateRead(fromUser.getUuid(), currUser.getUuid());

        return indexDTO;
    }

    @Override
    public Integer countUnRead(EmchantMessageQuery query) {
        return messageMapper.countUnRead(query);
    }

    @Override
    public Boolean updateRead(String fromUser, String currUser) {
        EmchantMessageQuery query = new EmchantMessageQuery();
        query.setFromUser(fromUser);
        query.setToUser(currUser);
        query.setState(ReadStateEnum.READ);
        return messageMapper.updateRead(query) < 1 ? false : true;
    }

    @Override
    public List<EmchantMessageUserDTO> messageUserList(EmchantMessageUserQuery query, UserInfoDO currUser) {
        List<EmchantMessageUserDTO> messageUserDTOList = messageMapper.listMessageUser(query);


        EmchantMessageDO messageDO = null;
        Map<String,Object> params = null;
        for (EmchantMessageUserDTO messageUserDTO : messageUserDTOList) {
            //获取最新消息内容
            params = new HashMap<>();
            params.put("fromUser",messageUserDTO.getFromUser());
            params.put("toUser",currUser.getUuid());
            messageDO = lastMessageByFromUser(params);
            if (messageDO != null) {
                messageUserDTO.setType(messageDO.getType());
                messageUserDTO.setLastTxtMsg(messageDO.getTxtMsg());
                messageUserDTO.setLastImgMsg(messageDO.getImgMsg());
                messageUserDTO.setLastDate(messageDO.getCreateDate());
                //TODO 用户头像
                UserInfoDO fromUser = null;
                UserInfoDO userInfoDO = new UserInfoDO();
                userInfoDO.setUuid(messageUserDTO.getFromUser());
                userInfoDO.setCanDeleted(YesNoEnum.N);
                List<UserInfoDO> userInfoDOList = userInfoService.queryUserInfoList(userInfoDO);
                fromUser= userInfoDOList.get(0);

                messageUserDTO.setFromUserImgUrl(fromUser.getHeadImageUrl());
                messageUserDTO.setFromUserName(fromUser.getFullName());
            }
        }
        Collections.sort(messageUserDTOList, new Comparator<EmchantMessageUserDTO>() {
            @Override
            public int compare(EmchantMessageUserDTO o1, EmchantMessageUserDTO o2) {
//                if(o1.getUnReadCount().equals(o2.getUnReadCount())){
                    return  o2.getLastDate().compareTo(o1.getLastDate());
//                }else{
//                    return  o2.getUnReadCount().compareTo(o1.getUnReadCount());
//                }
            }
        });

        return messageUserDTOList;
    }

    @Override
    public EmchantMessageDO lastMessageByFromUser(Map params) {
        return messageMapper.lastMessageByFromUser(params);
    }
}
