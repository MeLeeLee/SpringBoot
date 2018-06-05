package com.melelee.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.melelee.springboot.domain.User;
import com.melelee.springboot.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 测试
 *
 * @author mengll
 * @create 2018 -04-16 15:17
 */
@RestController
public class RestfulController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Index string.
	 *
	 * @return the string
	 */
	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}

	/**
	 * Save user string.
	 *
	 * @param user the user
	 * @return the string
	 */
	@RequestMapping(value = "/users",method = RequestMethod.POST)
	public long saveUser(@RequestBody User user) {
		user.setRegTime(new Date().toString());
		user = userRepository.save(user);
		return user.getId();
	}

	/**
	 * Gets value.
	 *
	 * @param id the id
	 * @return the value
	 */
	@RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
	public String getValue(@PathVariable long id) {
		User user = userRepository.getOne(id);
		return JSON.toJSONString(user);
	}

	/**
	 * Delete user string.
	 *
	 * @param id the id
	 * @return the string
	 */
	@RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable long id) {
		userRepository.delete(id);
	}
}

