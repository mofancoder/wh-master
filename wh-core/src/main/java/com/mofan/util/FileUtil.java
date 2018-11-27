package com.mofan.util;

import com.mofan.enums.FilePathConstant;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName:  FileUtil   
 * @Description:文件相关工具类   
 * @author:  MOFAN889
 * @date:   2018年11月21日 上午8:55:17   
 *
 */
public class FileUtil {
	
	private FileUtil() {};
	
	/**
	 * 
	 * @Title: getFileSuffix   
	 * @Description: 获取文件后缀   
	 * @param: @param fileName
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getFileSuffix(String fileName) {
		if(StringUtils.isNotBlank(fileName)) {
			fileName = fileName.substring(fileName.lastIndexOf("."));
		}else {
			
		}
		return fileName;
	}

	public static FilePathConstant getFileType(String fileSuffix) {
		if(StringUtils.isNotBlank(fileSuffix)) {
			if(fileSuffix.equals("jpg")||fileSuffix.equals("img")||fileSuffix.equals("png")) {
				return FilePathConstant.IMAGE;
			}else if(fileSuffix.equals("mp3")||fileSuffix.equals("wmv")) {
				return FilePathConstant.IMAGE;
			}else {
				return FilePathConstant.OTHER;
			}
		}
		return FilePathConstant.OTHER;
	}

	public static String generateFilePath(String rootPath, String minorRootPath) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(new Date());
		String[] split = format.split("-");
		return rootPath+File.separator+minorRootPath+File.separator+String.join(File.separator, split);
	}
	
}
