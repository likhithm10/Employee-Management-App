package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.EmpRequest;
import com.klef.ep.models.Employee;
import com.klef.ep.models.FormerEmployee;

@Remote
public interface EmployeeService 
{
	public String addemployee(Employee employee);
	public Employee viewempbyid(int eid);
	public List<Employee> viewallemps();
	
	public Employee checkemplogin(int id,String password);
	public String terminateemployee(int eid);
	public List<FormerEmployee> viewallformeremps();
	public String retriveemployee(int eid);
	public String empaddreq(EmpRequest emp);
	public List<EmpRequest> viewallreqemps();
	public String declineemp(String pmail);
	public Employee updateempbyid(int eid);
	 public String updateemployee(Employee employee);
}
