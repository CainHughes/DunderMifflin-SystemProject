<%-- 
    Document   : GuestHomePage
    Created on : Apr 28, 2019, 8:47:51 PM
    Author     : GC3
--%>

<%-- 
    Document   : Homepage
    Created on : Mar 8, 2019, 1:37:48 PM
--%>

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
                <a href="GuestViewCart.jsp">View Cart</a>
                  
            </div>
        </div>
        
            <div class="middle">
                <ul>
                     <li><a href="GuestHomePage.jsp">All Products</a></li>
                     <li><a href="GuestDecoration.jsp">Decor</a></li>
                     <li><a href="Electronic.jsp">Electronics</a></li>
                     <li><a href="Furniture.jsp">Furniture</a></li>
                     <li><a href="PaperWriting.jsp">Paper & Writing</a></li>
                </ul>
            </div>
        
            
            <div class="bottom">
                <h2 align="center">Top Sellers!</h2>
                <table style="width:100%">
                    <tr>
                        <th>Decoration</th>
                        <th>Electronics</th> 
                        <th>Furniture</th>
                        <th>Paper & Writing</th> 
                    </tr>
                     <tr>
                        <th>Metal Art Wall Gear Clock</th>
                        <th>HP 15.6-Inch HD Touchscreen Laptop</th> 
                        <th>Palmetto Computer Desk</th>
                        <th>Composition Notebook</th> 
                    </tr>
                    <tr>
                        <th><img src="decorTopSeller.jpg" alt="Decoration Product Picture" width="250" height="200"></th>
                        <th><img src="electronicTopSeller.jpg" alt="Electronic Product Picture" width="250" height="200"></th>
                        <th><img src="furnitureTopSeller.jpg" alt="Furniture Product Picture"width="250" height="200"></th>
                        <th><img src="paperTopSeller.jpg" alt="Paper & Writing Product Picture" width="250" height="200"></th>
                    </tr>
                    <tr>
                        <th>$147.99</th>
                        <th>$286.00</th>
                        <th>$149.99</th>
                        <th>$0.52</th>
                    </tr>
                    <tr>
                        <th>Surrounding yourself with beautiful objects that reflect your personal aesthetics can enhance time spent at home or in the office.</th>
                        <th>Another budget friendly laptop but with an intel pentium processor, 4 gb of ram, and 1 TB of HDD storage including windows 10 and a HD webcam</th>
                        <th>Desk with tempered glass top and metal legs and frame; two built-in storage shelves</th>
                        <th>Single Marble Composition Notebook with 40 sheets</th>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
