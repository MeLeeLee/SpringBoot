package com.melelee.test.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 *
 * @author mengll
 * @create 2018-07-11 15:56
 **/
@Slf4j
@ControllerAdvice
public class TestControllerAdvice {
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Object handleException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Exception e) {
		log.error("异常：",e);
		return e;
	}
}
