package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Messages;
import com.klef.ep.models.Task;

@Remote
public interface AdminService 
{
	public Admin checkadminlogin(int id,String password);

	public String addtask(Task t);

	public List<Task> viewalltasks();

	public String addmessage(Messages m);

	public List<Messages> viewallmessages();
}
