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
                     <li><a href="PaperWriting.jsp">Paper & Writing</a></li>
                     <li><a href="ViewAccount.jsp">My Account</a></li>
                </ul>
            </div>
        
            
            <div class="bottom">
                <h2>Top Sellers!</h2>
                <table style="width:100%">
                    <tr>
                        <th>Decor Product Details</th>
                        <th>Electronic Product Details</th> 
                        <th>Furniture Product Details</th>
                        <th>Paper & Writing Product Details</th> 
                    </tr>
                    <tr>
                        <td><img alt="Decor Product Picture"></td>
                        <td><img alt="Electronic Product Picture"></td>
                        <td><img alt="Furniture Product Picture"></td>
                        <td><img alt="Paper & Writing Product Picture"></td>
                    </tr>
                    <tr>
                        <td>Price $</td>
                        <td>Price $</td>
                        <td>Price $</td>
                        <td>Price $</td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
