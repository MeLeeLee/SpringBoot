package com.melelee.test.springboot.demo.configuration;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 测试
 *
 * @author mengll
 * @create 2018-04-16 15:37
 **/

@Slf4j
public class MyFilter implements Filter {
	@Override
	public void destroy() {
		log.info("destroy....");
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		log.info("this is MyFilter,url :"+request.getRequestURI());
		filterChain.doFilter(srequest, sresponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("init...");
	}
}
