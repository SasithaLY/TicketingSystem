<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Credit Card</title>
</head>
<body>
<div class="container" style="width:30%">

	<h1>Save Credit Card</h1>
	<br>
	<div class="form-container" >
	  <form action="${pageContext.request.contextPath}/UserController?action=SaveCard" class="was-validated" method="POST">
	   
	   <div class="form-group">
	      <label for="name">Name On Card: </label>
	      <input type="text" class="form-control" value="" id="name"  name="name" pattern="[a-zA-Z ]+" required>
		  <div class="valid-feedback"></div>
	      <div class="invalid-feedback">Invalid Input</div>
	    </div>
	    
	    <div class="form-group">
	      <label for="cardNo">Credit Card No: </label>
	      <input type="text" class="form-control" value="" id="cardNo" placeholder="Enter 16 digit card number" name="cardNo" pattern="[0-9]{16}" required>
		  <div class="valid-feedback"></div>
	      <div class="invalid-feedback">Enter 16 digit card number!</div>
	    </div>
	    
	    <div class="form-group">
	      <label for="expireDate">Expire Date: </label>
	      <input type="text" class="form-control" value="" id="expireDate" placeholder="MM/YY" name="expireDate" pattern="(?:0[1-9]|1[0-2])/[0-9]{2}" required>
		  <div class="valid-feedback"></div>
	      <div class="invalid-feedback">Invalid Date!</div>
	    </div>
	    
	    <input type="hidden" value="<%session.getAttribute("id");%>" name="userId">
	    <button type="submit" class="btn btn-primary">Save</button>
	  </form>
	</div>

</div>
</body>
</html>