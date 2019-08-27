package net.seocoo.ggys.module.coupon.service;

import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateStateEnum;
import net.seocoo.ggys.module.coupon.entity.CouponTemplateDO;
import net.seocoo.ggys.module.coupon.service.impl.CouponTemplateServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author ZengXiaoLiang
 * @date 2018/5/29 15:52
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponTemplateServiceTest {

  @Autowired
  private CouponTemplateService couponTemplateServiceImpl;


  @Test
  public void getCouponTemplateById() {
    System.out.println(this.couponTemplateServiceImpl.getCouponTemplateById(4));
  }

  @Test
  public void listCouponTemplateByMerchantId() {
    this.couponTemplateServiceImpl.listCouponTemplateByMerchantId(1).forEach(record -> System.out.println(record));
  }
}