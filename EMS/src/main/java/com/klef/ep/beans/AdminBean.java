package com.klef.ep.beans;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Admin;
import com.klef.ep.models.EmpRequest;
import com.klef.ep.models.Employee;
import com.klef.ep.models.Messages;
import com.klef.ep.models.Task;
import com.klef.ep.services.AdminService;

@ManagedBean(name = "adminbean", eager = true)
public class AdminBean 
{
	@EJB(lookup = "java:global/EPProject/AdminServiceImpl!com.klef.ep.services.AdminService")
	AdminService adminservice;
	
	private int id;
	private String name;
	private String gender;
	private String email;
	private String contact;
	private String password;
	
	private int taskid;
	private String taskname;
	private String startdate;
	private String deadline;
	private String status;
	 private int messageid;
	 private String sender;
	 private String receiver;
	 private String subject;
	 private String message;
	 private String date;
	 
	 private List<Task> tasklist;
	 private List<Messages> messageslist;
	
	public AdminService getAdminservice() {
		return adminservice;
	}
	public void setAdminservice(AdminService adminservice) {
		this.adminservice = adminservice;
	}
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
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
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
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Task> getTasklist() {
		return adminservice.viewalltasks();
	}
	public void setTasklist(List<Task> tasklist) {
		this.tasklist = tasklist;
	}
	public List<Messages> getMessageslist() {
		return adminservice.viewallmessages();
	}
	public void setMessageslist(List<Messages> messageslist) {
		this.messageslist = messageslist;
	}
	public void validateadminlogin() throws IOException
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
		Admin a = adminservice.checkadminlogin(id, password);
		
		if(a!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("admin", a); 
			
			response.sendRedirect("admindashboard.jsf");
			
		}
		else
		{
			response.sendRedirect("adminlogin.jsf");
		}
	}
	
	public Admin viewadminbyid(int aid) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Admin a = em.find(Admin.class, aid);
		
		if(a==null)
		{
			em.close();
			emf.close();
			return null;
		}
		
		em.close();
		emf.close();
		
		return a;
	}
	public Admin sessionman() throws IOException
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        HttpSession session = request.getSession(false);  // Use false to avoid creating a new session if it doesn't exist
        Admin admin = (Admin) session.getAttribute("admin");
        
        if (admin == null)
        {
            response.sendRedirect("adminsessionexpiry.html");
            return null;
        }
        
        return admin;
    }
    
    public void logout() throws IOException
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        session.invalidate();  // Invalidate the session to remove all attributes
        response.sendRedirect("adminlogin.jsf");
    }
    
    public String addtask() {
        Task t = new Task();
        
        int currentYear = Year.now().getValue();
        int randomNumber = (int)(Math.random() * 9999) + 1;
        String randomid = currentYear + String.format("%04d", randomNumber);
        
        try {
            taskid = Integer.parseInt(randomid);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return "error.xhtml"; 
        }
        
       t.setTaskid(taskid);
       t.setTaskname(taskname);
       t.setStartdate(startdate);
       t.setDeadline(deadline);
       t.setStatus(status);
       

        adminservice.addtask(t);

        return "adminpublictasks.jsf?faces-redirect=true";
    }
	
    public String addmessage()
    {
		Messages m = new Messages();
        
        int currentYear = Year.now().getValue();
        int randomNumber = (int)(Math.random() * 9999) + 1;
        String randomid = currentYear + String.format("%04d", randomNumber);
        
        try {
            messageid = Integer.parseInt(randomid);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return "error.xhtml"; 
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        HttpSession session = request.getSession(false);  // Use false to avoid creating a new session if it doesn't exist
        Admin admin = (Admin) session.getAttribute("admin");
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String date=(String)formattedDate;
        
       m.setMessageid(messageid);
       m.setSender(admin.getName());
       m.setReceiver("employees@organization.in");
       m.setSubject(subject);
       m.setMessage(message);
       m.setDate(date);
       

        adminservice.addmessage(m);

        return "adminpublicmessages.jsf?faces-redirect=true";
    }
	
	
}
