<%-- 
    Document   : ViewCart
    Created on : Apr 28, 2019, 9:15:27 PM
    Author     : GC3
--%>


<%@page import="BusinessObjects.Cart"%>
<%@page import="BusinessObjects.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>D.M. Office Homepage</title>
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
                <a href="index.jsp">Login Here</a>
                <a href="ViewCart.jsp">View Cart</a>
                  
            </div>
        </div>
        
            <div class="middle">
                <ul>
                     <li><a href="GuestHomePage.jsp">All Products</a></li>
                     <li><a href="GuestDecoration.jsp">Decor</a></li>
                     <li><a href="GuestElectronic.jsp">Electronics</a></li>
                     <li><a href="GuestFurniture.jsp">Furniture</a></li>
                     <li><a href="GuestPaperWriting.jsp">Paper & Writing</a></li>
                </ul>
            </div>
        
            
            <div class="bottom">
                <h2 align="center">Current Cart</h2>
            
            </div>
        </div>
    </body>
</html>

