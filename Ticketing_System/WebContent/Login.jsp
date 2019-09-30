<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="assets/css/styles.min.css">
</head>
<body>
    <!-- Start: Login Form Clean -->
    <div class="login-clean">
        <form action="${pageContext.request.contextPath}/UserController?action=LOGIN" method="POST">
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration"><img class="img-responsive" style="" alt="Logo" width="auto" height="auto" src="assets/img/loginIcon.png"></div>
            <div class="form-group"><input class="form-control" type="text" name="username" placeholder="Username" required></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password" required></div>
            <input type="hidden" name="logType" value="login">
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color: rgb(29,120,255);">Log In</button></div><a href="Register.jsp" class="forgot">Need an account?<b style="color:#258FF9"> Sign up</b></a></form>
    </div>
    
</body>
</html>