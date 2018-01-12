package org.bicyclesharing.util;

import org.junit.Test;

import java.util.Date;

/**
 * Created by HuiJa on 2017/8/14.
 */
public class DateExchangeTest {
    @Test
    public void dateToStamp() throws Exception {
        System.out.println(new Date().getTime());
        System.out.println(DateExchange.dateToStamp("2017-8-14 14:54:22"));//这个精确到毫秒,但是格式里只写了s,所以后面三个0
    }

    @Test
    public void stampToStringDate() throws Exception {
        System.out.println(DateExchange.stampToStringDate("1502687764000"));
    }
    @Test
    public void stampToDate() throws Exception {
        System.out.println(DateExchange.stampToDate("1502687764000"));
    }

}