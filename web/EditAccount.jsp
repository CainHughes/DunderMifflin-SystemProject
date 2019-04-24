<%-- 
Edit Account JSP
--%>

<%@page import="BusinessObjects.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Account</title>
        <link rel = "stylesheet" type = "text/css" href = "SystemProjectCSS.css" />
    </head>
    <body>
        <%!String user;
           String pass;
           String fname;
           String lname;
           String email;
           String add;
           int cardNum;
           String cardType;
           Customer c1;
            %>
        <form action = "EditAccountServlet" method = "Post">
        <h1>Please Enter Account Changes</h1><br>
                <% try{
               HttpSession ses1;
               ses1 = request.getSession();
               c1 = (Customer)ses1.getAttribute("c1");
               user = c1.getUsername();
               pass = c1.getPassword();
               fname = c1.getFName();
               lname = c1.getLName();
               email = c1.getEmail();
               add = c1.getAddress();
               cardNum = c1.getCardNum();
               cardType = c1.getCardType();
              } 
            catch(Exception e){
            }
        %>
        UserName: <input type="text" name="custNametb" value=<%= user %>><br>
        Password: <input type="text" name="custPasstb" value=<%=pass %>><br>
        First Name: <input type="text" name="fnametb" value=<%=fname%>><br>
        Last Name: <input type="text" name="lnametb" value=<%=lname%>><br>
        Email Address: <input type="text" name="emailtb" value=<%=email%>><br>
        Address:<input type="text" name="addtb" value=<%=add%>><br>
        Card Number:<input type="text" name="cardNumtb" value=<%=cardNum%>><br>
        Card Type:<input type="text" name="cardTypetb" value=<%=cardType%>><br>
        <input type="submit" name= "updateinfobtn"value="Submit Changes" class="button"/>
        <input type="reset" value="Clear" class="button"/><br>
        </form>
    </body>
</html>
