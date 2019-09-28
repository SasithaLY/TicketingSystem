<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/Header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit profile</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 
</head>
<body>
	
<div class="container">
  <br>
  <h2>Update Profile</h2>
  <br>
  <div class="form-container" >
  <form action="${pageContext.request.contextPath}/UserController?action=UPDATE" class="was-validated" method="POST">
  
    <div class="form-group">
      <label for="uname">Username: </label>
      <input type="text" class="form-control" value="${user.username}" id="uname" placeholder="Enter username" name="uname" disabled>

    </div>
    
    <div class="form-group">
      <label for="pwd">Password: </label>
      <input type="password" class="form-control" value="${user.password}" id="pwd" placeholder="Enter password" name="pswd" disabled>
     
    </div>
    
    <div class="form-inline">
     <div class="form-group">     
      <label for="firstName">First Name : </label>
      <div style="padding: 20px">
      <input type="text" class="form-control" value="${user.firstName}" id="firstName" placeholder="Enter First Name" name="firstName" required>
	</div>
    </div>
    <div class="form-group">
      <label for="lastName">Last Name : </label>
      <div style="padding: 20px">
      <input  type="text" class="form-control" value="${user.lastName}" id="lastName" placeholder="Enter Last Name" name="lastName" required>
      </div>
    </div>
    </div>
    
    <div class="form-group">
      <label for="address">Address: </label>
      <input type="text" class="form-control" value="${user.address}" id="address" placeholder="Enter Address" name="address" required>
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <div class="form-group">
      <label for="dob">Date of Birth: </label>
      <input type="date" class="form-control" value="${user.dob}" id="dob" placeholder="Enter date of birth" name="dob" required>
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    
    <div class="form-group">
      <label for="nic">National Identity Card No: </label>
      <input type="text" class="form-control" value="${user.nic}" id="dob" placeholder="Enter NIC" name="nic" required>
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <input type="hidden" value="${user.userId}" name="userId">
    <button type="submit" class="btn btn-primary">Update</button>
  </form>
  </div>
</div>


</body>
</html>