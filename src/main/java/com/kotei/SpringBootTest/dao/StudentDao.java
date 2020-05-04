package com.kotei.SpringBootTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kotei.SpringBootTest.Entity.StudentEntity;

@Repository
public interface StudentDao extends  JpaRepository<StudentEntity,Integer>{

	@Query("from StudentEntity where id = ?1")//select * from student where id = ? and sname = ?;
	public StudentEntity findById(int id);
}
