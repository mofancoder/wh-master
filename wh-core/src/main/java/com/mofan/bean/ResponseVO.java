package com.mofan.bean;


import com.mofan.enums.ApiResponseConstant;

import java.util.LinkedHashMap;

/**
 * mvc 返回对象
 * @author Administrator
 *
 */
public class ResponseVO extends LinkedHashMap<String,Object>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8899451318647210797L;

	public ResponseVO() {
		this.setResponseCode(ApiResponseConstant.SUCCESS.getCode());
		this.setResponseMessage(ApiResponseConstant.SUCCESS.getDescription());
	}
	
	public ResponseVO(String responseCode, Object responseMessage) {
		this.setResponseCode(responseCode);
		this.setResponseMessage(responseMessage);
	}
	
	public Object getResponseCode() {
		return this.get("responseCode");
	}

	public void setResponseCode(String responseCode) {
		this.put("responseCode", responseCode);
	}

	public Object getResponseMessage() {
		return this.get("responseMessage");
	}

	public void setResponseMessage(Object responseMessage) {
		this.put("responseMessage", responseMessage);
	}
	
	public Object getResponseData(){return  this.get("responseData");}

	public void setResponseData(Object responseData) {
		this.put("responseData", responseData);
	}
	
}
