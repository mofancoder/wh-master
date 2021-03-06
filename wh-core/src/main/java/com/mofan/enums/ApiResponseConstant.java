package com.mofan.enums;

/**
 * 
 * @ClassName:  ApiResponseConstant
 * @Description:系统异常枚举   
 * @author:  MOFAN889
 * @date:   2018年11月21日 上午9:02:16   
 *
 */
public enum ApiResponseConstant implements BaseConstant<String>{
	
	SUCCESS("200","调用成功"),
	FAIL("500","调用失败");
	
	private String code;
	
	private String description;
	
	private ApiResponseConstant(String code, String description) {
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
		for(ApiResponseConstant constant : ApiResponseConstant.values()) {
			if(constant.getCode().equals(code)) {
				return constant.getDescription();
			}
		}
		return null;
	}
}
