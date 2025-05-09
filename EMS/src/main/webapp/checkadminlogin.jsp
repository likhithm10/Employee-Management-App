<%@page import="com.klef.ep.models.Admin"%>
<%@page import="com.klef.ep.services.AdminService"%>
<%@page import="javax.naming.InitialContext"%>
<%

int aid=Integer.parseInt(request.getParameter("id"));
String apassword=request.getParameter("password");

InitialContext context = new InitialContext();

AdminService adminService = (AdminService) context.lookup("java:global/EPProject/AdminServiceImpl!com.klef.ep.services.AdminService");


	
	
Admin a = adminService.checkadminlogin(aid, apassword);

if(a!=null)
{
	response.sendRedirect("admindashboard.x html");
}
else
{
	response.sendRedirect("adminlogin.html");
	
}

%>