<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@include file="/Header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<center>
<div class="container" style="padding-top:10%;  display: inline-block; align-items: center; text-align:center;">

	<div class="row">
	  <div class="col-*-*" style="padding:10px; width:50%;">
	  
	  	<a href="${pageContext.request.contextPath}/UserController?action=VIEW" >
		  	<div class="container" style="position:center; background-color:#EBEBEB; float:right;">
		  		<span class="" style="text-align: center; display: block; padding-top:30px">
      				<img class="" src="assets/img/accountIcon.png" alt="Card image" style=" ">
   				</span>
	    		
	    		<div class="card-body">
	     		 	<center><h4 class="card-title">Account</h4></center>
	      			
	    		</div>
	  		</div>
  		</a>
	  </div>
	  <div class="col-*-*" style="padding:10px; width:50%;">
		  <a href="${pageContext.request.contextPath}/UserController?action=VIEW" >
			  	<div class="container" style="position:center; background-color:#EBEBEB; float:right">
			  		<span class="" style="text-align: center; display: block; padding-top:30px">
	      				<img class="" src="assets/img/cardIcon.png" alt="Card image" style=" ">
	   				</span>
		    		
		    		<div class="card-body">
		     		 	<center><h4 class="card-title">Payments</h4></center>
		      			
		    		</div>
		  		</div>
	  		</a>
	  </div>
	  
	  <div class="col-*-*" style="padding:10px; width:50%; ">
		  <a href="${pageContext.request.contextPath}/UserController?action=VIEW" >
			  	<div class="container" style="position:center; background-color:#EBEBEB; float:right">
			  		<span class="" style="text-align: center; display: block; padding-top:30px">
	      				<img class="" src="assets/img/busIcon.png" alt="Card image" style=" ">
	   				</span>
		    		
		    		<div class="card-body">
		     		 	<center><h4 class="card-title">Book a Bus</h4></center>
		      			
		    		</div>
		  		</div>
	  		</a>
	  </div>
	  
	  <div class="col-*-*" style="padding:10px; width:50%;">
		  <a href="${pageContext.request.contextPath}/Settings.jsp" >
			  	<div class="container" style="position:center; background-color:#EBEBEB; float:right; ">
			  		<span class="" style="text-align: center; display: block; padding-top:30px">
	      				<img class="" src="assets/img/settingsIcon.png" alt="Card image" style=" ">
	   				</span>
		    		
		    		<div class="card-body">
		     		 	<center><h4 class="card-title">Settings</h4></center>
		      			
		    		</div>
		  		</div>
	  		</a>
	  </div>
	  
	</div>
	

</div>
</center>
</body>
</html>