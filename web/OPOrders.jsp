<%-- 
    Document   : OPOrders
    Created on : Apr 22, 2019, 1:47:57 PM
    Author     : Madbr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        table, th, td {
        border: 1px solid black;
        }  
        </style>
    </head>
    <body>
     <form name="orders" method="post" action="OrderStatusServlet">   
         <h1>Orders</h1>
    <table>
      <tr>
       <th>Order ID</th>
       <th>Customer ID</th>
       <th>Status</th>
      </tr>
      
     <tr>
       <td> 12 </td>
       <td>  3 </td>
       <td>  <select id="status" name="status">
           <option value="Open">Open</option>
           <option value="Shipped">Shipped</option>
         </select> </td>
     </tr> 

    </table> 
        <input type="submit" value="Submit">
    </form>
        <form name="logout" action="index.jsp">
            <input type="submit" name='logoutBtn' value='Logout'>
        </form>
    </body>
</html>
