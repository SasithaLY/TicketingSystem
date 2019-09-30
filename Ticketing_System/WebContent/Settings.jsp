<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/Header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Settings</title>
</head>
<body>

	<div class="container" style="">
		
		<div style="padding-top:10% ; text-align:center">
			<div style="padding-top:10% ; text-align:center">
			
				<a href="${pageContext.request.contextPath}/UserController?action=balance"><button style="margin: 0 auto; width:60%; height:70px" class="btn btn-primary">Check Account balance</button></a>
			
			</div>
			
			<div style="padding-top:10% ; text-align:center">
			
				<a href="${pageContext.request.contextPath}/"><button style="margin: 0 auto; width:60%; height:70px" class="btn btn-primary">Change Package</button></a>
			
			</div>
			
			<div style="padding-top:10% ; text-align:center">
				<form action="${pageContext.request.contextPath}/UserController?action=EDIT&id=<%=request.getSession().getAttribute("id") %>" method="post">
				<button type="submit" style="margin: 0 auto; width:60%; height:70px" class="btn btn-primary">Edit Profile</button>
				</form>
			</div>
			
			<div style="padding-top:10% ; text-align:center">
			
				<a href="${pageContext.request.contextPath}/PaymentSettings.jsp"><button style="margin: 0 auto; width:60%; height:70px" class="btn btn-primary">Payment Settings</button></a>
			
			</div>
		</div>
		
		
		
	</div>

</body>
</html>