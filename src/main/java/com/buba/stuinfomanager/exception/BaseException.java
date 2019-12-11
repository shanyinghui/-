package com.buba.stuinfomanager.exception;
/**
 * 	如果抛出此异常，系统会以json格式向前台返回异常信息
 * @author 单迎辉
 * @date 2019年10月10日 上午10:06:40
 */
public class BaseException extends Exception{
	private String msg;
    private int code = 500;
    
    public BaseException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public BaseException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public BaseException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public BaseException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
