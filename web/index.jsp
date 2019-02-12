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
        <style>
            h1{
                color: green;
            }
            p, a{
                color: darkblue;
            }
            .button{
                  background-color: darkblue;
                  border: none;
                  color: white;
                  padding: 15px 32px;
                  margin: 5px;
                  text-align: center;
                  display: inline-block;
                  font-size: 16x;
            }
        </style>
    </head>
    <body>
        <form name="loginForm" method="post" action="LoginServlet">
        <h1>D.M. Office Supplies</h1>
        <p> Username:
            <input type="text" name="usernameTB"> </p> 
        <p> Password:
            <input type="text" name="passwordTB"> </p> 
        <p><a href="null">Create Account</a>
        <a href="null">Continue as guest</a></p> 
        
        <input type="submit" name='logBtn' value='Login' class="button"> 
        <input type='reset' name='resetBtn' value='Clear' class="button">
        </form>
       
        
       
    </body>
</html>
