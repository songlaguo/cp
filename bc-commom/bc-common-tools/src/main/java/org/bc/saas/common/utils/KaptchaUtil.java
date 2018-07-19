package org.bc.saas.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * User: R&M www.rmworking.com/blog Date: 2017/9/1 Time: 10:45 ikang-enterprise-platform
 * com.ikang.enterprise.core.utils
 */
public class KaptchaUtil {
	private static final Logger logger = LoggerFactory.getLogger(KaptchaUtil.class);

	/**
	 * 功能说明:
	 * @return String[] 长度为2的数组 0：验证码图片的base64编码 1：验证码的文本字符
	 * @time:2016年3月3日下午8:31:23
	 * @author:linghushaoxia
	 * @exception:
	 */
	public static String geneValidateCode(BufferedImage bi) {
		// 生成的验证码结果
		String result = null;
		ImageIO.setUseCache(false);
		StringBuffer imageBuffer = new StringBuffer();
		// write the data out
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			// // 保存图片
			ImageIO.write(bi, "jpg", out);
			// // 对图片进行base64编码，可以在浏览器中直接显示，可作为图片标签使用
			byte[] data = out.toByteArray();
			imageBuffer.append(new BASE64Encoder().encode(data));
		} catch (IOException e) {
			logger.error("生成验证码出现异常:" + e.getMessage());
		}
		if (imageBuffer.length() > 0) {
			// 将字符拼接在前面和append方法相反
			imageBuffer.insert(0, "data:image/jpeg;base64,");
			result = imageBuffer.toString();
		}
		return result;
	}
}
