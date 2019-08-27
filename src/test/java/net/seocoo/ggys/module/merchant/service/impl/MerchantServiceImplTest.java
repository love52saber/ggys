package net.seocoo.ggys.module.merchant.service.impl;

import net.seocoo.ggys.module.merchant.query.MerchantQuery;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/15 15:49
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchantServiceImplTest {

  @Autowired
  private MerchantService merchantService;
  @Test
  public void listClientH5Index() {
    UserInfoDO userInfoDO = new UserInfoDO();
    userInfoDO.setId(18);
    merchantService.listClientH5Index(new MerchantQuery(), userInfoDO);
  }
}