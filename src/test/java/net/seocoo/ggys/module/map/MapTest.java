package net.seocoo.ggys.module.map;

import net.seocoo.ggys.core.util.map.MapUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试高德地图api
 * @author PanChengHao
 * @date 2018/6/6 20:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapTest {

  /**
   * 测试获取经纬度
   */
  @Test
  public void getLatLngTest(){
    String address="越秀苑";
    String city="合肥市";
    String resResult=MapUtil.getLatLng(address,city);
    System.out.println("location:"+resResult);
  }

  /**
   * 测试根据经纬度获取详细地址
   */
  @Test
  public void getAddressDetail(){
    Map<String,Object> map=new HashMap<>();
    String lng="117.286156";
    String lat="31.863397";
    String result=MapUtil.getAddressDetail(null,null,"");
    System.out.println("result:"+result);
  }

  /**
   * 测试根据经纬度获取距离
   */
  @Test
  public void distanceTest(){
    System.out.println(MapUtil.GetDistance(31.863397,117.286156,31.86449,117.886479));
  }
}
