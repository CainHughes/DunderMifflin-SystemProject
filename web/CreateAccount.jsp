

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="all" href="styles.css">
        <title>New Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel = "stylesheet" type = "text/css" href = "SystemProjectCSS.css" />
    </head>
    <body>
        <h1>Create new Customer Account</h1>
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
    </body>
</html>
