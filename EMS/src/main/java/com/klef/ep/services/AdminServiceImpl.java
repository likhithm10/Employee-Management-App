package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Admin;
import com.klef.ep.models.EmpRequest;
import com.klef.ep.models.Employee;
import com.klef.ep.models.Messages;
import com.klef.ep.models.Task;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AdminServiceImpl implements AdminService
{

	@Override
	public Admin checkadminlogin(int id, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		
		Query qry = em.createQuery("select a from Admin a where a.id=? and a.password=?");
		qry.setParameter(1, id);
		qry.setParameter(2, password);
		
		Admin admin = null;
		
		if(qry.getResultList().size()>0)
		{
			admin = (Admin)qry.getSingleResult();
		}
		
	em.close();
	emf.close();
	
	return admin;
	}
	
	@Override
	public String addtask(Task t) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(t); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Task Added Successfully";
	}
	
	@Override
	public String addmessage(Messages m) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(m); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Message Added Successfully";
	}
	
	@Override
	public List<Task> viewalltasks() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select t from Task t");
		List<Task> tasklist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return tasklist;
	}
	
	@Override
	public List<Messages> viewallmessages() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select m from Messages m");
		List<Messages> messageslist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return messageslist;
	}
	
}
