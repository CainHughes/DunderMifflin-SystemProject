<%-- 
    Document   : OPPlogin
    Created on : Apr 22, 2019, 1:14:20 PM
    Author     : Madbr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OPP Login</title>
        <link rel = "stylesheet" type = "text/css" href = "SystemProjectCSS.css" />
    </head>
    <body>
        <form name="loginForm" method="post" action="OPPLoginServlet">
        <h1>D.M. Office Supplies</h1>
        <h2>Order Processing Login</h2>
        <p> Username:
            <input type="text" name="usernameTB"> </p> 
        <p> Password:
            <input type="text" name="passwordTB"> </p>
        
        <input type="submit" name='logBtn' value='Login' class="button"> 
        <input type='reset' name='resetBtn' value='Clear' class="button">
        </form>
    </body>
</html>
