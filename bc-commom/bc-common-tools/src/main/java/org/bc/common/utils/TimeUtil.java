package org.bc.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jalon
 * @create 20170808 - 17:55
 * @package com.ikang.enterprise.core.utils
 */
public class TimeUtil {
	private static final Log LOGGER = LogFactory.getLog(TimeUtil.class);
	public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String SHORT_DATE_FORMAT_NO_DASH = "yyyyMMdd";
	public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String SIMPLE_DATE_FORMAT_NO_DASH = "yyyyMMddHHmmss";

	public static Timestamp timestamp(String str) {
		DateFormat format = new SimpleDateFormat(SHORT_DATE_FORMAT);
		Timestamp timestamp = null;
		try {
			timestamp = new Timestamp(format.parse(str).getTime());
		} catch (ParseException e) {
			LOGGER.error("TimeUtil.timestamp ParseException error with param str:" + str, e);
		}
		return timestamp;
	}

	public static Timestamp timestamp(String str, String pattern) {
		if (StringUtils.isEmpty(pattern)) {
			pattern = SIMPLE_DATE_FORMAT;
		}
		DateFormat format = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
		Timestamp timestamp = null;
		try {
			timestamp = new Timestamp(format.parse(str).getTime());
		} catch (ParseException e) {
			LOGGER.error("TimeUtil.timestamp ParseException error with param str:" + str, e);
		}
		return timestamp;
	}

	/**
	 * 将date类型转化成标准的String类型
	 * @param date
	 * @return
	 */
	public static String dateToStringhms(Date date) {
		return (new SimpleDateFormat(SIMPLE_DATE_FORMAT)).format(date);
	}

	/**
	 * 将date类型转化成标准的String类型
	 * @param date
	 * @return
	 */
	public static String dateToStringymd(Date date) {
		return (new SimpleDateFormat(SHORT_DATE_FORMAT)).format(date);
	}

	/**
	 * 将string类型转化成date
	 * @param dateString
	 * @return
	 */
	public static Date stringToDateymd(String dateString) {
		Date date = null;
		try {
			date = (new SimpleDateFormat(SHORT_DATE_FORMAT)).parse(dateString);
		} catch (ParseException e) {
			LOGGER.error("TimeUtil.stringToDateymd ParseException error with param dateString:" + dateString, e);
		}
		return date;
	}
	public static Date stringToDateSimple(String dateString) {
		Date date = null;
		try {
			date = (new SimpleDateFormat(SIMPLE_DATE_FORMAT)).parse(dateString);
		} catch (ParseException e) {
			LOGGER.error("TimeUtil.stringToDateymd ParseException error with param dateString:" + dateString, e);
		}
		return date;
	}
	public static Date stringToDate(String dateString) {
		Date date = null;
		try {
			date = (new SimpleDateFormat(SHORT_DATE_FORMAT)).parse(dateString);
		} catch (ParseException e) {
			LOGGER.error("TimeUtil.stringToDateymd ParseException error with param dateString:" + dateString, e);
		}
		return date;
	}

	/**
	 * 返回days天之后的时间戳
	 * @param days
	 * @return
	 */
	public static String getTimestampAfterDays(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DAY_OF_YEAR, days);
		return (new SimpleDateFormat(SHORT_DATE_FORMAT)).format(calendar.getTime());
	}

	/**
	 * timestampToStr
	 * @param timestamp
	 * @return
	 */
	public static String timestampToStr(Timestamp timestamp) {
		return (new SimpleDateFormat(SHORT_DATE_FORMAT)).format(timestamp);
	}

	public static String timeMillisToStr(long time) {
		Timestamp ts = new Timestamp(time);
		DateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
		return sdf.format(ts);
	}
}
