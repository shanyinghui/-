package com.buba.stuinfomanager.util;

import java.io.Serializable;
/**
 * 	返回结果工具类
 * @author 单迎辉
 * @date 2019年10月10日 上午8:41:18
 */
public class ResultUtil implements Serializable {
	private Integer code;
	private String msg="";
	private Long count=0L;
	private Object data;
	
	public ResultUtil() {
		super();
	}

	public ResultUtil(Integer code) {
		super();
		this.code = code;
	}

	public ResultUtil(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public ResultUtil(Integer code, String msg, Long count, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ResultUtil ok(){
		return new ResultUtil(0);
	}
	
	public static ResultUtil ok(Object list){
		ResultUtil result = new ResultUtil();
		result.setCode(0);
		result.setData(list);;
		return result;
	}
	public static ResultUtil ok(String msg){
		ResultUtil result = new ResultUtil();
		result.setCode(0);
		result.setMsg(msg);
		return result;
	}
	
	public static ResultUtil error(){

		return new ResultUtil(500,"系统出现故障，请稍后再试！");
	}
	public static ResultUtil error(String str){

		return new ResultUtil(500,str);
	}
}
