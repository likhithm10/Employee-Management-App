<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.klef.ep.models.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    Employee emp = (Employee) session.getAttribute("employee");
    if(emp==null)
    {
      response.sendRedirect("employeesessionexpiry.html");
    }
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dob = sdf.format(emp.getDob());
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
    
    <link rel="stylesheet" href="./resources/css/adminaddmessages.css" />
    <link rel="stylesheet" href="./resources/css/updatetable.css" type="text/css" />
  	<link rel="stylesheet" href="./resources/css/adminmenu.css" type="text/css" />
  	<link rel="stylesheet" href="./resources/css/admindashboard.css" type="text/css" />
    <script src="dashboard.js" defer></script>
    <script src="menu.js" defer></script>
    <link rel="icon" href="images/logo.png" type="image/icon type">
    <title>Emp Power Hub</title>
</head>
<body>
   <section id="sidebar">
		<a href="employeedashboard.jsf" class="brand">
			<img style="height: 52%; margin-left: 10px; margin-right: 10px;" src="images/logo.png" alt="here" />
			<span class="text">Emp Power Hub</span>
		</a>
		<ul class="side-menu top">
			<li class="active">
				<a href="employeedashboard.jsf">
					<i class="bx bxs-dashboard"></i>
					<span class="text">Dashboard</span>
				</a>
			</li>
			<li>
				<a href="employeemytask.jsf">
					<i class="bx bxs-shopping-bag-alt"></i>
					<span class="text">My Task</span>
				</a>
			</li>
			<li>
				<a href="employeemessages.jsf">
					<i class="bx bxs-message-dots"></i>
					<span class="text">Message</span>
				</a>
			</li>
			<li>
				<a href="employeeprofile.jsf">
					<i class="bx bxs-group"></i>
					<span class="text">Profile</span>
				</a>
			</li>
		</ul>
		<ul class="side-menu">
			<li>
				<a href="employeelogin.jsf" class="logout">
					<i class="bx bxs-log-out-circle"></i>
					<span class="text">Logout</span>
				</a>
			</li>
		</ul>
	</section>
	

	<section id="content">
		<nav>
			<i class="bx bx-menu"></i>
			<form action="#">
				<div class="form-input"></div>
			</form>
			<a href="employeemessages.jsf" class="notification">
				<i class="bx bxs-bell"></i>
				<span class="num">0</span>
			</a>
			<a href="employeeprofile.jsf" class="profile">
				<img src="images/profile.png" />
			</a>
		</nav>
        <main>
            <div class="head-title">
                <div class="left">
                    <ul class="breadcrumb">
                        <li>
							<a class="active" href="employeedashboard.jsf">EMS</a>
						</li>
                        <li><i class='bx bx-chevron-right'></i></li>
                        <li>
                            <a class="active" href="employeeprofile.jsf">Profile</a>
                        </li>
                        <li><i class='bx bx-chevron-right'></i></li>
                        <li>
                            <a class="active" href="updateemployeeprofile.jsp">Update Profile</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="table-data">
				<div class="order">
					<div>
                        <form action="profileupdate.jsp" method="post">
                            <table>
                            <div class="head">
						        <h3>Update Profile</h3>
                            </div>
                            <tr>
                            <div>
                                <td><label for="to">ID:</label></td>
                                <td><input type="number"  name="id" value="<%=emp.getId()%>" readonly="readonly" /></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">First Name:</label></td>
                                <td><input type="text"  name="firstname" value="<%=emp.getFirstname()%>"/></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">Last Name:</label></td>
                                <td><input type="text" name="lastname" value="<%=emp.getLastname()%>"/></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">Gender:</label></td>
                                <td><input type="text" name="gender" value="<%=emp.getGender()%>" readonly/></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">Date Of Birth:</label></td>
                                <td><input type="date" name="dob" pattern="yyyy-mm-dd" value="<%=dob%>"/></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">Father Name:</label></td>
                                <td><input type="text" name="fathername" value="<%=emp.getFathername()%>"/></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">Personal Email:</label></td>
                                <td><input type="text" name="pmail" value="<%=emp.getPmail()%>"/></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">Complany Email:</label></td>
                                <td><input type="text" id="to" name="cmail" value="<%=emp.getCmail()%>" readonly/></td>
                            </div>
                            </tr>
                             <tr>
                            <div>
                                <td><label for="to">Department:</label></td>
                                <td><input type="text" name="department" value="<%=emp.getDepartment()%>" readonly/></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">Contact:</label></td>
                                <td><input type="text" name="contact" value="<%=emp.getContact()%>"/></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">Address:</label></td>
                                <td><input type="text" name="address" value="<%=emp.getAddress()%>"/></td>
                            </div>
                            </tr>

                            
                            <tr>
                                <div>
                                    <td><label for="to">Job Role:</label></td>
                                    <td><input type="text" name="jobrole" value="<%=emp.getJobrole()%>" readonly/></td>
                                </div>
                                </tr>
                            <tr>
                            <div>
                                <td><label for="to">Salary:</label></td>
                                <td><input type="text" name="salary" value="<%=emp.getSalary()%>" readonly/></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">Password:</label></td>
                                <td><input type="text" name="password" value="<%=emp.getPassword()%>"/></td>
                            </div>
                            </tr>
                            <tr>
                            <div>
                                <td><label for="to">GitHub:</label></td>
                                <td><input type="text" name="github" value="<%=emp.getGithub()%>"/></td>
                            </div>
                            </tr><tr>
                            <div>
                                <td><label for="to">Twitter:</label></td>
                                <td><input type="text" name="twitter" value="<%=emp.getTwitter()%>"/></td>
                            </div>
                            </tr><tr>
                            <div>
                                <td><label for="to">Instagram:</label></td>
                                <td><input type="text" name="instagram" value="<%=emp.getInstagram()%>"/></td>
                            </div>
                            </tr><tr>
                            <div>
                                <td><label for="to">Facebook:</label></td>
                                <td><input type="text" name="facebook" value="<%=emp.getFacebook()%>"/></td>
                            </div>
                            </tr>
                            <tr align="center">
							    <td>
							        <input type="submit" style="display: inline-block; padding: 10px 20px; color: #fff; background-color: #007bff;
							         border: none; border-radius: 4px; cursor: pointer; font-size: 16px;" value="Update" required>
							    </td>
							    <td>
							        <input type="reset" style="display: inline-block; padding: 10px 20px; color: #fff; background-color: #007bff; 
							        border: none; border-radius: 4px; cursor: pointer; font-size: 16px;" value="Clear" required>
							    </td>
							</tr>
                            </table>
                            
                        </form>
                    </div>
					
				</div>
			</div>
            
        </main>
    </section>
</body>
</html>

    