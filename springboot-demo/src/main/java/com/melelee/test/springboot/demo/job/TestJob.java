package com.melelee.test.springboot.demo.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

	@Autowired
	RestTemplate restTemplate;

	@Scheduled(cron = "${cronExpression}")
	public void doSomeThing() throws Exception {
		log.info("定时任务执行：{}", new Date());
		//经度
		String longitude = "117.233441";
		//纬度
		String latitude = "31.827797";
		String msg = restTemplate.getForObject(
				"http://api.map.baidu.com/geocoder/v2/" +
						"?callback=renderReverse" +
						"&location=" + latitude + "," + longitude +
						"&output=json" +
						"&pois=1" +
						"&ak=xp6KyzCSoMq24YX6YDN6osck6WBTa9hO", String.class);
		msg = msg.replace("renderReverse&&renderReverse(", "");
		log.info("经度：{}，纬度：{}的地理信息：{}", longitude, latitude, msg);
	}
}
