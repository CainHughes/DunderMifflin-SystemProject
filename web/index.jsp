<%-- 
    Document   : index
    Created on : Jan 31, 2019, 4:48:09 PM
    Author     : Madbr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DM Office Supplies</title>
        <link rel = "stylesheet" type = "text/css" href = "SystemProjectCSS.css" />
    </head>
    <body>
        <form name="loginForm" method="post" action="LoginServlet">
        <h1 align = center >D.M. Office Supplies</h1>
        <img src="supplies.jpg" class="cent" height="300" width="150">
        <p align = center> Username:
            <input type="text" name="usernameTB"> </p> 
        <p align = center> Password:
            <input type="text" name="passwordTB"> </p> 
        <p align = center><a href="CreateAccount.jsp">Create Account</a>
            <a href="null">Continue as guest</a>
        <a href="OPPlogin.jsp">Order Processing Login</a></p>
        <div style="text-align:center;">
        <input type="submit" name='logBtn' value='Login' class="button" align="center"> 
        <input type='reset' name='resetBtn' value='Clear' class="button" align="center">
        </div>
        </form>
    </body>
</html>
