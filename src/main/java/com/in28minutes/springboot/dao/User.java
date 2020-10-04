package com.in28minutes.springboot.dao;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All detailes about user")
public class User {
	private Integer id;
	
	@Size(min = 2 ,message = "Should have atleast 2 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "should be in the bast")
	private Date date;
	
	public User(Integer id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getDate() {
		return date;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
