package com.language.word.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/6/12.
 */
public class DateUtil {
    /**
     *
     * @param d
     * @param min
     * @return
     */
    public static Date addMinute(Date d,int min){
        Calendar cal=Calendar.getInstance(new Locale("zh-CN"));
        cal.setTime(d);
        cal.add(Calendar.MINUTE,min);
        return cal.getTime();
    }

    /**
     * 日期增加小时
     * @param d
     * @param hours
     * @return
     */
    public static Date addHour(Date d,int hours){
        Calendar cal=Calendar.getInstance(new Locale("zh-CN"));
        cal.setTime(d);
        cal.add(Calendar.HOUR,hours);
        return cal.getTime();
    }

    /**
     * 日期增加天数
     * @param d
     * @param days
     * @return
     */
    public static Date addDay(Date d,int days){
        Calendar cal=Calendar.getInstance(new Locale("zh-CN"));
        cal.setTime(d);
        cal.add(Calendar.DATE,days);
        return cal.getTime();
    }
}
