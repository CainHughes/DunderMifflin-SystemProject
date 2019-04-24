<%-- 
    Document   : Homepage
    Created on : Mar 8, 2019, 1:37:48 PM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Furniture Catalog</title>
        <link rel = "stylesheet" type = "text/css" href = "SystemProjectCSS.css" />
    </head>
    <body>
        <div class="container">
        <div class="top">
          <div class="top1">
          <h1>D.M. Office Supplies </h1>
            <h2>Create new Account</h2>
            <form action = "CreateAccountServlet" method = "Post">
            <p> UserName:<input type="text" name="custNametb"/><br>
            Password:<input type="text" name="custPasstb"/><br>
            First Name:<input type="text" name="fnametb"/><br>
            Last Name:<input type="text" name="lnametb"/><br>
            Email:<input type="text" name="emailtb"/><br>
            Address:<input type="text" name="addtb"/><br>
            Card Number:<input type="text" name="cardNumtb"/><br>
            Card Type:<input type="text" name="cardTypetb"/><br></p>
            <input type="submit" name= "createbtn"value="Create new Account" class="button"/>
            <input type="reset" value="Clear" class="button"/><br>
            <a href="index.jsp">Return to the previous screen</a></p> 
        </form>
            </div>
        </div>
    </body>
</html>

