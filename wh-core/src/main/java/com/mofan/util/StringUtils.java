package com.mofan.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
	/**
	 * 
	 * @Title: getRandomStr   
	 * @Description: 获取随机字符串   
	 * @param: @param count
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getRandomStr(int count) {
		char[] codeSeq = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
				'R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
		SecureRandom random = null;
		try {
			 random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder();
		for(int i = 0;i<count;i++) {
			builder.append(codeSeq[random.nextInt(codeSeq.length)]);
		}

		return builder.toString();
	}
	
	
	
}
