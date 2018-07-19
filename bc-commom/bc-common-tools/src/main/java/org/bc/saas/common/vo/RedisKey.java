package org.bc.saas.common.vo;

/**
 * @author : R&M www.rmworking.com/blog 2017/10/23 10:41 ikang-enterprise-platform
 *         com.ikang.enterprise.core.model
 */
public enum RedisKey {
	/**
	 * redis_key
	 */
	SMS_CODE("ikangServiceSmsCode", "短信验证码"), IMG_CODE("ikangServiceImgCode", "图形验证码"),
	LOG_CODE("ikangServiceLogCode", "埋点日志记录"), BOOKING_ORDER("bookingOrderCode", "预约订单数据");
	public final String key;

	RedisKey(String key, String text) {
		this.key = key;
	}
}
