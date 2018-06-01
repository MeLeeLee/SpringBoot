package com.melelee.springboot.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 测试
 *
 * @author mengll
 * @create 2018-02-06 15:54
 **/
@Component
@Slf4j
public class TestJob {
	@Scheduled(cron = "${cronExpression}")
	public void doSomeThing() {
		log.info("定时任务执行：{}", new Date());
	}
}
