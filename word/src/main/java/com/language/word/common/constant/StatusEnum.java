package com.language.word.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/4.
 */
public enum StatusEnum {
    valid(1, "有效"),
    invalid(0, "无效");
    private Integer value;
    private String desc;

    StatusEnum(Integer value, String desc) {
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
        for (StatusEnum s : values()) {
            if (s.value == value) {
                return s.desc();
            }
        }
        return null;
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> timeMap = new HashMap<Integer, String>();
        for (StatusEnum s : values()) {
            timeMap.put(s.value, s.desc);
        }
        return timeMap;
    }
}
