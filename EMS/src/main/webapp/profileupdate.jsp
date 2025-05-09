<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.klef.ep.models.Employee"%>
<%@page import="com.klef.ep.services.EmployeeService"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%

    // Retrieve parameters from request
    int id = Integer.parseInt(request.getParameter("id"));
    String firstname = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    String gender = request.getParameter("gender");
    String dobString = request.getParameter("dob"); // It's a String here, we'll parse it
    String fathername = request.getParameter("fathername");
    String pmail = request.getParameter("pmail");
    String cmail = request.getParameter("cmail");
    String department = request.getParameter("department");
    String contact = request.getParameter("contact");
    String address = request.getParameter("address");
    String jobrole = request.getParameter("jobrole");
    double salary = Double.parseDouble(request.getParameter("salary"));
    String password = request.getParameter("password");
    String github = request.getParameter("github");
    String twitter = request.getParameter("twitter");
    String instagram = request.getParameter("instagram");
    String facebook = request.getParameter("facebook");

    // Convert dobString to java.util.Date
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date dob = null;
    try {
        dob = sdf.parse(dobString);
    } catch (Exception e) {
        e.printStackTrace();
        out.println("Invalid date format. Please use yyyy-MM-dd.");
        return;
    }

    InitialContext context = new InitialContext();
    EmployeeService employeeService = (EmployeeService) context.lookup("java:global/EPProject/EmployeeServiceImpl!com.klef.ep.services.EmployeeService");

    Employee e = employeeService.viewempbyid(id);

    if (e != null) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setFirstname(firstname);
        emp.setLastname(lastname);
        emp.setGender(gender);
        emp.setDob(dob);
        emp.setFathername(fathername);
        emp.setPmail(pmail);
        emp.setCmail(cmail);
        emp.setDepartment(department);
        emp.setContact(contact);
        emp.setAddress(address);
        emp.setJobrole(jobrole);
        emp.setSalary(salary);
        emp.setPassword(password);
        emp.setGithub(github);
        emp.setTwitter(twitter);
        emp.setInstagram(instagram);
        emp.setFacebook(facebook);

        employeeService.updateemployee(emp);

        Employee updatedEmployee = employeeService.viewempbyid(id);
        session.setAttribute("employee", updatedEmployee);

       response.sendRedirect("employeeprofile.jsf");
    } else {
        out.println("Employee ID Not Found");
    }

%>
