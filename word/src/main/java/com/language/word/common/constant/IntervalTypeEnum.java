package com.language.word.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/4.
 */
public enum IntervalTypeEnum {
    min(1, "分钟"),
    hour(2, "小时"),
    week(3, "天");
    private Integer value;
    private String desc;

    IntervalTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer value() {
        return this.value;
    }

    public String desc() {
        return this.desc;
    }

    public static String getDesc(Integer value) {
        for (IntervalTypeEnum s : values()) {
            if (s.value == value) {
                return s.desc();
            }
        }
        return null;
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> timeMap = new HashMap<Integer, String>();
        for (IntervalTypeEnum s : values()) {
            timeMap.put(s.value, s.desc);
        }
        return timeMap;
    }
}
