package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_table")
public class Task implements Serializable
{
	@Id
	@Column(name="taskid")
	private int taskid;
	@Column(name = "taskname",length = 100)
	private String taskname;
	@Column(name = "startdate",nullable = false,length=15)
	private String startdate;
	@Column(name = "deadline",nullable = false,length=15)
	private String deadline;
	@Column(name = "status",nullable = false,length=20)
	private String status;
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	
	
	
}

