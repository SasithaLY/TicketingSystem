<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" >
</head>
<body>
<h1>Ticketing System</h1>
<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		
		if((session.getAttribute("name")==null) ||(!session.getAttribute("type").equals("admin")) && (!session.getAttribute("type").equals("user")))
		{%>
			
			<div class="container-fluid" align="right" style="position: fixed;top : 10px;right: 20px">
				
				<a href="login.jsp" class="container"><button class="btn btn-primary" >Login</button></a>
				<a href="Register.jsp"><button class="btn btn-primary">Sign Up</button></a>
			</div>
		
		<% 
		}
		else{
	%>
	
	<form method="post" action="logoutVal">
			<div class="loginArea" align="right" style="position: fixed;top : 10px;right: 20px">
			Welcome Back!<br> <%=session.getAttribute("name") %><a href="login.jsp"><br><button class="button button1">Logout</button></a>
			</div>
		</form>
			
	<%
		}
	%>
</body>
</html>