package com.zero.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * 日期类
 * @author Zero-me
 *
 */
public class DateUtils {
	public static String formatDate(Date date, String formatStr)
	  {
	    if (StringUtils.isEmpty(formatStr)) {
	      formatStr = "yyyy-MM-dd HH:mm:ss";
	    }
	    DateFormat dateTimeformat = new SimpleDateFormat(formatStr);
	    return dateTimeformat.format(date);
	  }
	  
	  public static Date parseDate(String str, String parseStr)
	  {
	    if (StringUtils.isEmpty(parseStr)) {
	      parseStr = "yyyy-MM-dd HH:mm:ss";
	    }
	    str = str.replace("Z", " UTC");
	    DateFormat dateTimeformat = new SimpleDateFormat(parseStr);
	    try
	    {
	      return dateTimeformat.parse(str);
	    }
	    catch (ParseException e)
	    {
	      e.printStackTrace();
	    }
	    return null;
	  }
	  
	  public static Date getMonthFirstDay(int month)
	  {
	    Calendar calendar1 = Calendar.getInstance();
	    calendar1.add(2, month);
	    calendar1.set(5, 1);
	    calendar1.set(11, 0);
	    calendar1.set(12, 0);
	    calendar1.set(13, 0);
	    return calendar1.getTime();
	  }
	  
	  public static Date getMonthLastDay(int month)
	  {
	    Calendar calendar = Calendar.getInstance();
	    calendar.add(2, month + 1);
	    calendar.set(5, 0);
	    calendar.set(11, 23);
	    calendar.set(12, 59);
	    calendar.set(13, 59);
	    return calendar.getTime();
	  }
	  
	  public static Date getToDayZero()
	  {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    calendar.set(11, 0);
	    calendar.set(12, 0);
	    calendar.set(13, 0);
	    return calendar.getTime();
	  }
	  
	  public static void main(String[] args)
	  {
	    Date date1 = getMonthFirstDay(0);
	    System.out.println(formatDate(date1, null));
	    Date date2 = getMonthLastDay(0);
	    System.out.println(formatDate(date2, null));
	    System.out.println();
	  }
}
