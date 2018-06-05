package com.melelee.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试
 *
 * @author mengll
 * @create 2018-02-02 14:57
 **/
@Controller
public class SpringSecurityController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/security")
	public String security() {
		return "security";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
