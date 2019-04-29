<%-- 
    Document   : HelpPage
    Created on : April 8, 2019, 5:27:39 PM
    Author     : Cain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DM Office Supplies</title>
        <link rel = "stylesheet" type = "text/css" href = "SystemProjectCSS.css" />
    </head>
    <body>
        <form name="loginForm" method="post" action="LoginServlet">
        <h1 align = center >D.M. Office Supplies</h1>
        <img src="supplies.jpg" class="cent" height="300" width="150">
        <h1>Frequently Asked Questions</h1>
        <p>Here at D.M. Office Supplies we take customer service very seriously and as such we find that having this webpage allows our customers to quickly find answers
            to some of the most asked questions without having to bother emailing our support or calling us directly. We understand that some questions you 
            may have may not be on this page however and that is why we also have our extremely fast support email address that is available 24/7 and will 
            respond to you within the hour. If you prefer to call our support instead and have a a live person help you with your issue instead then you are more than
            welcome to call us at our support phone number. Both of these options can be found at the end of the FAQ and we appreciate all our customers and truly care about
            their experience here.</p>
        <h1>How do I create an account?</h1>
        <p>The easiest way to create an account is click the hyperlink at the bottom of the page that says Create Account and fill out the form, from there you simply 
            just need to login and you will be taken to your own personalized storefront where you can save your cart for later and save your credit card/address for 
            easier purchases</p>
        <h1>Do I need an account to make a purchase?</h1>
        <p>Absolutely not! our customers are more than welcome to make purchases however they wish with or without an account however we highly recommend making an account if
        you plan on making many purchases here as saving your information help speed up the purchasing process on the customers end!</p>
        <h1>How do I add items to my cart?</h1>
        <p>Once you have found the item you would like to order just look for the item ID# and then at the top of the table you will find a form to fill out with the ID#, Quantity,
            and the section that the Item is in. Once you fill that out and add it to the cart then you are all done.</p>
        <h1>Can I edit my account? If so how?</h1>
        <p>Absolutely! Once you are logged into your account just click the my account button, select the edit/update account option, and then change whatever you would like to change.</p>
        <h1>Did not find your questions?</h1>
        <p>We understand that our webpage cannot have all the answers for all the questions people ask, and that is why we happily provide our customers with a fantastic support staff that is available 24/7 at support@dmofficesupplies.com as well as at the number +1-202-555-0164.</p>
        <p align = center><a href="CreateAccount.jsp">Create Account</a>
            <a href="GuestServlet">Continue as guest</a>
        <a href="OPPlogin.jsp">Order Processing Login</a>
        <a href="HelpPage.jsp">Questions?</a></p>
        <div style="text-align:center;">
        <input type="submit" name='logBtn' value='Login' class="button" align="center"> 
        <input type='reset' name='resetBtn' value='Clear' class="button" align="center">
        </div>
        </form>
    </body>
</html>