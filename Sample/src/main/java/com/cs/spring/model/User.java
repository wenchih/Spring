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

	private String name;	
	private int userid;
	private String email;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date timestamp;

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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
//	@Override
//	public String toString(){
//		
//		return "["
//		+ "{\"id\":"+ id+","
//		+ "\"name\":\""+ name +"\","
//		+ "\"userid\":"+ userid +","
//		+ "\"email\":\""+ email +"}]" ;		
//	}
	
	//new

	


	
}
