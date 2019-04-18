<%-- 
    Document   : ViewAccount
    Created on : Apr 16, 2019, 8:39:57 PM
    Author     : GC3
--%>
<%@page import="BusinessObjects.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                     <li><a href="#AllProducts.jspW/DecorFilter">Decor</a></li>
                     <li><a href="#AllProducts.jspW/ElectronicsFilter">Electronics</a></li>
                     <li><a href="Furniture.jsp">Furniture</a></li>
                     <li><a href="#AllProducts.jspW/PaperWritingFilter">Paper & Writing</a></li>
                     <li><a href="ViewAccount.jsp">My Account</a></li>
                </ul>
            </div>
            <%! 
                String userName;
                String pw;
                String fName;
                String lName;
                String email;
                String add;
                String cardType;
                int cardNum;
                Customer c1;
             %>
            <% try{
                HttpSession ses1;
                ses1 = request.getSession();
                c1 = (Customer)ses1.getAttribute("c1");
                userName = c1.getUsername();
                pw = c1.getPassword();
                fName = c1.getFName();
                lName = c1.getLName();
                email = c1.getEmail();
                add = c1.getAddress();
                cardType = c1.getCardType();
                cardNum = c1.getCardNum();
                
                }
               catch(Exception e){
               }
            %>
            
            <div class="bottom">
                <h2>Account Details for <%= fName %></h2>
                <p>User Name: <%= userName %> <br>
                   Password: <%= pw %> <br>
                   First Name: <%= fName %> <br>
                   Last Name: <%= lName %><br>
                   Email: <%= email %> <br>
                   Address: <%= add %> <br>
                   Card Number: <%= cardNum %> <br>     
                   Card Type: <%= cardType %> </p>
            <a href="EditAccount.jsp">Edit/Update Account</a>
            <h2>Purchased Items</h2>
            <table border ="1">
                <th>Item Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Date Ordered</th>
            </table>
            </div>
        </div>
    </body>
</html>
