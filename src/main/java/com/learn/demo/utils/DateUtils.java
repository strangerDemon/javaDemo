package com.learn.demo.utils;

import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * 时间工具类.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/10/9 10:38
 */
@Component
public class DateUtils {

  /**
   * 当前时间加上 指定年.
   */
  public Date addYear(int year) {
    return addYear(null, year);
  }

  /**
   * 指定时间加上 指定年.
   */
  public Date addYear(Date date, int year) {
    Calendar ca = Calendar.getInstance();
    if (date != null) {
      ca.setTime(date);
    }
    ca.add(Calendar.YEAR, year);
    return ca.getTime();
  }

  /**
   * 当前时间加上 指定月.
   */
  public Date addMonth(int month) {
    return addMonth(null, month);
  }

  /**
   * 当前时间加上 指定月.
   */
  public Date addMonth(Date date, int month) {
    Calendar ca = Calendar.getInstance();
    if (date != null) {
      ca.setTime(date);
    }
    ca.add(Calendar.MONTH, month);
    return ca.getTime();
  }

  /**
   * 当前时间加上 指定天.
   */
  public Date addDay(int day) {
    return addDay(null, day);
  }

  /**
   * 当前时间加上 指定天.
   */
  public Date addDay(Date date, int day) {
    Calendar ca = Calendar.getInstance();
    if (date != null) {
      ca.setTime(date);
    }
    ca.add(Calendar.DATE, day);
    return ca.getTime();
  }

  /**
   * 当前时间加上 指定分钟.
   */
  public Date addMinute(int minute) {
    return addMinute(null, minute);
  }

  /**
   * 当前时间加上 指定分钟.
   */
  public Date addMinute(Date date, int minute) {
    Calendar ca = Calendar.getInstance();
    if (date != null) {
      ca.setTime(date);
    }
    ca.add(Calendar.MINUTE, minute);
    return ca.getTime();
  }

  /**
   * 当前时间加上 指定秒.
   */
  public Date addSecond(int second) {
    return addSecond(null, second);
  }

  /**
   * 当前时间加上 指定秒.
   */
  public Date addSecond(Date date, int second) {
    Calendar ca = Calendar.getInstance();
    if (date != null) {
      ca.setTime(date);
    }
    ca.add(Calendar.SECOND, second);
    return ca.getTime();
  }
}
