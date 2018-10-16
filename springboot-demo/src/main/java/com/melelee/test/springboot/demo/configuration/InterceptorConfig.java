package com.melelee.test.springboot.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * InterceptorConfig
 *
 * @author mengll
 * @create 2018-07-30 15:17
 **/
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/getAuthor").addPathPatterns("/qwe");
		super.addInterceptors(registry);
	}
}
