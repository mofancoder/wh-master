package com.mofan.enums;

/**
 *     返回前端枚举定义
 * @author Administrator
 *
 */
public enum ResponseConstant implements BaseConstant<String>{
	
	SUCCESS("200","调用成功"),
	FAIL("500","调用失败");
	
	private String code;
	
	private String description;
	
	private  ResponseConstant(String code,String description) {
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
		for(ResponseConstant constant :ResponseConstant.values()) {
			if(constant.getCode().equals(code)) {
				return constant.getDescription();
			}
		}
		return null;
	}
}
