package com.mofan.enums;

/**
 *     返回前端枚举定义
 * @author Administrator
 *
 */
public enum FilePathConstant implements BaseConstant<String>{
	
	IMAGE("1","image"),
	VIDEO("2","video"),
	TMP("3","tmp"),
	DOCUMENT("4","tmp"),
	OTHER("4","other");
	
	private String code;
	
	private String description;
	
	private  FilePathConstant(String code,String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static String getName(String code) {
		for(FilePathConstant constant :FilePathConstant.values()) {
			if(constant.getCode().equals(code)) {
				return constant.getDescription();
			}
		}
		return null;
	}
}
