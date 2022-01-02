<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign in</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
    background-color: #921C20;
}
.main{
    background-color: #921C20;
}

    .container
    {
         background-color: #FEFCE6; 

    }
    #username,#pass
    {
        background-color: #FEFCE6;
    }
    #signin
    {
        background-color: #921C20;
    }
</style>
</head>
<body>

    <div class="main">

        
        <!-- Sign in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="images/Logo.png" alt="sign in"></figure>
                        
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title"><center>Super Admin Login</center></h2>
                        <br>
                        <br>
                        <form method="POST" action="superuserlogin" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="Username"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="username" id="username" path="username" placeholder="Your Name"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="pass" path="username" placeholder="Password"/>
                            </div>
                            
                            <div class="form-group form-button">
                                <center>
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in" />
                            </center>
                            </div>

                    
                        </form>
                        
                    </div>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>