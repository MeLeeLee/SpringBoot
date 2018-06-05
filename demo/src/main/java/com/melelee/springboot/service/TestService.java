package com.melelee.springboot.service;

import com.melelee.springboot.bean.UserMapper;
import com.melelee.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试
 *
 * @author mengll
 * @create 2018-02-02 15:00
 **/
@Service
public class TestService {
	@Autowired
	private UserMapper userMapper;

	public User getUser(long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public int saveUser(User user) {
		int count = userMapper.insert(user);
		return count / 0;
	}

}
