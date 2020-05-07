package com.kotei.SpringBootTest.Controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kotei.SpringBootTest.Entity.StudentEntity;
import com.kotei.SpringBootTest.Service.StudentService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

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
		@RequestMapping(value="getStudentInfoById", method=RequestMethod.GET)
		public String getStudentInfoById(int id) {
			service.getStudentById(id);
			return "成功查询一个学生信息";
		}
		/**
		 * 新增一个学生信息
		 * @return
		 */
		@RequestMapping(value="insertStudentInfo", method=RequestMethod.GET)
		public String insertStudentInfo() {
			service.insertStudent();
			return "成功新增一个学生信息";
		}
		/**
		 * 修改一个学生信息
		 * @return
		 */
		@RequestMapping(value="updateStudentInfo", method=RequestMethod.GET)
		public String updateStudentInfo() {
			service.updateStudent();
			return "成功修改一个学生信息";
		}
		/**
		 * 删除一个学生信息
		 * @return
		 */
		@RequestMapping(value="deleteStudentInfo", method=RequestMethod.GET)
		public String deleteStudentInfo() {
			service.deleteStudent();
			return "成功删除一条学生信息";
		}
		
		/**
		 * 通过id删除一个学生信息
		 * @return
		 */
		@RequestMapping(value="deleteStudentInfoById", method=RequestMethod.GET)
		public String deleteStudentInfoById(int id) {
			service.deleteStudentById(id);
			return "成功通过Id删除一个学生信息";
		}
		
		/**
		 * 通过Entity删除一个学生信息
		 * @return
		 */
		@RequestMapping(value="deleteStudentInfoByEntity", method=RequestMethod.GET)
		public String deleteStudentInfoByEntity() {
			StudentEntity stu = new StudentEntity();
			stu.setSid(23);
			stu.setSname("");
			stu.setSage(new Date(new java.util.Date().getTime()));
			stu.setSsex("男");
			service.deleteStudentByEntity(stu);
			return "成功通过实体删除一个学生信息";
		}
		
		@RequestMapping(value="insertStudentP", method=RequestMethod.POST)
		@ApiImplicitParams({
			@ApiImplicitParam(name = "name", paramType = "query", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "age", paramType = "query", required = true, dataType = "Date"),
			@ApiImplicitParam(name = "sex", paramType = "query", required = true, dataType = "String")
		})
		public String insertStudentInfoP(String name, Date age, String sex) {
			StudentEntity stu = new StudentEntity(0,name, age, sex);
			service.insertStudent(stu);
			return "成功新增一个学生信息\n" + stu;
		}
		
		@RequestMapping(value="updateStudentP", method=RequestMethod.POST)
		@ApiImplicitParams({
			@ApiImplicitParam(name = "id", paramType = "query", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "name", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "age", paramType = "query", required = true, dataType = "Date"),
			@ApiImplicitParam(name = "sex", paramType = "query", required = true, dataType = "String")
		})
		public String updateStudentInfoP(int id, String name, Date age, String sex) {
			StudentEntity stu = new StudentEntity(id,name, age, sex);
			service.updateStudentP(stu);
			return "成功修改一个学生信息\n" + stu;
		}
		
		@RequestMapping(value="deleteStudentP", method=RequestMethod.POST)
		@ApiImplicitParams({
			@ApiImplicitParam(name = "id", paramType = "query", required = true, dataType = "Integer")
		})
		public String deleteStudentInfoP(int id) {
			service.deleteStudentById(id);
			return "成功删除一个学生信息\n";
		}
		
		@RequestMapping(value="getStudentByIdP", method=RequestMethod.POST)
		@ApiImplicitParams({
			@ApiImplicitParam(name = "id", paramType = "query", required = true, dataType = "String")
		})
		public String getStudentByIdP(int id) {
			return "查询学生信息成功\n" + service.getStudentById(id);
		}
}
