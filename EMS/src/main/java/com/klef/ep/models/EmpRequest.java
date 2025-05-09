package com.klef.ep.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emprequest_table")
public class EmpRequest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "firstname",nullable = false,length = 50)
	private String firstname;
	@Column(name = "lastname",nullable = false,length = 50)
	private String lastname;
	@Column(name = "gender",nullable = false,length=10)
	private String gender;
	@Column(name = "dob",nullable = false,length=10)
	private Date dob;
	@Column(name = "contact",nullable = false,length=20,unique = true)
	private String contact;
	@Column(name = "fathername",nullable = false,length=50)
	private String fathername;
	@Id
	@Column(name = "personalmail",length=50)
	private String pmail;
	@Column(name = "department",nullable = false,length=50)
	private String department;
	@Column(name = "address",nullable = false,length=80)
	private String address;
	
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getPmail() {
		return pmail;
	}
	public void setPmail(String pmail) {
		this.pmail = pmail;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
	
}

