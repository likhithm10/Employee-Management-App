package com.klef.ep.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formeremployee_table")
public class FormerEmployee implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id // primary key = unique + not null
	@Column(name = "id")
	private int id;
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
	@Column(name = "martialstatus",nullable = false, length = 20)
	private String martialstatus;
	@Column(name = "fathername",nullable = false,length=50)
	private String fathername;
	@Column(name = "personalmail",nullable = false,length=50,unique = true)
	private String pmail;
	@Column(name = "companymail",nullable = false,length=50,unique = true)
	private String cmail;
	@Column(name = "department",nullable = false,length=50)
	private String department;
	@Column(name = "jobrole",nullable = false,length=50)
	private String jobrole;
	@Column(name = "address",nullable = false,length=80)
	private String address;
	@Column(name = "salary",nullable = false, precision = 10,scale = 4)
	private double salary;
	@Column(name = "password",nullable = false,length=50)
	private String password;
	@Column(name = "github",nullable = false,length = 200)
	private String github;
	@Column(name = "twitter",nullable = false,length = 200)
	private String twitter;
	@Column(name = "instagram",nullable = false,length = 200)
	private String instagram;
	@Column(name = "facebook",nullable = false,length = 200)
	private String facebook;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getCmail() {
		return cmail;
	}
	public void setCmail(String cmail) {
		this.cmail = cmail;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMartialstatus() {
		return martialstatus;
	}
	public void setMartialstatus(String martialstatus) {
		this.martialstatus = martialstatus;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	
}

