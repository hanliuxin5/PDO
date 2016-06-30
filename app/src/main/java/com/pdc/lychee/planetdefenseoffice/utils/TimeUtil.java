package com.pdc.lychee.planetdefenseoffice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lychee on 2016/6/22.
 */
public class TimeUtil {
    /**
     * 根据传入日期返回该日期的后前一天
     *
     * @param date yyyy-MM-dd
     * @return yyyy-MM-dd
     */
    public static String theDayBefore(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = dateFormat.parse(date);
            long time = date1.getTime() - (24 * 60 * 60 * 1000);
            return dateFormat.format(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 根据传入日期返回该日期的后一天
     *
     * @param date yyyy-MM-dd
     * @return yyyy-MM-dd
     */
    public static String theDayAfter(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = dateFormat.parse(date);
            long time = date1.getTime() + (24 * 60 * 60 * 1000);
            return dateFormat.format(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
