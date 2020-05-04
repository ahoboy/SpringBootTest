package com.kotei.SpringBootTest.Service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kotei.SpringBootTest.Entity.StudentEntity;
import com.kotei.SpringBootTest.dao.StudentDao;

//告诉SpringBoot这是一个Service组件
@Service
public class StudentService {
	
	@Autowired
	StudentDao dao;
	
	public void getStudentById() {
		StudentEntity stu = dao.findById(2);
		System.out.println("这是从数据库中取出的数据：" + stu.getSname());
	}
	
	public void insertStudent() {
		StudentEntity stu = new StudentEntity();
		stu.setSname("孙悟空");
		stu.setSage(new Date(new java.util.Date().getTime()));
		stu.setSsex("男");
		
		dao.save(stu);
		System.out.println("已新增一条studnet信息");
	}
	
	public void updateStudent() {
		StudentEntity stu = new StudentEntity();
		stu.setSid(17);
		stu.setSname("龙女");
		stu.setSage(new Date(new java.util.Date().getTime()));
		stu.setSsex("女");
		
		dao.save(stu);
		System.out.println("已修改一条student信息");
	}
	
	public void deleteStudent() {	
		dao.deleteById(17);
		System.out.println("已删除一条student信息");
	}
	
	public void deleteStudentById(int id) {	
		dao.deleteById(id);
		System.out.println("已删除id为"+ id+"的student信息");
	}
	
	public void deleteStudentByEntity(StudentEntity stu) {
		dao.delete(stu);
		System.out.println("已删除姓名为"+ stu.getSname()+"的student信息");
	}
}
