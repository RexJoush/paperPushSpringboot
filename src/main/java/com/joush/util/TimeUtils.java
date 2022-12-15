package com.joush.util;

/**
 * @author Rex Joush
 * @time 2021.03.29
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 关于时间的格式化信息
 */
public class TimeUtils {

    // 格式化时间
    public static String strDateFormat = "yyyy-MM-dd HH:mm:ss";
    public static String createDate = "yyyy-MM-dd";
    public static SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
    public static SimpleDateFormat sdfCreate = new SimpleDateFormat(createDate);

    /**
     * 获取一周前的时间值
     * @return 格式为 2022-02-10
     */
    public static String getRecentWeek() {
        return sdfCreate.format(new Date().getTime() - 1000 * 60 * 60 * 24 * 7);
    }

    public static String[] getRecent7Date() {
        long now = new Date().getTime();
        String s0 = sdfCreate.format(now);
        String s1 = sdfCreate.format(now - 1000 * 60 * 60 * 24);
        String s2 = sdfCreate.format(now - 1000 * 60 * 60 * 24 * 2);
        String s3 = sdfCreate.format(now - 1000 * 60 * 60 * 24 * 3);
        String s4 = sdfCreate.format(now - 1000 * 60 * 60 * 24 * 4);
        String s5 = sdfCreate.format(now - 1000 * 60 * 60 * 24 * 5);
        String s6 = sdfCreate.format(now - 1000 * 60 * 60 * 24 * 6);
        return new String[]{s6, s5, s4, s3, s2, s1, s0};
    }
}
