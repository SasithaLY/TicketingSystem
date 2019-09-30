<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/Header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Package</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 
</head>
<body>
	
<div class="container">
  <br>
  <h2>Add Package</h2>
  <br>
  <div class="form-container" >
  <form action="${pageContext.request.contextPath}/packageController?action=UPDATE" class="was-validated" method="POST">
  
    <div class="form-group">
      <label for="uname">Package Type: </label>
      <input type="text" class="form-control" value="${pack.packageType}" id="uname" placeholder="Enter package type" name="ptype" required>

    </div>
    
    <div class="form-group">
      <label for="pwd">Duration: </label>
      <input type="number" class="form-control" value="${pack.duration}" id="pwd" placeholder="" name="pswd" required>
     
    </div>
    
    <div class="form-inline">
     <div class="form-group">     
      <label for="loan">Loan Amount : </label>
      <div style="padding: 20px">
      <input type="text" class="form-control" value="${pack.loanAmount}" id="loan" placeholder="" name="loan" pattern="[0-9.9]+" required>
	</div>
    </div>
    <div class="form-group">
      <label for="price">package Price : </label>
      <div style="padding: 20px">
      <input  type="text" class="form-control" value="${pack.packagePrice}" id="price" placeholder="" name="price" pattern="[0-9.9]+" required>
      </div>
    </div>
    </div>
    
    <div class="form-group">
      <label for="name">Package Name: </label>
      <input type="text" class="form-control" value="${pack.packageName}" id="address" placeholder="" name="name" required>
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <div class="form-group">
      <label for="desc">Description: </label>
      <input type="text" class="form-control" value="${pack.description}" id="desc" placeholder="" name="desc" required>
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    
    <div class="form-group">
      <label for="offer">Special Offers: </label>
      <input type="text" class="form-control" value="${pack.specialOffer}" id="offer" placeholder="" name="offer" required>
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <input type="hidden" value="${pack.packageId}" name="packageId">
    <button type="submit" class="btn btn-primary">Update</button>
  </form>
  </div>
</div>


</body>
</html>