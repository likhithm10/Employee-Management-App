package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
public class Admin implements Serializable
{
	
	@Id 
	@Column(name = "id")
	private int id;
	@Column(name = "name",nullable = false,length = 50)
	private String name;
	@Column(name = "gender",nullable = false,length=10)
	private String gender;
	@Column(name = "email",nullable = false,length=50,unique = true)
	private String email;
	@Column(name = "contact",nullable = false,length=20,unique = true)
	private String contact;
	@Column(name = "password",nullable = false,length=50)
	private String password;
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

