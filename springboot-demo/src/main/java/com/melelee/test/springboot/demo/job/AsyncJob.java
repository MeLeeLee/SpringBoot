package com.melelee.test.springboot.demo.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 测试
 *
 * @author mengll
 * @create 2018-02-06 15:54
 **/
@Component
public class AsyncJob {
	@Async
	public void job1(){
		System.out.println("job1");
	}
	@Async
	public void job2(){
		System.out.println("job2");
	}
	@Async
	public void job3(){
		System.out.println("job3");
	}
}
