package org.bc.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bc.common.vo.Constant;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : R&M www.rmworking.com/blog Date: 2017/8/7 Time: 17:34 ikang-enterprise-platform
 *         com.ikang.enterprise.core.utils
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {
	private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);
	public static final String SALT = "enterprise";
	/**
	 * 加密数据的 iv
	 */
	public static String DATA_IV = "ikangsaas#$%^&*(";

	/**
	 * MD5加密
	 * @param txt
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encoderByMd5(String txt) {
		return md5(txt, SALT);
	}

	public static String md5(String str, String salt) {
		return new Md5Hash(str, salt).toString();
	}

	public static String encodeMD5(String txt) {
		if (Objects.isNull(txt)) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(txt.getBytes());
			StringBuffer buf = new StringBuffer();
			for (byte b : md.digest()) {
				buf.append(String.format("%02x", b & 0xff));
			}
			return buf.toString();
		} catch (Exception e) {
			logger.error("encode {} failure,", txt);
		}
		return null;
	}

	/**
	 * Aes加密
	 * @param key
	 * @param content
	 * @return
	 */
	public static String encoderByAes(String key, String content) {
		try {
			// 两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
			Key keySpec = new SecretKeySpec(key.getBytes(), "AES");
			// 初始化向量参数，AES 为16bytes. DES 为8bytes.
			IvParameterSpec ivSpec = new IvParameterSpec(DATA_IV.getBytes());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
			byte[] byteResult = cipher.doFinal(content.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteResult.length; i++) {
				String hex = Integer.toHexString(byteResult[i] & 0xFF);
				if (hex.length() == 1) {
					hex = '0' + hex;
				}
				sb.append(hex.toUpperCase());
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断对象是否为空 User:T.L Description:
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String && Objects.equals(String.valueOf(obj).trim(), "")) {
			return true;
		} else if (obj instanceof Boolean && !((Boolean) obj)) {
			return true;
		} else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
			return true;
		} else if (obj instanceof Map && ((Map) obj).isEmpty()) {
			return true;
		} else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 多个参数包含空值
	 * @param objs
	 * @return
	 */
	public static boolean hasEmpty(Object... objs) {
		if (objs == null) {
			return true;
		} else {
			for (Object obj : objs) {
				if (isEmpty(obj)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 字符集定义.
	 */
	/**
	 * format string pattern. ex: StringUtils.format("a:{0}, b:{1}", "v1", "v3");
	 * @param format
	 * @param args
	 * @return
	 */
	public static String format(String format, Object... args) {
		return MessageFormat.format(format, args);
	}

	public static String lowerFirst(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0, 1).toLowerCase() + str.substring(1);
		}
	}

	public static String upperFirst(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)) {
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 缩略字符串（不区分中英文字符）.
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			logger.error("abbr UnsupportedEncodingException error", e);
		}
		return "";
	}

	/**
	 * 缩略字符串（替换html）.
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String rabbr(String str, int length) {
		return abbr(replaceHtml(str), length);
	}

	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Unescapes a string containing entity escapes to a string containing the actual Unicode
	 * characters corresponding to the escapes. Supports HTML 4.0 entities.
	 * </p>
	 * <p>
	 * For example, the string "&amp;lt;Fran&amp;ccedil;ais&amp;gt;" will become
	 * "&lt;Fran&ccedil;ais&gt;"
	 * </p>
	 * <p>
	 * If an entity is unrecognized, it is left alone, and inserted verbatim into the result string.
	 * e.g. "&amp;gt;&amp;zzzz;x" will become "&gt;&amp;zzzz;x".
	 * </p>
	 * @param input the <code>String</code> to unescape, may be null
	 * @return a new unescaped <code>String</code>, <code>null</code> if null string input
	 */
	public static String escapeHtml(String input) {
		return StringEscapeUtils.escapeHtml(input);
	}

	/**
	 * <p>
	 * Escapes the characters in a <code>String</code> using JavaScript String rules.
	 * </p>
	 * <p>
	 * Escapes any values it finds into their JavaScript String form. Deals correctly with quotes
	 * and control-chars (tab, backslash, cr, ff, etc.)
	 * </p>
	 * <p>
	 * So a tab becomes the characters <code>'\\'</code> and <code>'t'</code>.
	 * </p>
	 * <p>
	 * The only difference between Java strings and JavaScript strings is that in JavaScript, a
	 * single quote must be escaped.
	 * </p>
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * input string: He didn't say, "Stop!"
	 * output string: He didn\'t say, \"Stop!\"
	 * </pre>
	 * </p>
	 * @param input String to escape values in, may be null
	 * @return String with escaped values, <code>null</code> if null string input
	 */
	public static String escapeJavaScript(String input) {
		return StringEscapeUtils.escapeJavaScript(input);
	}

	/**
	 * <p>
	 * Escapes the characters in a <code>String</code> to be suitable to pass to an SQL query.
	 * </p>
	 * <p>
	 * For example,
	 * 
	 * <pre>
	 * statement
	 * 		.executeQuery(&quot;SELECT * FROM MOVIES WHERE TITLE='&quot; + StringEscapeUtils.escapeSql(&quot;McHale's Navy&quot;) + &quot;'&quot;);
	 * </pre>
	 * </p>
	 * <p>
	 * At present, this method only turns single-quotes into doubled single-quotes (
	 * <code>"McHale's Navy"</code> => <code>"McHale''s Navy"</code>). It does not handle the cases
	 * of percent (%) or underscore (_) for use in LIKE clauses.
	 * </p>
	 * see http://www.jguru.com/faq/view.jsp?EID=8881
	 * @param str the string to escape, may be null
	 * @return a new String, escaped for SQL, <code>null</code> if null string input
	 */
	public static String escapeSql(String str) {
		if (str == null) {
			return null;
		}
		return StringUtils.replace(str, "'", "''");
	}

	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val) {
		if (val == null) {
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val) {
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val) {
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val) {
		return toLong(val).intValue();
	}

	/**
	 * 权限表达式拼接
	 * @param values
	 * @return
	 */
	public static String concat(Integer... values) {
		String result = "";
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				Integer value=values[i];
				if (!isEmpty(value)&& !value.equals(0)) {
					result += value + "/";
				}
			}
		}
		return result;
	}
}
