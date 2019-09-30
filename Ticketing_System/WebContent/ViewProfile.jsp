<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="width:60%">
  <br>
  <h2>Profile</h2>
  <br>
  <div class="form-container" >
  <form action="${pageContext.request.contextPath}/UserController?action=EDIT&id=${user.userId}" method="post" class="was-validated" >
  
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
      <input type="text" class="form-control" value="${user.firstName}" id="firstName" placeholder="Enter First Name" name="firstName" disabled>
	</div>
    </div>
    <div class="form-group">
      <label for="lastName">Last Name : </label>
      <div style="padding: 20px">
      <input  type="text" class="form-control" value="${user.lastName}" id="lastName" placeholder="Enter Last Name" name="lastName" disabled>
      </div>
    </div>
    </div>
    
    <div class="form-group">
      <label for="address">Address: </label>
      <input type="text" class="form-control" value="${user.address}" id="address" placeholder="Enter Address" name="address" disabled>

    </div>
    
    <div class="form-group">
      <label for="dob">Date of Birth: </label>
      <input type="date" class="form-control" value="${user.dob}" id="dob" placeholder="Enter date of birth" name="dob" disabled>

    </div>
    
    
    <div class="form-group">
      <label for="nic">National Identity Card No: </label>
      <input type="text" class="form-control" value="${user.nic}" id="dob" placeholder="Enter NIC" name="nic" disabled>
     
    </div>
    
    <input type="hidden" value="${user.userId}" name="userId">
    <button type="submit" class="btn btn-primary">Update Profile</button>
    
  </form>
    
  </div>
  
</div>

</body>
</html>