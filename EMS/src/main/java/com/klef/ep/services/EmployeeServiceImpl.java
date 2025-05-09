package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.beans.EmployeeBean;
import com.klef.ep.models.EmpRequest;
import com.klef.ep.models.Employee;
import com.klef.ep.models.FormerEmployee;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EmployeeServiceImpl implements EmployeeService
{
   int updateid;
	@Override
	public String addemployee(Employee employee) 
	{
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    
	        em.getTransaction().begin();

	        // Create a new EmpRequest instance
	        EmpRequest e = new EmpRequest();
	        e.setFirstname(employee.getFirstname());
	        e.setLastname(employee.getLastname());
	        e.setGender(employee.getGender());
	        e.setDob(employee.getDob());
	        e.setContact(employee.getContact());
	        e.setFathername(employee.getFathername());
	        e.setPmail(employee.getPmail());
	        e.setDepartment(employee.getDepartment());
	        e.setAddress(employee.getAddress());
	        
	        // Persist the Employee instance
	        em.persist(employee);

	        // Ensure the EmpRequest instance is managed before removal
	        e = em.merge(e);
	        em.remove(e);

	        em.getTransaction().commit();
	        em.close();
	        emf.close();
	        return "Employee Added Successfully";
	   
	        
	    
	}

	
	@Override
	public String empaddreq(EmpRequest emp) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(emp); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Employee Requested Successfully";
	}

	public Employee viewempbyid(int eid) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Employee e = em.find(Employee.class, eid);
		
		if(e==null)
		{
			em.close();
			emf.close();
			return null;
		}
		
		em.close();
		emf.close();
		
		return e;
	}
	@Override
	public Employee updateempbyid(int eid) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Employee e = em.find(Employee.class, eid);
		
		if(e==null)
		{
			em.close();
			emf.close();
			return null;
		}
		
		em.close();
		emf.close();
		System.out.println(e.getId());
		return e;
	}
	

	@Override
	public Employee checkemplogin(int id, String password) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		// e is an alias of Employee Class
		Query qry = em.createQuery("select e from Employee e where e.id=? and e.password=?");
		qry.setParameter(1, id);
		qry.setParameter(2, password);
		
		Employee emp = null;
		
		if(qry.getResultList().size()>0)
		{
			emp = (Employee)qry.getSingleResult();
		}
		
	em.close();
	emf.close();
	
	return emp;
	}	
	
	@Override
	public List<Employee> viewallemps() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select e from Employee e");
		// e is an alias of Employee Class
		List<Employee> emplist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return emplist;
	}
	
	@Override
	public List<FormerEmployee> viewallformeremps() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select fe from FormerEmployee fe");
		List<FormerEmployee> formeremplist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return formeremplist;
	}
	
	@Override
	public List<EmpRequest> viewallreqemps() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select er from EmpRequest er");
		List<EmpRequest> empreqlist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return empreqlist;
	}
	
	
	@Override
	public String terminateemployee(int eid) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		Employee e = em.find(Employee.class, eid);
		
		 FormerEmployee formerEmployee = new FormerEmployee();
         formerEmployee.setId(e.getId());
         formerEmployee.setFirstname(e.getFirstname());
         formerEmployee.setLastname(e.getLastname());
         formerEmployee.setGender(e.getGender());
         formerEmployee.setDob(e.getDob());
         formerEmployee.setContact(e.getContact());
         formerEmployee.setMartialstatus(e.getMartialstatus());
         formerEmployee.setFathername(e.getFathername());
         formerEmployee.setPmail(e.getPmail());
         formerEmployee.setCmail(e.getCmail());
         formerEmployee.setDepartment(e.getDepartment());
         formerEmployee.setJobrole(e.getJobrole());
         formerEmployee.setAddress(e.getAddress());
         formerEmployee.setSalary(e.getSalary());
         formerEmployee.setPassword(e.getPassword());
         formerEmployee.setGithub(e.getGithub());
         formerEmployee.setTwitter(e.getTwitter());
         formerEmployee.setInstagram(e.getInstagram());
         formerEmployee.setFacebook(e.getFacebook());

		em.persist(formerEmployee); 
		em.remove(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Employee Terminated Successfully";
	}
	
	@Override
	public String retriveemployee(int eid) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		FormerEmployee e = em.find(FormerEmployee.class, eid);
		
		 Employee employee = new Employee();
		 employee.setId(e.getId());
		 employee.setFirstname(e.getFirstname());
		 employee.setLastname(e.getLastname());
		 employee.setGender(e.getGender());
		 employee.setDob(e.getDob());
         employee.setContact(e.getContact());
         employee.setMartialstatus(e.getMartialstatus());
         employee.setFathername(e.getFathername());
         employee.setPmail(e.getPmail());
         employee.setCmail(e.getCmail());
         employee.setDepartment(e.getDepartment());
         employee.setJobrole(e.getJobrole());
         employee.setAddress(e.getAddress());
         employee.setSalary(e.getSalary());
         employee.setPassword(e.getPassword());
         employee.setGithub(e.getGithub());
         employee.setTwitter(e.getTwitter());
         employee.setInstagram(e.getInstagram());
         employee.setFacebook(e.getFacebook());

		em.persist(employee); 
		em.remove(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Employee Retrived Successfully";
	}
	
	@Override
	public String declineemp(String pmail) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		EmpRequest e = em.find(EmpRequest.class, pmail);
		em.remove(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Employee Declined Successfully";
	}
	
	@Override
	public String updateemployee(Employee employee) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee e = em.find(Employee.class, employee.getId());
		 e.setFirstname(employee.getFirstname());
         e.setLastname(employee.getLastname());
         e.setGender(employee.getGender());
         e.setDob(employee.getDob());
         e.setFathername(employee.getFathername());
         e.setPmail(employee.getPmail());
         e.setCmail(employee.getCmail());
         e.setDepartment(employee.getDepartment());
         e.setContact(employee.getContact());
         e.setAddress(employee.getAddress());
         e.setJobrole(employee.getJobrole());
         e.setSalary(employee.getSalary());
         e.setPassword(employee.getPassword());
         e.setGithub(employee.getGithub());
         e.setTwitter(employee.getTwitter());
         e.setInstagram(employee.getInstagram());
         e.setFacebook(employee.getFacebook());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Employee Updated Successfully";
	}
	
}
