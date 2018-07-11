package com.melelee.test.springboot.demo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 开发者信息
 *
 * @author mengll
 * @create 2018-07-11 11:09
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "author")
@PropertySource(value = "classpath:config.properties")
public class Author {
	private String name;
	private int age;
	private String phone;
	private String email;
}
