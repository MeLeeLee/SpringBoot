package com.melelee.test.springboot.demo.controller;

import com.melelee.test.springboot.demo.configuration.Author;
import com.melelee.test.springboot.demo.entity.User;
import com.melelee.test.springboot.demo.service.TestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 测试
 *
 * @author mengll
 * @create 2018-02-02 14:57
 **/
@RestController
public class TestController {
	@Autowired
	private TestService testService;

	@Autowired
	Author author;

	@RequestMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") int id) {
		return testService.getUser(id);
	}

	@RequestMapping("/insert")
	public int getUser(@RequestBody User user) {
		user.setRegTime(new Date().toString());
		return testService.saveUser(user);
	}

	@RequestMapping("/getAuthor")
	public Author getAuthor() {
		Author returnAuthor = new Author();
		BeanUtils.copyProperties(author,returnAuthor);
		return returnAuthor;
	}

}
