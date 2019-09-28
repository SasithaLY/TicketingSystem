<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/Header.jsp" %> 
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Sign Up</title>

    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body>
    <!-- Start: Registration Form with Photo -->
    <div class="register-photo">
        <!-- Start: Form Container -->
        <div class="form-container">
            <!-- Start: Image -->
          <div class="image-holder"></div>
            <!-- End: Image -->
            <form action="${pageContext.request.contextPath}/UserController?action=REGISTER" method="POST" oninput='up2.setCustomValidity(up2.value != up.value ? "Passwords do not match." : "")'>
                <h2 class="text-center"><strong>Create</strong> an account.</h2>
                <div class="form-group"><input class="shadow-sm form-control" type="text" name="username" required="" placeholder="Username"></div>
                <div class="form-group"><input class="shadow-sm form-control" type="password"  required="" placeholder="Password" minlength="8" name="password"></div>
                <div class="form-group"><input class="shadow-sm form-control" type="password"  required="" placeholder="Password (repeat)" minlength="8" name="repeat-password"></div>
                <input type="hidden" name="logType" value="register">
                <input type="hidden" name="id" value="0">
                <div class="form-group">
                    <div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox" required="">I agree to the terms and conditions.</label></div>
                </div>
                <div class="form-group"><button class="btn btn-primary btn-block shadow-sm" type="submit" style="background-color: rgb(29,120,255);">Sign Up</button></div><a href="${pageContext.request.contextPath}/Login.jsp" class="already">You already have an account? Login here.</a></form>
        </div>
        <!-- End: Form Container -->
    </div>
    <!-- End: Registration Form with Photo -->
    
</body>

</html>