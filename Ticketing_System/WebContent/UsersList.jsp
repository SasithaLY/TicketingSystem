<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
    <%@ include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Manage Users</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" >

</head>

<body>
<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if((!session.getAttribute("type").equals("admin")))
		{ 
			session.invalidate();
			response.sendRedirect("Login.jsp");
		}
		%>
<div class="container"><center><h1><b>Manage Users</b></h1></center></div>
	<div class="container-fluid" style="padding-top:50px">
		<div class="table-responsive">
			<table border="1" class="table table-striped table-bordered">
				<tr class="thead-dark">
					<th>User ID</th>
					<th>Username</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Date of Birth</th>
					<th>NIC</th>
					<th>Created Date</th>
					<th>Package</th>
					<th>Account ID</th>
					<th>Type</th>
					<th>Actions</th>
				</tr>
				<c:forEach  items = "${userList}" var = "user">
					<tr>
						<td>${user.userId}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.address}</td>
						<td>${user.dob}</td>
						<td>${user.nic}</td>
						<td>${user.createdDate}</td>
						<td>${user.packageId}</td>
						<td>${user.accountId}</td>
						<td>${user.type}</td>
						<td>
							<!-- <a href="${pageContext.request.contextPath}/UserController?action=EDIT&id=${user.userId}">EDIT</a>  -->
							
							<a href="${pageContext.request.contextPath}/UserController?action=REMOVE&id=${user.userId}"><button class="btn btn-danger">REMOVE</button></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="container-fluid" style="float:right">
		
			<a href="${pageContext.request.contextPath}/AddAdmin.jsp"><button class="btn btn-primary" style="float:right">Add New Admin</button></a>
	
	</div>
</body>
</html>