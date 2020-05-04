package com.kotei.SpringBootTest.Service;

import org.springframework.stereotype.Service;

//告诉SpringBoot,这是一个Service组件（对象）
@Service
public class UserService {
	
	public void getUserInfo() {
		System.out.println("我是Terry");
	}
}
