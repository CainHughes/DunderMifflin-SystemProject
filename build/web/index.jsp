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
        <title>JSP Page</title>
        <link rel = "stylesheet" type = "text/css" href = "SystemProjectCSS.css" />
    </head>
    <body>
        <form name="loginForm" method="post" action="LoginServlet">
        <h1>D.M. Office Supplies</h1>
        <p> Username:
            <input type="text" name="usernameTB"> </p> 
        <p> Password:
            <input type="text" name="passwordTB"> </p> 
        <p><a href="CreateAccount.jsp">Create Account</a>
        <a href="null">Continue as guest</a></p> 
        
        <input type="submit" name='logBtn' value='Login' class="button"> 
        <input type='reset' name='resetBtn' value='Clear' class="button">
        
        <a href="OPPlogin.jsp">Order Processing Login</a>
        </form>
    </body>
</html>
