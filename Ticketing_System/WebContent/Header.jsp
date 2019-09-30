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




<div style="padding-top:0px">
<nav class="navbar navbar-expand-md navbar-dark" style="background-color:#258FF9">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/Home.jsp"><img class="img-responsive" style="" src="assets/img/logo2.png" alt="Logo" width="auto" height="auto"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon" style="color:black"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"></a>
      </li>
      <li class="nav-item" >
        <a class="nav-link" href=""></a>
      </li>
      
      <div style="float:right" >
        <%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if((session.getAttribute("username")==null))
		{%>
		
		
			<div class="container-fluid" align="right" style="float:right">
				
				<a href="Login.jsp" class="container"><button  class="btn btn-dark" >Login</button></a>
				<a href="Register.jsp"><button class="btn btn-dark">Sign Up</button></a>
			</div>
		
</ul>
</div>  
</nav>
</div>
		<% 
		}
		else if((session.getAttribute("type").equals("admin"))){
	%>
	<div >
				
			<div class="container-fluid" align="right" style="bottom : 10px; right: 20px">
			<a href="${pageContext.request.contextPath}/AdminPanel.jsp" style="padding: 20px"><button class="btn btn-dark">Admin Panel</button></a>
			<a href="${pageContext.request.contextPath}/UserController?action=LOGOUT" style="padding: 20px"><button class="btn btn-danger">Logout</button></a>
			</div>
		
	</div>
	</ul>
  </div>  
</nav>
</div>
<br>
<div style="float:left">
      <div style="float:left">
        <img class="img-responsive" alt="loginName" src="assets/img/userIcon.png" >
        </div>
        <div style="float:right; paddign-left:20px" >Welcome! <br><%=request.getSession().getAttribute("username") %></div>
      </div>
	<%
		}else{
	%>
			<div >
					<div class="container-fluid" align="right" style="bottom : 10px; right: 20px">
					<a href="${pageContext.request.contextPath}/ProfileMain.jsp" style="padding: 20px"><button class="btn btn-dark">Dashboard</button></a>
					<a href="${pageContext.request.contextPath}/UserController?action=LOGOUT" style="padding: 20px"><button class="btn btn-danger">Logout</button></a>
					</div>
				
			</div>
	
      </div>
          
    </ul>
  </div>  
</nav>
</div>
<br>

<div style="float:left; padding-left:20px">
      <div style="float:left">
        <img style="padding-right:10px; padding-top:4px"class="img-responsive" alt="loginName" src="assets/img/userIcon.png" >
        </div>
        <div style="float:right; paddign-left:20px" >Welcome! <br><%=request.getSession().getAttribute("username") %></div>
      </div>
      
		<%
		}
	%>
	
	<div style="float:right"><a href=""><img  class="img-responsive" alt="qrscan" src="assets/img/scanQR.png"></a></div>
<br>




</body>
</html>