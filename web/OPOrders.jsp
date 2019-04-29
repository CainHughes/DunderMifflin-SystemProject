<%-- 
    Document   : OPOrders
    Created on : Apr 22, 2019, 1:47:57 PM
    Author     : Madbr
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel = "stylesheet" type = "text/css" href = "SystemProjectCSS.css" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OPP Orders</title>
        <style>
        table, th, td {
        border: 1px solid black;
        }  
        </style>
    </head>
    <body>
          <form name="logout" action="index.jsp">
            <input type="submit" name='logoutBtn' value='Logout'>
        </form> 
     
         <h1>Orders Waiting To Be Shipped</h1>
      <div class="table">   <table border = ".5" width = "100%" bgcolor="green">
                <th>Customer ID</th>
                <th>Item ID</th>
                <th>Quantity</th>
                <th>Item Table</th>
                <th>Shipped</th>
                <%  try{
            String yourDatabase = ("jdbc:ucanaccess://C:/Users/GC3/Desktop/accounts_database.accdb");
            Connection con =
            DriverManager.getConnection(yourDatabase);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Cart WHERE shipped = 'No'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){ %>
                <tr>
                    
                <td><%= rs.getString("custID") %> </td>
                <td><%= rs.getString("itemID") %></td>
                <td><%= rs.getString("quantity") %></td>
                <td><%= rs.getString("itemTable") %></td>
                <td><%= rs.getString("shipped") %></td>
                </tr>
         <%}
            con.close();
        }
        catch(Exception e){
                System.out.println(e);
        }
                
                    %>
            </table>
    <form name="orders" method="post" action="OPOrderServlet">   
            <p align = center> Customer ID:
            <input type="text" name="shipTB"> 
            <input type="submit" value="Ship Order"> </p>
    </form>
      
                 <h1>Orders That Have Been Shipped</h1>
      <div class="table">   <table border = ".5" width = "100%" bgcolor="green">
                <th>Customer ID</th>
                <th>Item ID</th>
                <th>Quantity</th>
                <th>Item Table</th>
                <th>Shipped</th>
                <%  try{
            String yourDatabase = ("jdbc:ucanaccess://C:/Users/GC3/Desktop/accounts_database.accdb");
            Connection con =
            DriverManager.getConnection(yourDatabase);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Cart WHERE shipped = 'Yes'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){ %>
                <tr> 
                <td><%= rs.getString("custID") %> </td>
                <td><%= rs.getString("itemID") %></td>
                <td><%= rs.getString("quantity") %></td>
                <td><%= rs.getString("itemTable") %></td>
                <td><%= rs.getString("shipped") %></td>
                </tr>
         <%}
            con.close();
        }
        catch(Exception e){
                System.out.println(e);
        }
                
                    %>
            </table>
    </body>
</html>