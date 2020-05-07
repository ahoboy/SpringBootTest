package com.kotei.SpringBootTest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kotei.SpringBootTest.Service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

//告诉程序这是一个Controller层，处理前端的请求
@RestController
public class HelloController {

	//去SpringBoot容器找到在容器中已经初始化（new）的UserService对象
	@Autowired
	UserService service;
	
	//请求路径：（http://localhost:8080/test）
	@RequestMapping(value="test", method=RequestMethod.POST)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", paramType = "query", required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "name", paramType = "query", required = true, dataType = "String")
	})
	public String hello(int id, String name) {
		System.out.println("Controller 接收Web请求参数，参数值：" + id + "----name的值：" + name);
		return "User Service Test OK! [陶长周]";
	}
}
