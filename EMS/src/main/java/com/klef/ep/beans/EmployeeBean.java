package com.klef.ep.beans;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.klef.ep.models.Admin;
import com.klef.ep.models.EmpRequest;
import com.klef.ep.models.Employee;
import com.klef.ep.models.FormerEmployee;
import com.klef.ep.services.EmployeeService;

// ManagedBean is a controller
@ManagedBean(name = "empbean", eager = true)
public class EmployeeBean {
    @EJB(lookup = "java:global/EPProject/EmployeeServiceImpl!com.klef.ep.services.EmployeeService")
    EmployeeService service;
    
    private int id;
    private String firstname;
    private String lastname;
    private String gender;
    private Date dob;
    private String contact;
    private String martialstatus;
    private String fathername;
    private String pmail;
    private String cmail;
    private String department;
    private String jobrole;
    private String address;
    private double salary;
    private String password;
    private String github;
    private String twitter;
    private String instagram;
    private String facebook;
    
    private int updateid;
    
    private List<Employee> emplist;
    private List<FormerEmployee> formeremplist;
    private List<EmpRequest> empreqlist;
    private Employee empbyid;
    
    
    // Formatted date property
    private String formattedDob;

    public EmployeeService getService() {
        return service;
    }

    public void setService(EmployeeService service) {
        this.service = service;
    }

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
        // Update the formatted date whenever dob is set
        this.formattedDob = formatDate(dob);
    }

    public String getFormattedDob() {
        return formattedDob;
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

    public int getUpdateid() {
		return updateid;
	}

	public void setUpdateid(int updateid) {
		this.updateid = updateid;
	}

	public String addemployee(EmpRequest empreq) throws IOException {
        Employee e = new Employee();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        int currentYear = Year.now().getValue();
        int randomNumber = (int)(Math.random() * 9999) + 1;
        String randomid = currentYear + String.format("%04d", randomNumber);
        
        try {
            id = Integer.parseInt(randomid);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        e.setId(id);
        e.setFirstname(empreq.getFirstname());
        e.setLastname(empreq.getLastname());
        e.setGender(empreq.getGender());
        e.setDob(empreq.getDob()); // No need to format date here as it's handled in EmployeeService
        e.setContact(empreq.getContact());
        e.setMartialstatus("single"); 
        e.setFathername(empreq.getFathername());
        e.setPmail(empreq.getPmail());
        e.setCmail(randomid + "@gmail.com");
        e.setDepartment(empreq.getDepartment());
        e.setJobrole("jobrole"); 
        e.setAddress(empreq.getAddress());
        e.setSalary(10000); 
        e.setPassword("ems@klu");  
        e.setGithub("github");  
        e.setTwitter("twitter"); 
        e.setFacebook("facebook");  
        e.setInstagram("insta"); 

        service.addemployee(e);

        setUpdateid(id);
        return "adminemployeerequest.jsf?faces-redirect=true"; 
    }
    
   
    
    public String empaddreq() {
        EmpRequest e = new EmpRequest();
        
        e.setFirstname(firstname);
        e.setLastname(lastname);
        e.setGender(gender);
        e.setDob(dob); // No need to format date here as it's handled in EmployeeService
        e.setContact(contact);
       
        e.setFathername(fathername);
        e.setPmail(pmail);
        
        e.setDepartment(department);
        
        e.setAddress(address);
       

        service.empaddreq(e);

        return "employeelogin.jsf?faces-redirect=true";
    }

    public void validateemplogin() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        
        Employee e = service.checkemplogin(id, password);
        
        if(e != null) {
            HttpSession session = request.getSession();
            session.setAttribute("employee", e); 
            
            response.sendRedirect("employeedashboard.jsf");
        } else {
            response.sendRedirect("employeelogin.jsf");
        }
    }

    

    // Method to format the date
    private String formatDate(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }
        return "";
    }
    
    
    public String terminate(int eid) 
	{
		service.terminateemployee(eid);
		
		return "adminactiveemployee.jsf";
	}
    
    public String retrive(int eid) 
	{
		service.retriveemployee(eid);
		
		return "adminexemployee.jsf";
	}

    public List<Employee> getEmplist() {
        return service.viewallemps();
    }

    public void setEmplist(List<Employee> emplist) {
        this.emplist = emplist;
    }
    
    
	public List<FormerEmployee> getFormeremplist() {
		return service.viewallformeremps();
	}

	public void setFormeremplist(List<FormerEmployee> formeremplist) {
		this.formeremplist = formeremplist;
	}

	public List<EmpRequest> getEmpreqlist() {
		return service.viewallreqemps();
	}

	public void setEmpreqlist(List<EmpRequest> empreqlist) {
		this.empreqlist = empreqlist;
	}
    
	public Employee getEmpbyid() {
		return service.updateempbyid(updateid);
	}

	public void setEmpbyid(Employee empbyid) {
		this.empbyid = empbyid;
	}

	public String declineemp(String pmail) 
	{
		service.declineemp(pmail);
		
		return "adminemployeerequest.jsf";
	}
	
	
	public Employee sessionman() throws IOException
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        HttpSession session = request.getSession(false);  // Use false to avoid creating a new session if it doesn't exist
        Employee employee = (Employee) session.getAttribute("employee");
        
        if (employee == null)
        {
            response.sendRedirect("employeesessionexpiry.html");
            return null;
        }
        
        return employee;
    }
	
	public void logout() throws IOException
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        HttpSession session = request.getSession();
        session.removeAttribute("employee");
        session.invalidate();  // Invalidate the session to remove all attributes
        response.sendRedirect("employeelogin.jsf");
    }
}
