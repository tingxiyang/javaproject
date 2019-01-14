package com.zhl.util;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.math.NumberUtils;


/**
 * Created by zhl on 18/6/11 下午5:08.
 */
public class DateUtils {
    public static String dateFormat = "yyyy-MM-dd";
    public static String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    private static ThreadLocal<DateFormat> ZERO_TIME_FORMAT = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        }
    };
    private static ThreadLocal<DateFormat> FINAL_TIME_FORMAT = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        }
    };
    private static ThreadLocal<DateFormat> simpleDateFormat = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    public static final String[][] DATE_SPECIAL_STRS = new String[][]{{"．", "-"}, {"/", "-"}, {"／", "-"}, {".", "-"}, {"：", ":"}, {"——", "-"}, {"－", "-"}, {"年", "-"}, {"月", "-"}, {"日", ""}};
    public static final String SBC_BLANK = "　";
    public static final String DBC_BLANK = " ";
    public static final Calendar CAL = Calendar.getInstance();
    public static final int BEGIN_YEAR = 1899;
    public static final int MONTH_DAY = 30;
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    private static ThreadLocal<Map<String, DateFormat>> threadLocal;
    public static final int MIN_DAY_1899_12_30 = 23377;
    public static final int MAX_DAY_1899_12_30 = 146463;
    public static final int SECOND_MILLISECOND = 1000;
    public static final int DAY_HOUR = 24;
    public static final int HOUR_SECOND = 3600;
    public static final int STR_LEN4 = 4;
    public static final int STR_LEN6 = 6;
    public static final int STR_LEN8 = 8;
    public static final int STR_LEN9 = 9;

    public DateUtils() {
    }

    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public static Date parseDate(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern == null ? dateFormat : pattern);

        try {
            return sdf.parse(date);
        } catch (ParseException var4) {
            var4.printStackTrace();
            logger.debug("string {} can't parse to date as pattern {}", date, pattern);
            return null;
        }
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            return sdf.format(date);
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static String format(Date date) {
        return formatDate(date, dateTimeFormat);
    }

    public static Date getDayFirstMonthZeroTime(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(2, num);
        cal.set(5, 1);
        Date theDate = cal.getTime();
        return parseDate(((DateFormat)ZERO_TIME_FORMAT.get()).format(theDate), "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getDayEndMonthFinalTime(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(2, num + 1);
        cal.set(5, 1);
        cal.add(5, -1);
        Date after = cal.getTime();
        return parseDate(((DateFormat)FINAL_TIME_FORMAT.get()).format(after).toString(), "yyyy-MM-dd HH:mm:ss");
    }

    public static Date addDay(Date date, int num) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(5, num);
        date = calendar.getTime();
        return date;
    }

    public static Date addMinutes(Date date, int num) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(12, num);
        date = calendar.getTime();
        return date;
    }

    public static long dateDiff(Date d1, Date d2) {
        long n1 = d1.getTime();
        long n2 = d2.getTime();
        long diff = Math.abs(n1 - n2);
        diff /= 86400000L;
        return diff;
    }

    public static boolean isDate(String value, DateFormat sdf) {
        return isDate(value, sdf, false);
    }

    public static boolean isDate(String value, DateFormat sdf, boolean isLenient) {
        ParsePosition pos = new ParsePosition(0);
        if (value != null && sdf != null) {
            try {
                if (!isLenient) {
                    value = replaceSpecial(value);
                }

                sdf.setLenient(false);
                Date date = sdf.parse(value, pos);
                if (date == null) {
                    return false;
                } else {
                    return pos.getIndex() <= sdf.format(date).length();
                }
            } catch (Exception var5) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isDate(String value, String format, boolean isLenient) {
        return value != null && format != null && !"".equals(format) ? isDate(value, getDateFormat(format), isLenient) : false;
    }

    public static String dateToStamp(String date, String pattern) {
        String result = "";

        try {
            long ts = parseDate(date, pattern).getTime() / 1000L;
            result = String.valueOf(ts);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }

    public static synchronized DateFormat getDateFormat(String dateFormat) {
        Map<String, DateFormat> map = (Map)threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
        }

        DateFormat df = (DateFormat)((Map)map).get(dateFormat);
        if (df == null) {
            df = new SimpleDateFormat(dateFormat);
            ((Map)map).put(dateFormat, df);
            threadLocal.set(map);
        }

        return (DateFormat)df;
    }

    public static boolean isEmpty(String input) {
        return input == null || input.length() == 0;
    }

    public static boolean isNumeric(String input) {
        Pattern ss;
        if (isEmpty(input)) {
            return false;
        } else {
           ss = Pattern.compile("^(((-?\\d+)(\\.\\d+))|((-?)(\\.?)(\\d+))|((-?)(\\d+)(\\.?))|((\\d+)(\\.?)((\\d+)|())[Ee]{1}(-?)([1-9]+)))$");
            Matcher dd = ss.matcher(input);
            return dd.find();
        }
    }

    public static boolean isInteger(String str, boolean supportMinus) {
        if (isEmpty(str)) {
            return false;
        } else {
            String expression = "^(\\d+)$";
            if (supportMinus) {
                expression = "^(-?\\d+)$";
            }

            Pattern ss = Pattern.compile(expression);
            Matcher dd = ss.matcher(str);
            return dd.find();
        }
    }

    public static String extendTrim(String str) {
        if (str != null && str.length() != 0) {
            if (str.contains("　")) {
                str = str.replace("　", " ");
            }

            return str.trim();
        } else {
            return str;
        }
    }

    public static String replaceSpecial(String str) {
        if (str != null && str.length() != 0) {
            Calendar cur;
            if (isNumeric(str)) {
                int strInt = (int)Double.parseDouble(str);
                if (strInt >= 23377 && strInt <= 146463) {
                    cur = (Calendar)CAL.clone();
                    cur.add(5, strInt);
                    str = getDateFormat("yyyy-MM-dd").format(cur.getTime());
                }
            }

            if (Pattern.matches("(^\\d+\\.{1}\\d+[Ee]{1}[+]?\\d+$)", str)) {
                Double strDou = Double.parseDouble(str);
                str = strDou.toString().trim();
            }

            if (Pattern.matches("(^\\d+\\.{1}[0]++$)", str)) {
                str = str.substring(0, str.indexOf("."));
            }

            StringBuilder sb = new StringBuilder();
            if (str.length() == 6 && isInteger(str, false)) {
                sb.append(str.substring(0, 4));
                sb.append("-");
                sb.append(str.substring(4));
                sb.append("-01");
                str = sb.toString();
            }

            if (str.length() == 8 && isInteger(str, false)) {
                sb.append(str.substring(0, 4));
                sb.append("-");
                sb.append(str.substring(4, 6));
                sb.append("-");
                sb.append(str.substring(6));
                str = sb.toString();
            }

            str = extendTrim(str);
            String[][] var9 = DATE_SPECIAL_STRS;
            int var3 = var9.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String[] ss = var9[var4];
                if (str.contains(ss[0])) {
                    str = str.replace(ss[0], ss[1]);
                }
            }

            if (str.indexOf("-") > 0 && str.indexOf("-") == str.lastIndexOf("-")) {
                str = str + "-01";
            }

            if (str.length() >= 6 && str.length() <= 8 && str.indexOf("-") > 0 && str.endsWith("-")) {
                str = str + "01";
            }

            if (str.length() == 9 || str.length() == 8) {
                cur = null;

                try {
                    Date date = getDateFormat("yyyy-MM-dd").parse(str);
                    str = getDateFormat("yyyy-MM-dd").format(date);
                } catch (ParseException var6) {
                    str = "";
                }
            }

            return str != null && str.length() > 0 ? str : null;
        } else {
            return null;
        }
    }

    public static String replaceSpecialStringIntZero(String str) {
        if (str != null && NumberUtils.isNumber(str) && str.indexOf(".") != -1) {
            String[] split = str.split("\\.");

            try {
                char[] cs = split[1].toCharArray();

                label31:
                for(int x = cs.length - 1; x >= 0; --x) {
                    if (cs[x] != '0') {
                        split[0] = split[0] + ".";
                        int z = 0;

                        while(true) {
                            if (z > x) {
                                break label31;
                            }

                            split[0] = split[0] + cs[z];
                            ++z;
                        }
                    }
                }

                str = split[0];
            } catch (Exception var5) {
                str = split[0];
            }
        }

        return str;
    }

    public static Date jsonDate(Long jsonDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jsonDate.longValue());
        Date date = calendar.getTime();
        return date;
    }

    public static Date getDateFromLong(Long timeStamp) {
        if (timeStamp != null) {
            Long longTime = timeStamp.longValue() * 1000L;
            String effdt = ((DateFormat)simpleDateFormat.get()).format(longTime);
            Date parseDate = parseDate(effdt, dateTimeFormat);
            return parseDate;
        } else {
            return null;
        }
    }

    public static String dateLong(String timestamp) {
        if (!isEmpty(timestamp)) {
            Long longTime = Long.parseLong(timestamp) * 1000L;
            Date date = jsonDate(longTime);
            Date resultDate = getDayEndMonthFinalTime(date, 0);
            Long returnTimestamp = 0L;

            try {
                returnTimestamp = ((DateFormat)simpleDateFormat.get()).parse(format(resultDate)).getTime() / 1000L;
            } catch (ParseException var6) {
                var6.printStackTrace();
            }

            return returnTimestamp.toString();
        } else {
            return null;
        }
    }

    public static List<String> dateLongList(List<String> timestamp) {
        if (CollectionUtils.isEmpty(timestamp)) {
            return null;
        } else {
            List<String> listTimesTamp = new ArrayList();
            Iterator var2 = timestamp.iterator();

            while(var2.hasNext()) {
                String string = (String)var2.next();
                Long longTime = Long.parseLong(string) * 1000L;
                Date date = jsonDate(longTime);
                Date resultDate = getDayEndMonthFinalTime(date, 0);
                Long returnTimestamp = 0L;

                try {
                    returnTimestamp = ((DateFormat)simpleDateFormat.get()).parse(format(resultDate)).getTime() / 1000L;
                    listTimesTamp.add(returnTimestamp.toString());
                } catch (ParseException var9) {
                    var9.printStackTrace();
                }
            }

            return listTimesTamp;
        }
    }

    public static String getEffdtFromTimeStamp(String timeStamp) {
        if (!isEmpty(timeStamp)) {
            Long longTime = Long.parseLong(timeStamp) * 1000L;
            SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
            String effdt = format.format(longTime);
            return effdt;
        } else {
            return null;
        }
    }

    public static Integer getCurrentTimeBySecond() {
        return (int)(Calendar.getInstance().getTimeInMillis() / 1000L);
    }

    public static int getNowMonth() {
        Calendar c = Calendar.getInstance();
        int month = c.get(2) + 1;
        return month;
    }

    public static int getNowYear() {
        Calendar c = Calendar.getInstance();
        int month = c.get(1);
        return month;
    }

    public static int getDateMonth(Date date) {
        GregorianCalendar gc = (GregorianCalendar)Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }

    public static int getDateYear(Date date) {
        GregorianCalendar gc = (GregorianCalendar)Calendar.getInstance();
        gc.setTime(date);
        return gc.get(1);
    }

    /*public static boolean matchDateString(String string) {
        Pattern pattern = Pattern.compile("(\\d){4}-(\\d){2}-(\\d){2}");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }*/

    static {
        CAL.set(1, 1899);
        CAL.set(2, 11);
        CAL.set(5, 30);
        CAL.set(11, 0);
        CAL.set(12, 0);
        CAL.set(13, 0);
        CAL.set(14, 0);
        Class var0 = DateUtils.class;
        synchronized(DateUtils.class) {
            threadLocal = new ThreadLocal();
        }

        var0 = DateUtils.class;
        synchronized(DateUtils.class) {
            threadLocal = new ThreadLocal();
        }
    }
}
