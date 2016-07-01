package com.cs.spring.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation 
 */
@Entity
@Table(name="USER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//��鞈��
	private String name;	
	private String studentid;
	private String email;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	@Override
	public String toString(){
		
		return "["
		+ "{\"id\":"+ id+","
		+ "\"name\":\""+ name +"\","
		+ "\"studentid\":"+ studentid +","
		+ "\"email\":\""+ email +"}]" ;		
	}
	
	//new

	


	
}
