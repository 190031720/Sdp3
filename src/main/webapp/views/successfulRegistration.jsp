<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html lang="en">
    <head>
    
        <title>Registration Success</title>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;500&display=swap" rel="stylesheet">
        <style>
        .container {
        border-radius:10px;
        	margin-top: 15%;
    		width: 40%;
    		height: 30%;
    		display: flex;
    		justify-content: center;
    		align-items: center;
    		scroll-behavior: smooth;
    		background: #FEFCE6 ;
    		font-family:'Helvetica Neue', sans-serif;
		}
		
		
        </style>    
    </head>
    <body bgcolor="#921C20">
        <center>
        <div class="container">
            <h3><center>A verification email has been sent to:   ${emailId}</center></h3> 
         </div>   
        </center>
    </body>
</html>