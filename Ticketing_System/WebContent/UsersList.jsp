<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Manage Users</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" >

</head>

<body>
	<div class="container-fluid">
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
				<th>Account</th>
			</tr>
			<c:forEach items = "${userList}" var = "user">
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
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>
</body>
</html>