package com.kotei.SpringBootTest.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//跟数据表对应得Java属性类
@Entity
@Table(name="student")
public class StudentEntity {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//主键生成策略
	@Column(name="Sid")//数据库字段名
	private Integer sid;
	
	@Column(name="Sname")
	private String sname;
	
	@Column(name="Sage")
	private Date sage;
	
	@Column(name="Ssex")
	private String ssex;
	
	public StudentEntity(int id, String name, java.sql.Date age, String sex) {
		this.sid = id;
		this.sname = name;
		this.sage = age;
		this.ssex = sex;
	}

	public StudentEntity() {
		sid = null;
		sname = null;
		sage = null;
		ssex = null;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getSage() {
		return sage;
	}

	public void setSage(Date sage) {
		this.sage = sage;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	@Override
	public String toString() {
		return "StudentEntity [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", ssex=" + ssex + "]";
	}


}
