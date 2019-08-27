package net.seocoo.ggys.module.coupon.entity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/1 8:13
 **/
public class IntegerCompare {
  public static void main(String[] args) {
    Integer a = new Integer( 129);
    Integer b = 129;
    System.out.println(a == b);

    Integer a1 = 125;
    Integer b1 = 125;
    System.out.println(a1 == b1);

    Integer a2 = new Integer( 1115);
    Integer b2 = new Integer(1115);
    System.out.println(a2 == b2);

    Integer a3 = 1115;
    Integer b3 = 1115;
    System.out.println(a3 == b3);

    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("a");
    System.out.println(arrayList.size());
     arrayList.trimToSize();

    Arrays.asList("s");

  }
}
