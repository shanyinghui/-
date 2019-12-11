package com.buba.stuinfomanager.exception;

import com.buba.stuinfomanager.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


/**
 * 	异常处理器
 * @author 单迎辉
 * @date 2019年10月10日 上午11:20:40
 */
@RestController
@ControllerAdvice
public class BaseExceptionHandler {
	private final static Logger logger = LoggerFactory.getLogger(BaseException.class);
	
	/**
	 * 自定义异常
	 */
	@ExceptionHandler(BaseException.class)
	public ResultUtil handleCustomException(BaseException e){
		logger.error(e.getMsg(),e);
		ResultUtil r = new ResultUtil();
		r.setCode(e.getCode());
		r.setMsg(e.getMessage());
		return r;
	}

	@ExceptionHandler(Exception.class)
	public ResultUtil handleException(Exception e){
		logger.error(e.getMessage(), e);
		return ResultUtil.error();
	}
}
