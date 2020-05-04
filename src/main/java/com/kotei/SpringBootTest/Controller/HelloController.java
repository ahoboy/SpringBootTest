package com.kotei.SpringBootTest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotei.SpringBootTest.Service.UserService;

//告诉程序这是一个Controller层，处理前端的请求
@RestController
public class HelloController {

	//去SpringBoot容器找到在容器中已经初始化（new）的UserService对象
	@Autowired
	UserService service;
	
	//请求路径：（http://localhost:8080/hello）
	@RequestMapping("test")
	public String hello() {
		System.out.println("Controller");
		service.getUserInfo();
		return "User Service Test OK! [陶长周]";
	}
}
