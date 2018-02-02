package com.example.demo.controller;

import com.example.demo.DTO.User;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author mengll
 * @create 2018-02-02 14:57
 **/
@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") int id){
        return testService.getUser(id);
    }
    @RequestMapping("/insert")
    public int getUser(@RequestBody User user){
        return testService.saveUser(user);
    }

}
