package net.seocoo.ggys.module.coupon.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/1 11:52
 **/
public class ForeachTest {
  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("1");
    list.add("2");
    for (String item : list) {
      if ("2".equals(item)) {
        list.remove(item);
      }
      System.out.println(item);
    }
  }
}
