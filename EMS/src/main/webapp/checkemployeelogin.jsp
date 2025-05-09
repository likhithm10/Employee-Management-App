<%@page import="com.klef.ep.models.Employee"%>
<%@page import="com.klef.ep.services.EmployeeService"%>
<%@page import="javax.naming.InitialContext"%>
<%

int eid=Integer.parseInt(request.getParameter("id"));
String epassword=request.getParameter("password");

InitialContext context = new InitialContext();

EmployeeService employeeService = (EmployeeService) context.lookup("java:global/EPProject/EmployeeServiceImpl!com.klef.ep.services.EmployeeService");


	
	
Employee e = employeeService.checkemplogin(eid, epassword);

if(e!=null)
{
	response.sendRedirect("employeedashboard.xhtml");
}
else
{
	response.sendRedirect("employeelogin.html");
	
}

%>