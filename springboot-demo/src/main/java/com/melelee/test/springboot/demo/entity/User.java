package com.melelee.test.springboot.demo.entity;

import lombok.Data;

@Data
public class User {
	private Long id;

	private String email;

	private String nickName;

	private String passWord;

	private String regTime;

	private String userName;
}