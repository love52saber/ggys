package net.seocoo.ggys.module.memberCard;

import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.member.entity.MemberCardInfoDO;
import net.seocoo.ggys.module.member.service.MemberCardInfoService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 会员卡模块测试类
 * @author PanChengHao
 * @date 2018/6/7 16:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberCardTest {

  @Autowired
  private MemberCardInfoService memberCardInfoService;

  @Autowired
  private RedisUtil redisUtil;

  @Test
  public void selectMemberCardInfoByUserIdMerchantId(){
    MemberCardInfoDO record =memberCardInfoService.selectMemberCardInfoByUserIdMerchantId(3,1);
    System.out.println("record======= " + record);
  }

  @Test
  public void selectMemberCardRemainingMoney(){
    BigDecimal remainingMoney=memberCardInfoService.selectMemberCardRemainingMoney(3,1);
    System.out.print("remainingMoney="+remainingMoney);
  }

  @Test
  public void saveUserInfoToRedis(){
    //将登陆信息放入redis缓存，token是UUID和loginName的拼接；有效期是1天
    String token = StringEx.newUUID()+"_"+"haozi";
    UserInfoDO userInfoDO=new UserInfoDO();
    userInfoDO.setLoginName("haozi");
    userInfoDO.setUuid(StringEx.newUUID());
    userInfoDO.setId(91);
    userInfoDO.setCanDeleted(YesNoEnum.N);
    redisUtil.set(token,userInfoDO,1L, TimeUnit.DAYS);
  }
}
