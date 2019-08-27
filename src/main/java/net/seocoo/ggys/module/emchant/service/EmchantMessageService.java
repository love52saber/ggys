package net.seocoo.ggys.module.emchant.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.emchant.constans.ChantTypeEnum;
import net.seocoo.ggys.module.emchant.dto.EmchantIndexDTO;
import net.seocoo.ggys.module.emchant.dto.EmchantMessageUserDTO;
import net.seocoo.ggys.module.emchant.entity.EmchantMessageDO;
import net.seocoo.ggys.module.emchant.query.EmchantMessageQuery;
import net.seocoo.ggys.module.emchant.query.EmchantMessageUserQuery;
import net.seocoo.ggys.module.user.entity.UserInfoDO;

import java.util.List;
import java.util.Map;

/**
 * @Author xieheng
 * @Data 2018/6/19 0019 17:06
 * @Email xieheng91@163.com
 * @Desc TODO
 */
public interface EmchantMessageService {


    EmchantMessageDO get(Integer id);

    /**
     * 新增
     *
     * @param emchantMessageDO 实体类
     * @return dao操作结果
     */
    Boolean save(EmchantMessageDO emchantMessageDO);

    /**
     * 删除
     *
     * @param id 主键
     * @return dao操作结果
     */
    Boolean delete(Integer id);

    /**
     * 更新
     *
     * @param emchantMessageDO 实体类
     * @return doa操作结果
     */
    Boolean update(EmchantMessageDO emchantMessageDO);

    /**
     * 按条件查询返回list结果
     *
     * @param query
     * @return 查询结果list
     */
    List<EmchantMessageDO> listQuery(EmchantMessageQuery query);

    /**
     * 按条件分页查询
     *
     * @param query
     * @return
     */
    PageBean<EmchantMessageDO> pageQuery(EmchantMessageQuery query);

    /**
     * 聊天窗口 基本信息获取
     * @param fromUserUUID
     * @param currUser   当前登录的用户信息
     * @return
     */
    EmchantIndexDTO userTalkMerchantIndex(ChantTypeEnum chantType,String  fromUserUUID, UserInfoDO currUser);

    /**
     * 统计未读消息数
     * @param query
     * @return
     */
    Integer countUnRead(EmchantMessageQuery query);

    /**
     * 设置消息已读
     * @param
     * @return
     */
    Boolean updateRead(String fromUser,String toUser);

    List<EmchantMessageUserDTO> messageUserList(EmchantMessageUserQuery query,UserInfoDO currUser);

    EmchantMessageDO lastMessageByFromUser(Map params);
}
