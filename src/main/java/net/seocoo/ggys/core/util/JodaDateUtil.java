package net.seocoo.ggys.core.util;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
/**
 * @author PanChengHao
 * @date 2018/6/11 20:15
 */
public class JodaDateUtil {
  public static final String YYYY_MM_DD_HH_MM_SS_DASH = "yyyy-MM-dd HH:mm:ss";
  /**
   * 查询指定日期的上月的开始时间与结束时间 ZengXiaoLiang 2016年6月13日 下午5:04:48
   *
   * @param currDate
   * @return
   */
  public static Date[] getLastMonthStartAndEndDate(Date currDate) {
    Date[] dates = new Date[2];
    DateTime dt = new DateTime(currDate).minusMonths(1);
    DateTime start = new DateTime(dt.getYear(), dt.getMonthOfYear(), 1, 0, 0, 0);
    dates[0] = start.toDate();
    DateTime end = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.dayOfMonth().getMaximumValue(), 23, 59, 59);
    dates[1] = end.toDate();
    return dates;
  }

  /**
   *
   * @author ZeyangWu
   * @date 2017年5月5日下午2:58:02
   * @Description:  根据当前时间获取上周日期区域
   */
  public static Date[] getLastWeekStartAndEndDate(Date currDate) {
    Date[] dates = new Date[2];
    DateTime dt = new DateTime(currDate).minusWeeks(1);
    DateTime start = dt.minusDays(dt.getDayOfWeek()-1).withTimeAtStartOfDay().toDateTime();
    DateTime end = dt.plusDays(8-dt.getDayOfWeek()).withTimeAtStartOfDay().toDateTime();
    dates[0] = start.toDate();
    dates[1] = end.toDate();
    return dates;
  }

  /**
   * 查询指定日期一天的开始时间。时分秒为 00:00:00 ZengXiaoLiang 2016年9月27日 下午12:38:11
   *
   * @param date
   * @return
   */
  public static Date getStartDate(Date date) {
    DateTime dt = new DateTime(date).withTimeAtStartOfDay();
    return dt.toDate();
  }

  /**
   * 查询指定日期的一天的结束时间 ZengXiaoLiang 2016年9月27日 下午1:01:04
   *
   * @param date
   * @return
   */
  public static Date getEndDate(Date date) {
    DateTime dt = new DateTime(date).plusDays(1).withTimeAtStartOfDay().minusMillis(1);
    return dt.toDate();
  }

  /**
   * 增加天数 ZengXiaoLiang 2016年10月24日 上午11:26:40
   *
   * @param date
   * @param days
   * @return
   */
  public static Date plusDays(Date date, int days) {
    return new DateTime(date).plusDays(days).toDate();
  }

  /**
   * 增加小时 ZengXiaoLiang 2017年2月28日 下午2:07:32
   *
   * @param date
   * @param hours
   * @return
   */
  public static Date plusHours(Date date, int hours) {
    return new DateTime(date).plusHours(hours).toDate();
  }

  /**
   * 增加分钟 ZengXiaoLiang 2017年3月31日 下午3:19:44
   *
   * @param date
   * @param minutes
   * @return
   */
  public static Date plusMinutes(Date date, int minutes) {
    return new DateTime(date).plusMinutes(minutes).toDate();
  }
  /**
   * 使用默认格式解析 yyyy-MM-dd HH:mm:ss
   *
   * @param datetime
   * @return
   */
  public static Date parseStr2Date(String datetime) {
    DateTimeFormatter dtf = DateTimeFormat.forPattern(YYYY_MM_DD_HH_MM_SS_DASH);
    DateTime dt = DateTime.parse(datetime, dtf);
    return dt.toDate();
  }
  /**
   * 计算俩个时间之间的分钟数
   * chenyg 2017年8月3日 上午11:22:21
   *
   * @param start
   * @param end
   * @return
   */
  public static int getDurationMinutes(Date start,Date end){
    Minutes diff =  Minutes.minutesBetween(new DateTime(start), new DateTime(end));
    return diff.getMinutes();
  }
  /**
   * 计算某个时间段中的时间  hh小时mm分钟
   * chenyg 2017年8月3日 上午11:35:43
   *
   * @param start
   * @param end
   * @return
   */
  public static String getDurationHourAndMinutes(Date start,Date end){
    Minutes diff =  Minutes.minutesBetween(new DateTime(start), new DateTime(end));
    int minutes = diff.getMinutes();
    int hour = 0;
    int day = 0;
    if(minutes >= 24 * 60){
      day = minutes / (24 * 60);
      minutes = minutes - (day * 24 * 60);
    }
    if(minutes >= 60){
      hour = minutes / 60;
      minutes = minutes - (hour * 60);
    }

    return day+"天"+hour+"时"+minutes+"分";
  }
  /**
   * 将Date转换为String
   * ZengXiaoLiang 2016年11月28日 下午1:28:01
   * @param date
   * @param dataPattern 使用HigoDatetimeUtils.YYYY_MM_DD_HH_MM_SS_DASH
   * @return
   */
  public static String date2String(Date date, String dataPattern) {
    if (date != null) {
      return new DateTime(date).toString(dataPattern);
    } else {
      return "";
    }
  }
}
