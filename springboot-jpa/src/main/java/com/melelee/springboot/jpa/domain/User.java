package com.melelee.springboot.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * test
 *
 * @author mengll
 * @create 2018-04-16 15:56
 **/
@Entity
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, unique = true)
	private String userName;
	@Column
	private String passWord;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String nickName;
	@Column(nullable = false)
	private String regTime;
}
