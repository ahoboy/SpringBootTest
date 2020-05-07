package com.kotei.SpringBootTest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {
	
	@RequestMapping("/jspTest")
	public String jspTest(Model model) {
		model.addAttribute("info","这是李立杭JSP测试页面");//设置属性的值
		return "test";
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/login")
		public String login(Model model) {
			System.out.println("准备进入登录页面");
			return "login";
		}
}