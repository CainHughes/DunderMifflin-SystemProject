
package Servlets;

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
/*************
*Create Account Servlet
*Spring 2019
*Advanced Systems Project
*Office Supplies Project
************/

@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {
    
    /***********************
     * Variable Declarations
     ***********************/
    int accID;
    String uname;
    String pw;
    String fName;
    String lName;
    String email;
    String address;
    String cardType;
    String cardNum;
    int cn;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
            
/********************************
*Set variables with text box data
*********************************/
        uname = request.getParameter("custNametb");
        pw = request.getParameter("custPasstb");
        fName = request.getParameter("fnametb");
        lName = request.getParameter("lnametb");
        email = request.getParameter("emailtb");
        address = request.getParameter("addtb");
        cardNum = request.getParameter("cardNumtb");
        cardType = request.getParameter("cardTypetb");
        cn = Integer.parseInt(cardNum);
        
    
/***********************************
*Create Customer Object 
*Call last Customer Method
*Insert new customer
* set customer object into session
*************************************/  
        try{
            Customer c1 = new Customer();
            c1.selectLastCustomer();
            accID = c1.getAccID();
            String ID = Integer.toString(accID);
            c1.insertCustomer(ID,uname, pw, fName, lName, email, address, cn, cardType);
            HttpSession hs1;
            hs1 = request.getSession();
            hs1.setAttribute("c1", c1);
            System.out.println("Customer was added to the session");
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
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
