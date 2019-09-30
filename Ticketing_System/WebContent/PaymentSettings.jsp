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

	<div class="container" style="">
		
		<div style="padding-top:10% ; text-align:center">
			<div style="padding-top:10% ; text-align:center">
			
				<a href="${pageContext.request.contextPath}/UserController?action=balance"><button style="margin: 0 auto; width:60%; height:70px" class="btn btn-primary">Reload</button></a>
			
			</div>
			
			<div style="padding-top:10% ; text-align:center">
			
				<a href="${pageContext.request.contextPath}/"><button style="margin: 0 auto; width:60%; height:70px" class="btn btn-primary">Request Loan</button></a>
			
			</div>
			
			<div style="padding-top:10% ; text-align:center">
				
				<a href="${pageContext.request.contextPath}/AddCreditCard.jsp"><button style="margin: 0 auto; width:60%; height:70px" class="btn btn-primary">Store Credit Card</button></a>
			
			</div>
			
			
		</div>
		
		
		
	</div>
</body>
</html>