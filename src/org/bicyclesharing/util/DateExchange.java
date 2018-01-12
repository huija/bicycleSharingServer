package org.bicyclesharing.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java里面的时间戳精确到毫秒,而Linux精确到秒,所以两者间的转换需要乘除1000
 * Created by HuiJa on 2017/8/14.
 */
public class DateExchange {
    /**
     * 时间转换成时间戳
     *
     * @param s String类型时间(2017-8-14 14:54:22)
     *          (Date对象的getTime()方法是获取时间戳的)
     * @return 时间戳
     * @throws ParseException
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 时间戳转化成时间(String/Date类型)
     *
     * @param s 时间戳
     * @return Date类型时间
     */
    public static String stampToStringDate(String s) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        String d = simpleDateFormat.format(lt);//这是String类型时间(格式如上)
        return d;
    }

    public static Date stampToDate(String s) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = stampToStringDate(s);//这是String类型时间(格式如上)
        Date date = simpleDateFormat.parse(d);//这是Date类型
        return date;
    }
}
