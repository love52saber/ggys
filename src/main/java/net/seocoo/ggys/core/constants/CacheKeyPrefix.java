package net.seocoo.ggys.core.constants;

/**
 * 缓存Key前缀
 *
 * @author ZengXiaoLiang
 * @date 2018/6/5 15:43
 **/
public class CacheKeyPrefix {

    public static final String SEPARATOR = ":";


    static final String SYS = "SYS";

    /**
     * 枚举类型
     */
    public static final String SYS_ENUM_NAME = SYS + SEPARATOR + "ENUM_NAME" + SEPARATOR;


    /**
     * 行业分类前缀
     */

    public static final String CLASSIFY = "CLASSIFY";


    /**
     * 一级分类前缀
     */
    public static final String CLASSIFY_FIRST = CLASSIFY + SEPARATOR + "FIRST";

    /**
     * 二级分类前缀
     */
    public static final String CLASSIFY_SECOND = CLASSIFY + SEPARATOR + "SECOND";

    public static final String USER_INFO = "USER_INFO";
    /**
     * 用户ID前缀
     */
    public static final String USER_INFO_ID = USER_INFO + SEPARATOR + "ID" + SEPARATOR;

    public static final String MERCHANT = "MERCHANT";

    public static final String MERCHANT_USER_ID = MERCHANT + SEPARATOR + USER_INFO + SEPARATOR;

    /**
     * 一级分类下的商户列表
     */
    public static final String MERCHANT_CLASSIFY_FIRST = MERCHANT + SEPARATOR + CLASSIFY_FIRST + SEPARATOR;

    /**
     * 二级分类下的商户列表
     */
    public static final String MERCHANT_CLASSIFY_SECOND = MERCHANT + SEPARATOR + CLASSIFY_SECOND + SEPARATOR;

    public static final String CITY = "CITY" + SEPARATOR;

    /**
     * 二级分类城市下商户
     */
    public static final String MERCHANT_CLASSIFY_SECOND_CITY = MERCHANT_CLASSIFY_SECOND + CITY;

    /**
     * 一级分类城市下商户
     */
    public static final String MERCHANT_CLASSIFY_FIRST_CITY = MERCHANT_CLASSIFY_FIRST + CITY;

    /**
     * 商户标签
     */

    public static final String MERCHANT_LABEL = MERCHANT + SEPARATOR +"LABEL" +SEPARATOR;

  /**
   * 会员
   */
  public static final String MEMBER = "MEMBER";

  /**
   * 会员商家
   */
  public static final String MEMBER_MERCHANT = MEMBER+ SEPARATOR + MERCHANT + SEPARATOR;

    /**
     * 距离最近会员商家
     */
  public static final String MEMBER_MERCHANT_DISTANCE_NEAREST = MEMBER_MERCHANT+"DISTANCE:NEAREST";

    /**
     * 登陆用户
     */
    public static final String LOGIN_USERINFO = "LOGIN_USERINFO";

  /**
   * 优惠券模板
   */
  public static final String COUPON_TEMPLATE = "COUPON_TEMPLATE" + SEPARATOR ;

  /**
   * 优惠券模板Id
   */
  public static final String COUPON_TEMPLATE_ID = COUPON_TEMPLATE + "ID" + SEPARATOR;

  /**
   * 优惠券商家Id
   */
  public static final String COUPON_TEMPLATE_MERCHANT_ID = COUPON_TEMPLATE + "MERCHANT_ID" + SEPARATOR;

}
