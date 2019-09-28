<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" >	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<div style="padding-top:20px">

</div>
<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if((session.getAttribute("username")==null))
		{%>
			<div >
			<div class="container-fluid" align="right" style="bottom : 10px; right: 20px">
				
				<a href="Login.jsp" class="container"><button class="btn btn-primary" >Login</button></a>
				<a href="Register.jsp"><button class="btn btn-primary">Sign Up</button></a>
			</div>
		</div>

		<% 
		}
		else if((session.getAttribute("type").equals("admin"))){
	%>
	<div >
		
			<div class="container-fluid" align="right" style="bottom : 10px; right: 20px">
			Welcome! <%=request.getSession().getAttribute("username") %><a href="${pageContext.request.contextPath}/UserController?action=LOGOUT" style="padding: 20px"><button class="btn btn-danger">Logout</button></a>
			<a href="${pageContext.request.contextPath}/AdminPanel.jsp" style="padding: 20px"><button class="btn btn-primary">Admin Panel</button></a>
			</div>
		
	</div>
	<%
		}else{
	%>
			<div >
				
					<div class="container-fluid" align="right" style="bottom : 10px; right: 20px">
					Welcome! <%=request.getSession().getAttribute("username") %><a href="${pageContext.request.contextPath}/UserController?action=LOGOUT" style="padding: 20px"><button class="btn btn-danger">Logout</button></a>
					</div>
				
			</div>
			<%
		}
	%>
<div style="padding-top:20px">

</div>

<div style="padding-top:0px">
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/Home.jsp">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/UserController?action=VIEW">View Profile</a>
      </li>    
    </ul>
  </div>  
</nav>
</div>
<br>


</body>
</html>