package com.language.word.util;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/12.
 */
public class IntervalUtil {
    /**
     * 根据类型，生成下次回忆时间
     * @param intervalType
     * @param intervalValue
     * @return
     */
    public static Date getIntervalTime(Integer intervalType,Long intervalValue){
        Date curDate=new Date();
        switch (intervalType){
            case 1:
                return DateUtil.addMinute(curDate,intervalValue.intValue());
            case 2:
                return DateUtil.addHour(curDate,intervalValue.intValue());
            case 3:
                return DateUtil.addDay(curDate,intervalValue.intValue());
            default:
                return null;

        }
    }
}
