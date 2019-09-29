<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" >
</head>
<body>
<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if((session.getAttribute("type").equals("user")))
		{ 
			session.invalidate();
			response.sendRedirect("Login.jsp");
		}
		%>
		<div class="container"><center><h1><b>ADMIN PANEL</b></h1></center></div>
<div class="container" style="padding-top:50px">
	<a href="${pageContext.request.contextPath}/UserController?action=LIST"><button class="btn btn-primary shadow-sm" style="background-color: rgb(29,120,255); padding: 6% 10%; font-size:200%">View Users</button></a>

</div>
</body>
</html>