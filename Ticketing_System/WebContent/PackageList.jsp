<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
    <%@ include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Manage Packages</title>
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
<div class="container"><center><h1><b>Manage Packages</b></h1></center></div>
	<div class="container-fluid" style="padding-top:50px">
		<div class="table-responsive">
			<table border="1" class="table table-striped table-bordered">
				<tr class="thead-dark">
					<th>Package ID</th>
					<th>Package Type</th>
					<th>Package Name</th>
					<th>Duration</th>
					<th>Loan Amount</th>
					<th>Package Price</th>
					<th>Description</th>
					<th>Special Offers</th>
					<th>Actions</th>
				</tr>
				<c:forEach  items = "${packageList}" var = "pack">
					<tr>
						<td>${pack.packageId}</td>
						<td>${pack.packageType}</td>
						<td>${pack.duration}</td>
						<td>${pack.loanAmount}</td>
						<td>${pack.packagePrice}</td>
						<td>${pack.packageName}</td>
						<td>${pack.description}</td>
						<td>${pack.specialOffer}</td>
						
						<td>
							<a href="${pageContext.request.contextPath}/packageController?action=EDIT&id=${pack.packageId}"><button class="btn btn-success">EDIT</button></a>
							
							<a href="${pageContext.request.contextPath}/packageController?action=REMOVE&id=${pack.packageId}"><button class="btn btn-danger">REMOVE</button></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="container-fluid" style="float:right">
		
			<a href="${pageContext.request.contextPath}/AddPackage.jsp"><button class="btn btn-primary" style="float:right">Add New Package</button></a>
	
	</div>
</body>
</html>