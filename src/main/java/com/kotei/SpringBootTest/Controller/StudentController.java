package com.kotei.SpringBootTest.Controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotei.SpringBootTest.Entity.StudentEntity;
import com.kotei.SpringBootTest.Service.StudentService;

//告诉程序这是一个Controller层，处理前端的请求
@RestController
public class StudentController {
	//去SpringBoot容器找到在容器中已经初始化（new）的UserService对象
		@Autowired
		StudentService service;
		
		/**
		 * 查询某个学车信息
		 * @return
		 */
		//请求路径：（http://localhost:8080/hello）
		@RequestMapping("getStudentInfo")
		public String getStudentInfo() {
			service.getStudentById();
			return "成功查询一个学生信息";
		}
		/**
		 * 新增一个学生信息
		 * @return
		 */
		@RequestMapping("insertStudentInfo")
		public String insertStudentInfo() {
			service.insertStudent();
			return "成功新增一个学生信息";
		}
		/**
		 * 修改一个学生信息
		 * @return
		 */
		@RequestMapping("updateStudentInfo")
		public String updateStudentInfo() {
			service.updateStudent();
			return "成功修改一个学生信息";
		}
		/**
		 * 删除一个学生信息
		 * @return
		 */
		@RequestMapping("deleteStudentInfo")
		public String deleteStudentInfo() {
			service.deleteStudent();
			return "成功删除一个student信息";
		}
		
		/**
		 * 通过id删除一个学生信息
		 * @return
		 */
		@RequestMapping("deleteStudentInfoById")
		public String deleteStudentInfoById() {
			service.deleteStudentById(17);
			return "成功通过id删除一个学生信息";
		}
		
		/**
		 * 通过Entity删除一个学生信息
		 * @return
		 */
		@RequestMapping("deleteStudentInfoByEntity")
		public String deleteStudentInfoByEntity() {
			StudentEntity stu = new StudentEntity();
			stu.setSid(18);
			stu.setSname("孙悟空");
			stu.setSage(new Date(new java.util.Date().getTime()));
			stu.setSsex("男");
			service.deleteStudentByEntity(stu);
			return "成功通过Entity删除一个学生信息";
		}
}
