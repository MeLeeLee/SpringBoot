package com.example.demo.job;

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
public class TestJob {
    @Scheduled(cron = "${cronExpression}")
    public void doSomeThing() {
        System.out.println(new Date());
    }
}
