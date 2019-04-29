/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BusinessObjects.Cart;
import BusinessObjects.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "GuestServlet", urlPatterns = {"/GuestServlet"})
public class GuestServlet extends HttpServlet {
    
    /***********************
     * Variable Declarations
     ***********************/
    int accID;
    String uname = "guest";
    String pw = "guest";
    String fName = "guest";
    String lName = "guest";
    String email = "guest@guest.com";
    String address = "guestaddress";
    String cardType = "guest";
    int cn = 000;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        
    
/***********************************
*Creates customer object
*Populates customer object with guest information
*initializes cart object inside customer object
*Automatically logins to guest account
*************************************/  
        try{
            Customer c1 = new Customer();
            c1.selectLastCustomer();
            accID = c1.getAccID();
            String ID = Integer.toString(accID);
            uname = (uname+Integer.toString(accID));
            c1.insertCustomer(ID,uname, pw, fName, lName, email, address, cn, cardType);
            c1.selectCustomerLogin(uname);
            c1.cart = new Cart(Integer.toString(c1.getAccID()));
            c1.cart.selectDB();
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("c1", c1);
            System.out.println("Customer was added to the session");
                RequestDispatcher rd = request.getRequestDispatcher("/GuestHomePage.jsp");
                    rd.forward(request, response);   
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
