package com.melelee.test.springboot.jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * test
 *
 * @author mengll
 * @create 2018-04-16 15:58
 **/
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);

	User findByUserNameOrEmail(String username, String email);
}