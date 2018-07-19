package org.bc.saas.common.utils;

/**
 * @author Jalon
 * @create 20180118 - 下午12:13
 * @package com.ikang.enterprise.core.utils
 */
public class MaskUtils {
	/**
	 * 对手机号码做掩码
	 * @param v
	 * @return
	 */
	public static String maskPhoneNumber(String v) {
		if (!StringUtils.isEmpty(v)) {
			int length = v.length();
			if (length > 7) {
				String prefix = v.substring(0, 3);
				String endfix = v.substring(length - 4);
				v = prefix + StringUtils.repeat("*", length - 7) + endfix;
			}
		}
		return v;
	}

	/**
	 * 对证件号码做掩码
	 * @param v
	 * @return
	 */
	public static String maskCertId(String v) {
		if (!StringUtils.isEmpty(v)) {
			int length = v.length();
			if (length > 6) {
				String prefix = v.substring(0, 2);
				String endfix = v.substring(length - 4);
				v = prefix + StringUtils.repeat("*", length - 6) + endfix;
			}
		}
		return v;
	}
}
