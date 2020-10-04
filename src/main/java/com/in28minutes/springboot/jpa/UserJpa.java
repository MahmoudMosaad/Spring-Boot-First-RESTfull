package com.in28minutes.springboot.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String rol;
	
	
	public UserJpa() {
		super();
	}
	public UserJpa(String name, String rol) {
		super();
		this.name = name;
		this.rol = rol;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRol() {
		return rol;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", rol=" + rol + "]";
	}
	
	
}
