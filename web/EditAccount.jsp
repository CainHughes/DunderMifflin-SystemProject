<%-- 
Edit Account JSP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Account</title>
        <link rel = "stylesheet" type = "text/css" href = "SystemProjectCSS.css" />
    </head>
    <body>
        <form action = "http://localhost:8080/ChattBank/EditAccountServlet" method = "Post">
        <h1>Please Enter Account Changes</h1><br>
        UserName: <input type="text" name="newUsernametb"/><br><br>
        Password: <input type="text" name="newPasswordtb"/><br><br>
        First Name: <input type="text" name="newfntb"/><br><br>
        Last Name: <input type="text" name="newlntb"/><br><br>
        Email Address: <input type="text" name="newEmailtb"/><br><br>
        <input type="submit" name= "updateinfobtn"value="Submit Changes" class="button"/>
        <input type="reset" value="Clear" class="button"/><br>
        </form>
    </body>
</html>
