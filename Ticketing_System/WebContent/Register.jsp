<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
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
            <form method="post">
                <h2 class="text-center"><strong>Create</strong> an account.</h2>
                <div class="form-group"><input class="shadow-sm form-control" type="text" name="Username" required="" placeholder="Username"></div>
                <div class="form-group"><input class="shadow-sm form-control" type="password" name="password" required="" placeholder="Password" minlength="8"></div>
                <div class="form-group"><input class="shadow-sm form-control" type="password" name="password-repeat" required="" placeholder="Password (repeat)" minlength="8"></div>
                <div class="form-group">
                    <div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox" required="">I agree to the license terms.</label></div>
                </div>
                <div class="form-group"><button class="btn btn-primary btn-block shadow-sm" type="submit" style="background-color: rgb(29,120,255);">Sign Up</button></div><a href="#" class="already">You already have an account? Login here.</a></form>
        </div>
        <!-- End: Form Container -->
    </div>
    <!-- End: Registration Form with Photo -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>

</html>