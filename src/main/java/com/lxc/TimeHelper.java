package com.lxc;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * @author lixb
 * @version v1.0
 * @Title CurrentTimeHelper.java
 * @Description 返回当前时间，计算两个时间的差值
 * @date 2016年3月7日 下午1:29:33
 */
public class TimeHelper {

    /**
     * 返回当前时间和另一个时间的差值，单位为s
     */
    public static int timeCompare(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }

        try {
            return (int) ((date2.getTime() - date1.getTime()) / 1e3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 返回当前时间
     */
    public static String getTimeNow() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        return time;
    }

    /**
     * 返回当前日期
     */
    public static String getDateNow() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String time = df.format(new Date());
        return time;
    }

    /**
     * 返回时间对应的字符串
     */
    public static String getTimeStr(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        return time;
    }

    /**
     * 返回时间对应的字符串
     */
    public static String getTimeStr(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        String time = df.format(date);
        return time;
    }

    /**
     * 返回当前时间对应的字符串，全部由数字组成
     *
     * @return
     */
    public static String getTimeNumberStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = df.format(new Date());
        return time;
    }

    /**
     * 生成年月日
     *
     * @return
     */
    public static int[] getYMD() {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR) - 2000;
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        return new int[]{year, month, day};
    }

    /**
     * 获取diffTime之前的时间
     *
     * @param date
     * @param diffTime 秒
     * @return
     */
    public static String getHistoryTime(Date date, long diffTime) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(Long.valueOf(date.getTime() - diffTime * 1000));
        return time;
    }

    public static Date getDateFromStr(String str) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            Date time = df.parse(str);
            return time;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getFmtDate(String str, String pattern) throws ParseException {
        if (StringUtils.isBlank(pattern)) {
            pattern = "yyyyMMdd HH:mm:ss";
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.parse(str);
    }

    public static String getYMD(Integer date) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, date);
        Date time = cal.getTime();
        String YMD = new SimpleDateFormat("yyyy-MM-dd").format(time);
        return YMD;
    }

    public static String getHistoryDate(Date date, int day, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, day);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static String getFmtStr(String str, String pattern){
        if (StringUtils.isBlank(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter1.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat formatter2 = new SimpleDateFormat(pattern);
        return formatter2.format(date);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(getFmtStr("2017-12-01 12:20:12", "yyyy-MM-dd 00:05:00"));
    }
}