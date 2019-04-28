<%-- 
    Document   : Electronic
    Created on : Apr 17, 2019, 9:13:45 PM
    Author     : GC3
--%>

<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!  String yourDatabase = ("jdbc:ucanaccess://C:/Users/donov/Documents/inventory_database.accdb");

    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electronics Catalog</title>
        <link rel = "stylesheet" type = "text/css" href = "SystemProjectCSS.css" />
    </head>
    <body>
        <div class="container">
        <div class="top">
          <div class="top1">
          <h1>D.M. Office Supplies </h1>
          </div>
         <div class="top1">
         <form name="searchForm" method="post" action="SearchServlet">
          <p> 
              <input type="search" name="searchTb" placeholder="Search Products"> 
              <button>Search</button></p>
        </form>
        </div>
            <div class="top1" >
                <a href="#index.jsp">Login Here</a>
                <a href="#ViewCart.jsp"> View Cart</a>
            </div>
        </div>
        
            <div class="middle">
                <ul>
                     <li><a href="AllProducts.jsp">All Products</a></li>
                     <li><a href="Decoration.jsp">Decor</a></li>
                     <li><a href="Electronic.jsp">Electronics</a></li>
                     <li><a href="Furniture.jsp">Furniture</a></li>
                     <li><a href="#AllProducts.jspW/PaperWritingFilter">Paper & Writing</a></li>
                     <li><a href="ViewAccount.jsp">My Account</a></li>
                </ul>
            </div>
        </div>
            
            
        <h2>Electronics Catalog</h2>
        <img src="electronic.jpg" height="200" width="400"/>
        <p>Type electronic ID# here to add to cart</p>
	<form action="AddToCart" method="post">
            <input type="number" id="itemID" name="itemID" placeholder="Enter ID Here">
            <input type="number" id="quantity" name="quantity" placeholder="Quantity">
            <input type="text" name="databaseLocation" value="Electronics">
            <input type="submit" value="Add To Cart">
	</form>
        <div class="table">   <table border = ".5" width = "100%" bgcolor="green">
                <th>ID</th>
                <th>Item Name</th>
                <th>Stock</th>
                <th>Price</th>
                <th>Manufacturer</th>
                <th>Model Number</th>
                <th>Description</th>
                <%  try{
            Connection con =
            DriverManager.getConnection(yourDatabase);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Electronics";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){ %>
                <tr>
                    
                <td><%= rs.getString("ID") %> </td>
                <td><%= rs.getString("ItemName") %></td>
                <td><%= rs.getInt("Stock") %></td>
                <td>$<%= rs.getDouble("Price") %></td>
                <td><%= rs.getString("Manufacturer") %></td>
                <td><%= rs.getString("ModelNumber") %></td>
                <td> <%= rs.getString("Description") %></td>
                </tr>
         <%}
            con.close();
        }
        catch(Exception e){
                System.out.println(e);
        }
                
                    %>
            </table>
        </div>
        
    </body>
</html>