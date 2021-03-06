package net.seocoo.ggys.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc  string工具类
 */
public class StringEx
{
    private static final Logger logger = LoggerFactory.getLogger(StringEx.class);

    public static final String newRid(String serial)
    {
        return newUUID() + serial;
    }

    public static final String newUUID()
    {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static final String safetyChar(String c)
    {
        try
        {
            c = new String(c.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("safetyChar", e);
            return "";
        }

        return c.replace("\"", "").replace("'", "");
    }

    public static final boolean stringIsNullOrEmpty(String s)
    {
        return (s == null) || (s.isEmpty());
    }

    public static final <T> String stringJoin(List<T> array, String separator)
    {
        if (array == null) {
            return null;
        }
        int arraySize = array.size();

        int bufSize = arraySize == 0 ? 0 :
                ((array.get(0) == null ? 16 : array
                        .get(0)
                        .toString().length()) + 1) * arraySize;

        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = 0; i < arraySize; i++) {
            if (i > 0) {
                buf.append(separator);
            }
            if (array.get(i) != null) {
                buf.append(array.get(i));
            }
        }
        return buf.toString();
    }

    public static final String stringJoin(String[] array, String separator)
    {
        if (array == null) {
            return null;
        }
        int arraySize = array.length;
        int bufSize = arraySize == 0 ? 0 : ((array[0] == null ? 16 : array[0].toString().length()) + 1) * arraySize;
        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = 0; i < arraySize; i++) {
            if (i > 0) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

    public static List<String> stringToList(String s)
    {
        if ((s == null) || (s.isEmpty())) {
            return new LinkedList();
        }
        List list = new ArrayList();
        String[] str = s.split(";");
        for (String string : str) {
            list.add(string);
        }
        return list;
    }

    public static String removeStartChar(String str, String c)
    {
        if ((str.length() > 1) && (str.startsWith(c))) {
            return str.substring(1);
        }
        return str;
    }

    public static String removeEndChar(String str, String c)
    {
        if ((str.length() > 1) || (str.endsWith(c))) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    /**
     * 获取订单号
     * @return
     */
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }

    /**
     * 随机的4位数
     * @return
     */
    public static String random4(){
        Random random = new Random();
        StringBuilder result= new StringBuilder(4);
        for(int i=0;i<4;i++){
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
    /**
     * 随机的N位数
     * @return
     */
    public static String randomByNum(int num){
        Random random = new Random();
        StringBuilder result= new StringBuilder(num);
        for(int i=0;i<num;i++){
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
}