package com.mofan.exection;

import java.io.Serializable;

/**
 * 
 * @ClassName:  SystemException   
 * @Description:系统异常
 * @author:  MOFAN889
 * @date:   2018年11月21日 上午9:01:12   
 *
 */
public class SystemException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 2487272478582545024L;

	private String code;

	private String[] extra;
	
	public SystemException(String code) {
		super(code);
		this.code = code;
	}
	
	public SystemException(Throwable cause) {
		super(cause);
	}

	public SystemException(String code, String... extra) {
		super(code);
		this.code = code;
		this.extra = extra;
	}

	public SystemException(String code, Throwable cause) {
		super(code, cause);
		this.code = code;
	}

	public SystemException(String code, Throwable cause, String... extra) {
		super(code, cause);
		this.code = code;
		this.extra = extra;
	}

	public String getCode() {
		return code;
	}

	public String[] getExtra() {
		return extra;
	}
	
	
}
